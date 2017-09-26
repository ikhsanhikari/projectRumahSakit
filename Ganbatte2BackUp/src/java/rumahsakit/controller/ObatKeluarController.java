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
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.ObatKeluarServices;
import rumahsakit.services.ObatServices;
import rumahsakit.services.PasienServices;

/**
 *
 * @author sou
 */
@Controller
public class ObatKeluarController {

    @Autowired
    ObatKeluarServices obatKeluarServices;

    @Autowired
    PasienServices pasienServices;

    @Autowired
    ObatServices obatServices;

    @RequestMapping(value = "/viewObatKeluar", method = RequestMethod.GET)
    public String viewObatKeluar(UserDto userDto, HttpSession session, ModelMap modelMap, ObatKeluarDto obatKeluarDto) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("obatKeluarDto", obatKeluarDto);
            List<ObatDto> listObat = null;
            List<ObatKeluarDto> listObatKeluar = null;
            List<PasienDto> listPasien = null;
            listObat = obatServices.listObat();
            listPasien = pasienServices.listPasien();
            listObatKeluar = obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listObat", listObat);
            modelMap.addAttribute("listObatKeluar", listObatKeluar);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/viewObatKeluar";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }
    
    @RequestMapping(value = "/viewObatSudahDiambil", method = RequestMethod.GET)
    public String viewObatSudahDiambil(UserDto userDto, HttpSession session, ModelMap modelMap, ObatKeluarDto obatKeluarDto) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("obatKeluarDto", obatKeluarDto);
            List<ObatDto> listObat = null;
            List<ObatKeluarDto> listObatKeluar = null;
            List<PasienDto> listPasien = null;
            listObat = obatServices.listObat();
            listPasien = pasienServices.listPasien();
            listObatKeluar = obatServices.listObatSudahdiAmbil();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listObat", listObat);
            modelMap.addAttribute("listObatKeluar", listObatKeluar);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/viewObatSudahDiambil";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/formTambahObatKeluar", method = RequestMethod.GET)
    public String formTambahObatKeluar(UserDto userDto, HttpSession session, ModelMap modelMap, ObatKeluarDto obatKeluarDto) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("obatKeluarDto", obatKeluarDto);
            List<ObatDto> listObat = null;
            List<PasienDto> listPasien = null;
            listObat = obatServices.listObat();
            listPasien = pasienServices.listPasien();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listObat", listObat);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/tambah_obat_keluar";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }
    
    

    @RequestMapping(value = "/formUbahObatKeluar", method = RequestMethod.GET)
    public String formUbahObatKeluar(UserDto userDto, HttpSession session, ModelMap modelMap, ObatKeluarDto obatKeluarDto, Integer index) throws Exception {
        try {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            obatKeluarDto = obatKeluarServices.getListObatKeluarUpdate(index);
            modelMap.addAttribute("obatKeluarDto", obatKeluarDto);
            List<ObatDto> listObat = null;
            List<PasienDto> listPasien = null;
            listObat = obatServices.listObat();
            listPasien = pasienServices.listPasien();
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listObat", listObat);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("apotik")) {
                    return "apotik/ubah_obat_keluar";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveObatKeluar", method = RequestMethod.POST)
    public String saveObatKeluar(ObatKeluarDto obatKeluarDto) {
        try {
            obatKeluarServices.saveDataObatKeluar(obatKeluarDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatKeluar.htm";
    }

    @RequestMapping(value = "/updateStatusObat", method = RequestMethod.GET)
    public String updateStatusObat(Integer index) {
        try {
            obatKeluarServices.updateStatsObat(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatSudahDiambil.htm";
    }
    
    @RequestMapping(value = "/updateObatKeluar", method = RequestMethod.POST)
    public String updateObatKeluar(ObatKeluarDto obatKeluarDto) {
        try {
            obatKeluarServices.updateDataObatKeluar(obatKeluarDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatKeluar.htm";
    }

    @RequestMapping(value = "/deleteObatKeluar", method = RequestMethod.GET)
    public String deleteObatKeluar(Integer index) {
        try {
            obatKeluarServices.hapusObatKeluar(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:viewObatKeluar.htm";
    }

}
