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
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.JenisKlinikServices;
import rumahsakit.services.KlinikServices;
import rumahsakit.services.PasienServices;

/**
 *
 * @author sou
 */
@Controller
public class KlinikController {

    @Autowired
    JenisKlinikServices jenisKlinikServices;

    @Autowired
    PasienServices pasienServices;

    @Autowired
    KlinikDao klinikDao;

    @Autowired
    KlinikServices klinikServices;

    @RequestMapping(value = "/viewKlinik", method = RequestMethod.GET)
    public String viewKlinik(ModelMap modelMap, KlinikDto klinikDto, UserDto userDto, HttpSession session) throws Exception {
        List<KlinikDto> listKlinik = null;
        List<JenisKlinikDto> listJenisKlinik = null;
        List<PasienDto> pasienKlinik = null;
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
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
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("klinikDto", klinikDto);
                    return "poliKlinik/viewKlinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/rawatPasien", method = RequestMethod.GET)
    public String rawatPasien(ModelMap modelMap, PasienDto pasienDto, Integer index, KlinikDto klinikDto) throws Exception {
        List<PasienDto> pasienMenunggu = null;
        pasienMenunggu = pasienServices.listPasienMenunggu();
        Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
        modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
        modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        
        //klinikServices.insertIdPasien(index);
        KlinikDto kd = klinikServices.listKlinikUpdate(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("klinikDto", klinikDto);
        modelMap.addAttribute("id", kd);
        modelMap.addAttribute("index", index);
        return "poliKlinik/viewFormRawatPasien";
    }

    @RequestMapping(value = "/form_tambah_klinik", method = RequestMethod.GET)
    public String viewFormTambahKlinik(ModelMap modelMap, KlinikDto klinikDto, UserDto userDto, HttpSession session) throws Exception {
        List<KlinikDto> listKlinik = null;
        List<JenisKlinikDto> listJenisKlinik = null;
        List<PasienDto> pasienKlinik = null;
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            listKlinik = klinikServices.listKlinik();
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
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("klinikDto", klinikDto);
                    return "poliKlinik/tambah_klinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewPasienKlinik", method = RequestMethod.GET)
    public String viewPasienKlinik(KlinikDto klinikDto, ModelMap modelMap, UserDto userDto, PasienDto pasienDto, HttpSession session) throws Exception {
        List<PasienDto> listPasien = null;
        List<PasienDto> listPasienBerita = null;
        try {
            
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            modelMap.addAttribute("klinikDto", klinikDto);
            listPasien = pasienServices.listPasien();
            listPasienBerita = pasienServices.listPasienBerita();
            String waktu = pasienServices.waktuSekarang();
            Integer index = pasienServices.jumlahPasien();
            modelMap.addAttribute("waktu", waktu);
            modelMap.addAttribute("jumlah", index);
            modelMap.addAttribute("pasienDto", pasienDto);
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listPasienBerita", listPasienBerita);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    return "poliKlinik/viewPasienKlinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/view_update_klinik", method = RequestMethod.GET)
    public String viewUpdateKlinik(ModelMap modelMap, KlinikDto klinikDto, Integer index, UserDto userDto, HttpSession session) throws Exception {
        List<JenisKlinikDto> listJenisKlinik = null;
        List<PasienDto> pasienKlinik = null;
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            klinikDto = klinikServices.listKlinikUpdate(index);
            pasienKlinik = pasienServices.listPasien();
            modelMap.addAttribute("listPasien", pasienKlinik);
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("klinikDto", klinikDto);
                    return "poliKlinik/updateKlinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }

        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/rekam_medis_klinik", method = RequestMethod.GET)
    public String viewRekam(ModelMap modelMap, PasienDto pasienDto, UserDto userDto, HttpSession session) throws Exception {
        List<PasienDto> listPasien = null;
        List<PasienDto> listPasienBerita = null;
        listPasien = pasienServices.listPasien();
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            listPasienBerita = pasienServices.listPasienBerita();
            String waktu = pasienServices.waktuSekarang();
            Integer index = pasienServices.jumlahPasien();
            modelMap.addAttribute("waktu", waktu);
            modelMap.addAttribute("jumlah", index);
            modelMap.addAttribute("pasienDto", pasienDto);
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listPasienBerita", listPasienBerita);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    return "poliKlinik/rekam_medis";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }

        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveKlinik", method = RequestMethod.POST)
    public String saveKlinik(ModelMap modelMap, KlinikDto klinikDto) throws Exception {
        klinikServices.saveDataKlinik(klinikDto);
        return "redirect:viewKlinik.htm";
    }

    @RequestMapping(value = "/ubahDataKlinik", method = RequestMethod.POST)
    public String ubahKlinik(ModelMap modelMap, KlinikDto klinikDto) throws Exception {
        klinikServices.updateDataKlinik(klinikDto);
        return "redirect:viewKlinik.htm";
    }

    @RequestMapping(value = "/deleteKlinik", method = RequestMethod.GET)
    public String deleteKlinik(Integer index, ModelMap modelMap, KlinikDto klinikDto) throws Exception {
        klinikServices.hapusKlinik(index);
        return "redirect:viewKlinik.htm";
    }

    @RequestMapping(value = "/updateIdKlinik", method = RequestMethod.GET)
    public String updateIdKlinik(ModelMap modelMap, KlinikDto klinikDto) throws Exception {
        //klinikServices.updateIdKlinik(klinikDto);
        klinikServices.insertIdPasien(klinikDto);
        pasienServices.updateKeteranganPasien(klinikDto.getId_pasien());
        return "redirect:viewKlinik.htm";
    }

}
