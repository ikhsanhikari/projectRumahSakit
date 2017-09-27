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
import rumahsakit.dto.JenisKlinikDto;
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.NomorRuanganDto;
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.RawatInapDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.JenisKlinikServices;
import rumahsakit.services.KlinikServices;
import rumahsakit.services.NomorRuanganServices;
import rumahsakit.services.PasienServices;
import rumahsakit.services.RawatInapServices;

/**
 *
 * @author hikari
 */
@Controller
public class RawatInapController {

    @Autowired
    PasienServices pasienServices;

    @Autowired
    RawatInapServices rawatInapServices;

    @Autowired
    NomorRuanganServices nomorRuanganServices;

    @Autowired
    KlinikServices klinikServices;

    @Autowired
    JenisKlinikServices jenisKlinikServices;

    @RequestMapping(value = "/rawatInapPasien", method = RequestMethod.GET)
    public String rawatInapPasien(ModelMap modelMap, PasienDto pasienDto, Integer index, RawatInapDto rawatInapDto) throws Exception {
        List<KlinikDto> klinikMenunggu = null;
        Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
        klinikMenunggu = klinikServices.listKlinikRawatInap();
        modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
        modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
        List<PasienDto> pasienMenunggu = null;
        List<NomorRuanganDto> listNomor = nomorRuanganServices.listRuangan();
        modelMap.addAttribute("listNomorRuangan", listNomor);
        pasienMenunggu = pasienServices.listPasienMenunggu();
        Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
        modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
        modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
        List<JenisKlinikDto> listJenisKlinik = null;
        pasienDto = pasienServices.getListPasienUpdate(index);
        modelMap.addAttribute("data", pasienDto);
        listJenisKlinik = jenisKlinikServices.listJenisKlinik();
        KlinikDto kd = klinikServices.listKlinikUpdate(index);
        modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
        modelMap.addAttribute("rawatInapDto", rawatInapDto);
        modelMap.addAttribute("id", kd);
        modelMap.addAttribute("index", index);
        return "RawatInap/formRawatInap";
    }

    @RequestMapping(value = "/homeRawatInap", method = RequestMethod.GET)
    public String homeRawatInap(UserDto userDto, ModelMap modelMap, RawatInapDto rawatInapDto, HttpSession session) throws Exception {
        List<RawatInapDto> listRawatInap = null;
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            listRawatInap = rawatInapServices.listRawatInapNative();
            modelMap.addAttribute("listRawatInap", listRawatInap);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/home";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewRawatInap", method = RequestMethod.GET)
    public String viewRawatInap(ModelMap modelMap, RawatInapDto rawatInapDto, HttpSession session, UserDto userDto) throws Exception {
        List<RawatInapDto> listRawatInap = null;
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            modelMap.addAttribute("rawatInapDto", rawatInapDto);
            listRawatInap = rawatInapServices.listRawatInapNative();
            modelMap.addAttribute("listRawatInap", listRawatInap);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/viewRawatInap";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewRuanganPasien", method = RequestMethod.GET)
    public String viewRuanganPasien(ModelMap modelMap, RawatInapDto rawatInapDto, UserDto userDto, HttpSession session) throws Exception {
        List<RawatInapDto> listRuanganPasien = null;
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            listRuanganPasien = rawatInapServices.listRuanganPasien();
            modelMap.addAttribute("listRuanganPasien", listRuanganPasien);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/viewRuanganPasien";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/updateTglKeluar", method = RequestMethod.GET)
    public String updateTglKeluar(ModelMap modelMap, RawatInapDto rawatInapDto, Integer index) throws Exception {
        rawatInapServices.updateNativeRawatInap(index);
        return "redirect:viewRawatInap.htm";
    }

    @RequestMapping(value = "/formTambahRawatInap", method = RequestMethod.GET)
    public String tambahRawatInap(ModelMap modelMap, RawatInapDto rawatInapDto, UserDto userDto, HttpSession session) throws Exception {
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            List<PasienDto> listPasien = pasienServices.listPasien();
            List<NomorRuanganDto> listNomor = nomorRuanganServices.listRuangan();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listNomorRuangan", listNomor);
            modelMap.addAttribute("rawatInapDto", rawatInapDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/tambah_rawat_inap";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/view_update_rawat_inap", method = RequestMethod.GET)
    public String formUbahRawatInap(ModelMap modelMap, RawatInapDto rawatInapDto, Integer index, UserDto userDto, HttpSession session) throws Exception {
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            rawatInapDto = rawatInapServices.listRawatInapUpdate(index);
            List<PasienDto> listPasien = pasienServices.listPasien();
            List<NomorRuanganDto> listNomor = nomorRuanganServices.listRuangan();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listNomorRuangan", listNomor);
            modelMap.addAttribute("rawatInapDto", rawatInapDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/update_rawat_inap";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveRawatInap", method = RequestMethod.POST)
    public String saveRawatInap(ModelMap modelMap, RawatInapDto rawatInapDto) throws Exception {
        Integer index = rawatInapServices.cekPaasienRawatInap(rawatInapDto.getId_pasien());
        try {
            if (index > 0) {
                modelMap.addAttribute("gagal", "Pasien dengan id" + rawatInapDto.getId_pasien() + " sudah dapat Ruangan");
                return "redirect:formTambahRawatInap.htm";
            } else {
                rawatInapServices.saveDataRawatInap(rawatInapDto);
            }

        } catch (Exception e) {
        }
        return "redirect:viewRawatInap.htm";
    }

    @RequestMapping(value = "/saveRawatInapPasien", method = RequestMethod.POST)
    public String saveRawatInapPasien(ModelMap modelMap, RawatInapDto rawatInapDto) throws Exception {
        try {
            rawatInapServices.saveDataRawatInap(rawatInapDto);
            klinikServices.updateKeterangan(rawatInapDto.getId_pasien());
        } catch (Exception e) {
        }
        return "redirect:viewRawatInap.htm";
    }

    @RequestMapping(value = "/updateRawatInap", method = RequestMethod.POST)
    public String updateRawatInapa(ModelMap modelMap, RawatInapDto rawatInapDto) throws Exception {
        try {
            rawatInapServices.updateDataRawatInap(rawatInapDto);
        } catch (Exception e) {
        }
        return "redirect:viewRawatInap.htm";
    }

    @RequestMapping(value = "/deleteRawatInap", method = RequestMethod.GET)
    public String deleteRawatInap(ModelMap modelMap, RawatInapDto rawatInapDto, Integer index) throws Exception {
        try {
            rawatInapServices.hapusRawatInap(index);
        } catch (Exception e) {
        }
        return "redirect:viewRawatInap.htm";
    }

    @RequestMapping(value = "/rekam_medis_rawat_inap", method = RequestMethod.GET)
    public String viewRekam(ModelMap modelMap, PasienDto pasienDto, UserDto userDto, HttpSession session) throws Exception {
        List<PasienDto> listPasien = null;
        List<PasienDto> listPasienBerita = null;
        listPasien = pasienServices.listPasien();
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
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
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/rekam_medis";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }
}
