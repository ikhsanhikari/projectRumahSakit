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
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatKeluarDto;
import rumahsakit.dto.ObatMasukDto;
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.ObatMasukServices;
import rumahsakit.services.ObatServices;
import rumahsakit.services.PasienServices;

/**
 *
 * @author hikari
 */
@Controller
public class ObatMasukController {

    @Autowired
    ObatMasukServices obatMasukServices;

    @Autowired
    PasienServices pasienServices;

    @Autowired
    ObatServices obatServices;

    @RequestMapping(value = "/viewObatMasuk", method = RequestMethod.GET)
    public String viewObatMasuk(ModelMap modelMap, ObatMasukDto obatMasukDto, HttpSession session, UserDto userDto) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("obatMasukDto", obatMasukDto);
            List<ObatDto> listObat = null;
            List<ObatMasukDto> listObatMasuk = null;
            List<PasienDto> listPasien = null;
            listObat = obatServices.listObat();
            listPasien = pasienServices.listPasien();
            listObatMasuk = obatMasukServices.listObatMasuk();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listObat", listObat);
            modelMap.addAttribute("listObatMasuk", listObatMasuk);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/viewObatMasuk";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/formTambahObatMasuk", method = RequestMethod.GET)
    public String formTambahObatMasuk(UserDto userDto, HttpSession session, ModelMap modelMap, ObatMasukDto obatMasukDto) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("obatMasukDto", obatMasukDto);
            List<ObatDto> listObat = null;
            listObat = obatServices.listObat();
            modelMap.addAttribute("listObat", listObat);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/tambah_obat_masuk";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/formUbahObatMasuk", method = RequestMethod.GET)
    public String formUbahObatMasuk(UserDto userDto, HttpSession session, ModelMap modelMap, ObatMasukDto obatMasukDto, Integer index) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            obatMasukDto = obatMasukServices.getListObatMasukUpdate(index);
            modelMap.addAttribute("obatMasukDto", obatMasukDto);
            List<ObatDto> listObat = null;
            listObat = obatServices.listObat();
            modelMap.addAttribute("listObat", listObat);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/ubah_obat_masuk";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveObatMasuk", method = RequestMethod.POST)
    public String saveObatMasuk(ObatMasukDto obatMasukDto) {
        try {
            obatMasukServices.saveDataObatMasuk(obatMasukDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatMasuk.htm";
    }

    @RequestMapping(value = "/updateObatMasuk", method = RequestMethod.POST)
    public String updateObatMasuk(ObatMasukDto obatMasukDto) {
        try {
            obatMasukServices.updateDataObatMasuk(obatMasukDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatMasuk.htm";
    }

    @RequestMapping(value = "/deleteObatMasuk", method = RequestMethod.GET)
    public String deleteObatMasuk(ObatMasukDto obatMasukDto, Integer index) {
        try {
            obatMasukServices.hapusObatMasuk(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatMasuk.htm";
    }
}
