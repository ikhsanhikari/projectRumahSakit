/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rumahsakit.dto.JenisKlinikDto;
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.JenisKlinikServices;
import rumahsakit.services.KlinikServices;
import rumahsakit.services.PasienServices;
import rumahsakit.services.UserServices;

/**
 *
 * @author sou
 */
@Controller
public class PasienController {

    @Autowired
    PasienServices pasienServices;

    @Autowired
    UserServices userServices;

    @Autowired
    JenisKlinikServices jenisKlinikServices;

    @Autowired
    KlinikServices klinikServices;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(UserDto userDto, ModelMap map, HttpSession session) throws Exception {

        //String nama = null, jenis = null;
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            map.addAttribute("pasienMenunggu", pasienMenunggu);
            String waktu = pasienServices.waktuSekarang();
            Integer index = pasienServices.jumlahPasien();
            map.addAttribute("waktu", waktu);
            map.addAttribute("jumlah", index);
            List<PasienDto> listPasien = null;
            listPasien = pasienServices.listPasien10();
            map.addAttribute("listPasien", listPasien);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                map.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("pendaftaran")) {
                    return "pendaftaran/home";
                } else {
                    map.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (NullPointerException e) {
            return "login";
        }
        //return "pendaftaran/home";
    }

    @RequestMapping(value = "/cariPasien", method = RequestMethod.GET)
    public String searchPasien(ModelMap modelMap, PasienDto pasienDto, Integer index) throws Exception {
        pasienDto = pasienServices.getListPasienUpdate(pasienDto.getId_pasien());
        modelMap.addAttribute("pasienDto", pasienDto);
        if (pasienDto.getId_pasien() != null) {
            return "pendaftaran/ubah_pasien";
        }
        return "pendaftaran/home";

    }

    @RequestMapping(value = "/tambah_pasien", method = RequestMethod.GET)
    public String tambahPasien(PasienDto pasienDto, UserDto userDto, ModelMap map, HttpSession session) {

        try {
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                map.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("pendaftaran")) {
                    map.addAttribute("pasienDto", pasienDto);
                    return "pendaftaran/tambah_pasien";
                } else {
                    map.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }

        //return "pendaftaran/tambah_pasien";
    }

    @RequestMapping(value = "/viewPasien", method = RequestMethod.GET)
    public String viewIndex(ModelMap modelMap, UserDto userDto, PasienDto pasienDto, HttpSession session) throws Exception {
        List<PasienDto> listPasien = null;
        List<PasienDto> listPasienBerita = null;
        try {

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
                if (jenis.equals("pendaftaran")) {
                    return "pendaftaran/viewPasien";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/rekam_medis", method = RequestMethod.GET)
    public String viewRekam(ModelMap modelMap, PasienDto pasienDto, HttpSession session, UserDto userDto) throws Exception {
        List<PasienDto> listPasien = null;
        List<PasienDto> listPasienBerita = null;
        try {

            listPasien = pasienServices.listPasien();
            listPasienBerita = pasienServices.listPasienBerita();
            String waktu = pasienServices.waktuSekarang();
            Integer index = pasienServices.jumlahPasien();
            modelMap.addAttribute("waktu", waktu);
            modelMap.addAttribute("jumlah", index);
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listPasienBerita", listPasienBerita);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("pendaftaran")) {
                    modelMap.addAttribute("pasienDto", pasienDto);
                    return "pendaftaran/rekam_medis";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewUpdatePasien", method = RequestMethod.GET)
    public String viewFormUpdate(HttpSession session, ModelMap modelMap, UserDto userDto, PasienDto pasienDto, Integer index) throws Exception {
        List<PasienDto> listPasien = null;
        List<PasienDto> listPasienBerita = null;
        try {

            listPasien = pasienServices.listPasien();
            pasienDto = pasienServices.getListPasienUpdate(index);
            listPasienBerita = pasienServices.listPasienBerita();
            String waktu = pasienServices.waktuSekarang();
            Integer idx = pasienServices.jumlahPasien();
            modelMap.addAttribute("waktu", waktu);
            modelMap.addAttribute("jumlah", idx);
            modelMap.addAttribute("listPasienBerita", listPasienBerita);
            modelMap.addAttribute("listPasien", listPasien);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("pendaftaran")) {
                    modelMap.addAttribute("pasienDto", pasienDto);
                    return "pendaftaran/ubah_pasien";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewPasien(ModelMap modelMap, PasienDto pasienDto) throws Exception {
        List<PasienDto> listPasien = null;
        listPasien = pasienServices.listPasien();
        modelMap.addAttribute("pasienDto", pasienDto);
        modelMap.addAttribute("listPasien", listPasien);
        return "index";
    }

    @RequestMapping(value = "/savePasien", method = RequestMethod.POST)
    public String savePasien(ModelMap modelMap, PasienDto pasienDto) {
        try {
            pasienServices.saveDataPasien(pasienDto);
        } catch (Exception ex) {
            Logger.getLogger(PasienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:viewPasien.htm";
    }

    @RequestMapping(value = "/ubahPasien", method = RequestMethod.POST)
    public String updatePasien(ModelMap modelMap, PasienDto pasienDto) {
        try {
            pasienServices.updateDataPasien(pasienDto);
        } catch (Exception ex) {
            Logger.getLogger(PasienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:viewPasien.htm";
    }

    @RequestMapping(value = "/hapusPasien", method = RequestMethod.GET)
    public String hapusPasien(ModelMap modelMap, PasienDto pasienDto, Integer index) {
        try {
            pasienServices.hapusPasien(index);
        } catch (Exception ex) {
            Logger.getLogger(PasienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:viewPasien.htm";
    }
    
    
}
