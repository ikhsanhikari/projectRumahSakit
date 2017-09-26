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
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.JenisKlinikServices;
import rumahsakit.services.PasienServices;

/**
 *
 * @author sou
 */
@Controller
public class JenisKlinikController {

    @Autowired
    JenisKlinikServices jenisKlinikServices;
    
     @Autowired
    PasienServices pasienServices;

    @RequestMapping(value = "/homeKlinik", method = RequestMethod.GET)
    public String homeKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto, HttpSession session, UserDto userDto) throws Exception {
        List<JenisKlinikDto> listJenisKlinik = null;
        try {
            List<PasienDto> listPasien = null;
            listPasien = pasienServices.listPasien10();
            modelMap.addAttribute("listPasien", listPasien);
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("jenisKlinikDto", jenisKlinikDto);
                    return "poliKlinik/home";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewJenisKlinik", method = RequestMethod.GET)
    public String viewJenisKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto, HttpSession session, UserDto userDto) throws Exception {
        List<JenisKlinikDto> listJenisKlinik = null;
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("jenisKlinikDto", jenisKlinikDto);
                    return "poliKlinik/viewJenisKlinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }

        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/tambah_jenis_klinik", method = RequestMethod.GET)
    public String tambahJenisKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto, UserDto userDto, HttpSession session) throws Exception {
        List<JenisKlinikDto> listJenisKlinik = null;
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("jenisKlinikDto", jenisKlinikDto);
                    return "poliKlinik/tambah_jenis_klinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewUpdateJenisKlinik", method = RequestMethod.GET)
    public String updateJenisKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto, Integer index, UserDto userDto, HttpSession session) throws Exception {
        try {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            jenisKlinikDto = jenisKlinikServices.listJenisKlinikUpdate(index);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    modelMap.addAttribute("jenisKlinikDto", jenisKlinikDto);
                    return "poliKlinik/updateJenisKlinik";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveJenisKlinik", method = RequestMethod.POST)
    public String saveJenisKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto) throws Exception {
        jenisKlinikServices.saveDataJenisKlinik(jenisKlinikDto);
        return "redirect:homeKlinik.htm";
    }

    @RequestMapping(value = "/updateJenisKlinik", method = RequestMethod.POST)
    public String updateJenisKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto) throws Exception {
        jenisKlinikServices.updateDataJenisKlinik(jenisKlinikDto);
        return "redirect:homeKlinik.htm";
    }

    @RequestMapping(value = "/deleteJenisKlinik", method = RequestMethod.GET)
    public String deleteJenisKlinik(ModelMap modelMap, JenisKlinikDto jenisKlinikDto, Integer index) throws Exception {
        jenisKlinikServices.hapusJenisKlinik(index);
        return "redirect:homeKlinik.htm";
    }
}
