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
import rumahsakit.services.ObatServices;
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatKeluarDto;
import rumahsakit.dto.UserDto;

/**
 *
 * @author sou
 */
@Controller
public class ObatController {

    @Autowired
    ObatServices obatServices;

    @RequestMapping(value = "/homeObat", method = RequestMethod.GET)
    public String homeObat(ObatDto obatDto, ModelMap modelMap, UserDto userDto, HttpSession session) throws Exception {
        List<ObatDto> listObat = null;
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            listObat = obatServices.listObat();
            modelMap.addAttribute("obatDto", obatDto);
            modelMap.addAttribute("listObat", listObat);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/home";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/viewObat", method = RequestMethod.GET)
    public String viewObat(UserDto userDto, HttpSession session, ObatDto obatDto, ModelMap modelMap) throws Exception {
        List<ObatDto> listObat = null;
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            listObat = obatServices.listObat();
            modelMap.addAttribute("obatDto", obatDto);
            modelMap.addAttribute("listObat", listObat);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/viewObat";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/formTambahObat", method = RequestMethod.GET)
    public String formTambahObat(ObatDto obatDto, ModelMap modelMap, HttpSession session, UserDto userDto) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("obatDto", obatDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/tambah_obat";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/formUpdateObat", method = RequestMethod.GET)
    public String formUbahObat(HttpSession session, UserDto userDto, ObatDto obatDto, ModelMap modelMap, Integer index) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            obatDto = obatServices.getListObatUpdate(index);
            modelMap.addAttribute("obatDto", obatDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/update_obat";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveObat", method = RequestMethod.POST)
    public String saveObat(ObatDto obatDto, ModelMap modelMap) throws Exception {
        obatServices.saveDataObat(obatDto);
        return "redirect:homeObat.htm";
    }

    @RequestMapping(value = "/updateObat", method = RequestMethod.POST)
    public String updateObat(ObatDto obatDto, ModelMap modelMap) throws Exception {
        obatServices.updateDataObat(obatDto);
        return "redirect:homeObat.htm";
    }

    @RequestMapping(value = "/deleteObat", method = RequestMethod.GET)
    public String deleteObat(Integer index, ObatDto obatDto, ModelMap modelMap) throws Exception {
        obatServices.hapusObat(index);
        return "redirect:homeObat.htm";
    }
}
