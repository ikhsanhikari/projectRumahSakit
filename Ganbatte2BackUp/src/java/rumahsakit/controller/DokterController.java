/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rumahsakit.dao.KlinikDao;
import rumahsakit.dto.JenisKlinikDto;
import rumahsakit.dto.KeluhanDto;
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatKeluarDto;
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.TindakanDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.JenisKlinikServices;
import rumahsakit.services.KlinikServices;
import rumahsakit.services.ObatKeluarServices;
import rumahsakit.services.ObatServices;
import rumahsakit.services.PasienServices;

/**
 *
 * @author hikari
 */
@Controller
public class DokterController {

    @Autowired
    JenisKlinikServices jenisKlinikServices;

    @Autowired
    PasienServices pasienServices;

    @Autowired
    KlinikDao klinikDao;

    @Autowired
    KlinikServices klinikServices;

    @Autowired
    ObatKeluarServices obatKeluarServices;
    
    @Autowired
    ObatServices obatServices;

    @RequestMapping(value = "/viewHikari", method = RequestMethod.GET)
    public String getHikari(ModelMap modelMap) throws Exception {
        List<KlinikDto> klinikMenunggu = null;
        klinikMenunggu = klinikServices.listKlinikRawatInap();
        modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
        return "hikari";
    }

    @RequestMapping(value = "/viewPasienDokter", method = RequestMethod.GET)
    public String viewPasienDokter(KlinikDto klinikDto, ModelMap modelMap, UserDto userDto, PasienDto pasienDto, HttpSession session) throws Exception {
        List<KlinikDto> listKlinik = null;
        List<JenisKlinikDto> listJenisKlinik = null;
        List<PasienDto> pasienKlinik = null;
        try {
            String getKeluhan = klinikServices.getKeluhan(7);
            modelMap.addAttribute("getKeluhan", getKeluhan);
            String getTindakan = klinikServices.getTindakan(7);
            modelMap.addAttribute("getTindakan", getTindakan);
            List<KlinikDto> klinikMenunggu = null;
            klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
            Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
            modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
            modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            listKlinik = klinikServices.listKlinikNative();
            pasienKlinik = pasienServices.listPasien();
            modelMap.addAttribute("listKlinik", listKlinik);
            modelMap.addAttribute("listPasien", pasienKlinik);
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("dokter")) {
                    modelMap.addAttribute("klinikDto", klinikDto);
                    return "dokter/viewPasienDokter";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewPasienSudahDiperiksa", method = RequestMethod.GET)
    public String viewPasienSudahDiperiksa(KlinikDto klinikDto, ModelMap modelMap, UserDto userDto, PasienDto pasienDto, HttpSession session) throws Exception {
        List<KlinikDto> listKlinik = null;
        List<JenisKlinikDto> listJenisKlinik = null;
        List<PasienDto> pasienKlinik = null;
        try {
            List<KlinikDto> listSudahDiPeriksa = klinikServices.listKlinikDokterSudahDiPeriksa();
            modelMap.addAttribute("klinikSudahDiPeriksa", listSudahDiPeriksa);
            String getKeluhan = klinikServices.getKeluhan(7);
            modelMap.addAttribute("getKeluhan", getKeluhan);
            String getTindakan = klinikServices.getTindakan(7);
            modelMap.addAttribute("getTindakan", getTindakan);
            List<KlinikDto> klinikMenunggu = null;
            klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
            Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
            modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
            modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            listKlinik = klinikServices.listKlinikNative();
            pasienKlinik = pasienServices.listPasien();
            modelMap.addAttribute("listKlinik", listKlinik);
            modelMap.addAttribute("listPasien", pasienKlinik);
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("dokter")) {
                    modelMap.addAttribute("klinikDto", klinikDto);
                    return "dokter/viewPasienSudahDiperiksa";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/pilihan", method = RequestMethod.GET)
    public String pilihan(ModelMap modelMap, PasienDto pasienDto, Integer index, KlinikDto klinikDto) throws Exception {
        KlinikDto klinik = null;
        klinik = klinikServices.listKlinikNative(index);
        modelMap.addAttribute("listKlinikNative", klinik);
        String getKeluhan = klinikServices.getKeluhan(7);
        modelMap.addAttribute("getKeluhan", getKeluhan);
        String getTindakan = klinikServices.getTindakan(7);
        modelMap.addAttribute("getTindakan", getTindakan);
        List<KlinikDto> klinikMenunggu = null;
        klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
        Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
        modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
        modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        pasienServices.updateKeteranganPasien(index);
        KlinikDto kd = klinikServices.getKlinik(index);
        klinikDto = klinikServices.listKlinikUpdate(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("klinikDto", klinikDto);
        modelMap.addAttribute("listKlinik", kd);
        modelMap.addAttribute("index", index);
        return "dokter/formPilihan";
    }

    @RequestMapping(value = "/rawatPasienByDokter", method = RequestMethod.GET)
    public String rawatPasien(ModelMap modelMap, PasienDto pasienDto, Integer index, KlinikDto klinikDto) throws Exception {
        String getKeluhan = klinikServices.getKeluhan(7);
        modelMap.addAttribute("getKeluhan", getKeluhan);
        String getTindakan = klinikServices.getTindakan(7);
        modelMap.addAttribute("getTindakan", getTindakan);
        List<KlinikDto> klinikMenunggu = null;
        klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
        Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
        modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
        modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        pasienServices.updateKeteranganPasien(index);
        KlinikDto kd = klinikServices.getKlinik(index);
        klinikDto = klinikServices.listKlinikUpdate(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("klinikDto", klinikDto);
        modelMap.addAttribute("listKlinik", kd);
        modelMap.addAttribute("index", index);
        return "dokter/formRawatPasienByDokter";
    }

    @RequestMapping(value = "/saveObatKeluarPasien", method = RequestMethod.POST)
    public String saveObatKeluar(ObatKeluarDto obatKeluarDto) {
        try {
            obatKeluarServices.saveDataObatKeluar(obatKeluarDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewPasienDokter.htm";
    }
    
    @RequestMapping(value = "/obatKeluarPasien", method = RequestMethod.GET)
    public String obatKeluarPasien(ModelMap modelMap, Integer index, ObatKeluarDto obatKeluarDto) throws Exception {
        List<KlinikDto> klinikMenunggu = null;
        PasienDto pasienDto = null;
        List<ObatDto> listObat = null;
        listObat = obatServices.listObat();
        modelMap.addAttribute("listObat", listObat);
        klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
        Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
        modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
        modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        //pasienServices.updateKeteranganPasien(index);
        KlinikDto kd = klinikServices.getKlinik(index);
        //obatKeluarDto = obatKeluarServices.getListObatKeluarUpdate(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("obatKeluarDto", obatKeluarDto);
        modelMap.addAttribute("listKlinik", kd);
        modelMap.addAttribute("index", index);
        return "dokter/formObatKeluarPasien";
    }

    @RequestMapping(value = "/formTambahKeluhan", method = RequestMethod.GET)
    public String formTambahKeluhan(ModelMap modelMap, PasienDto pasienDto, Integer index, KeluhanDto keluhanDto) throws Exception {
        List<KlinikDto> klinikMenunggu = null;
        klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
        Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
        modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
        modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        pasienServices.updateKeteranganPasien(index);
        KlinikDto kd = klinikServices.getKlinik(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("keluhanDto", keluhanDto);
        modelMap.addAttribute("listKlinik", kd);
        modelMap.addAttribute("index", index);
        return "dokter/formTambahKeluhan";
    }

    @RequestMapping(value = "/formTambahTindakan", method = RequestMethod.GET)
    public String formTambahTindakan(ModelMap modelMap, PasienDto pasienDto, Integer index, TindakanDto tindakanDto) throws Exception {
        List<KlinikDto> klinikMenunggu = null;
        klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
        Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
        modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
        modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        pasienServices.updateKeteranganPasien(index);
        KlinikDto kd = klinikServices.getKlinik(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("tindakanDto", tindakanDto);
        modelMap.addAttribute("listKlinik", kd);
        modelMap.addAttribute("index", index);
        return "dokter/formTambahTindakan";
    }

    @RequestMapping(value = "/updateKlinikByDokter", method = RequestMethod.POST)
    public String updateIdKlinik(ModelMap modelMap, KlinikDto klinikDto) throws Exception {
        klinikServices.updateDataKlinik(klinikDto);
        return "redirect:viewPasienDokter.htm";
    }

    @RequestMapping(value = "/saveKeluhan", method = RequestMethod.POST)
    public String saveKeluhan(ModelMap modelMap, KeluhanDto keluhanDto) throws Exception {

        klinikServices.saveKeluhan(keluhanDto);
        return "redirect:viewPasienDokter.htm";
    }

    @RequestMapping(value = "/saveTindakan", method = RequestMethod.POST)
    public String saveTindakan(ModelMap modelMap, TindakanDto tindakanDto) throws Exception {
        klinikServices.saveTindakan(tindakanDto);
        return "redirect:viewPasienDokter.htm";
    }

    @RequestMapping(value = "/homeDokter", method = RequestMethod.GET)
    public String homeDokter(ModelMap modelMap, KlinikDto klinikDto) throws Exception {
        List<KlinikDto> klinikSudahDiPeriksa = null;
        klinikSudahDiPeriksa = klinikServices.listKlinikDokterSudahDiPeriksa();
        modelMap.addAttribute("klinikSudahDiPeriksa", klinikSudahDiPeriksa);
        List<KlinikDto> klinikMenunggu = null;
        klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
        Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
        modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
        modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
        List<PasienDto> pasienMenunggu = null;
        pasienMenunggu = pasienServices.listPasienMenunggu();
        modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
        String waktu = pasienServices.waktuSekarang();
        Integer index = pasienServices.jumlahPasien();
        modelMap.addAttribute("waktu", waktu);
        modelMap.addAttribute("jumlah", index);
        return "dokter/home";
    }
}
