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
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.NomorRuanganDto;
import rumahsakit.dto.RuanganDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.KlinikServices;
import rumahsakit.services.NomorRuanganServices;
import rumahsakit.services.RuanganServices;

/**
 *
 * @author hikari
 */
@Controller
public class NomorRuanganController {

    @Autowired
    NomorRuanganServices nomorRuanganServices;
    @Autowired
    RuanganServices ruanganServices;
    @Autowired
    KlinikServices klinikServices;

    @RequestMapping(value = "/viewNomorRuangan", method = RequestMethod.GET)
    public String viewNomorRuangan(ModelMap modelMap, RuanganDto ruanganDto, HttpSession session, UserDto userDto) throws Exception {
        List<NomorRuanganDto> listRuangan = null;
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            listRuangan = nomorRuanganServices.listRuanganNative();
            modelMap.addAttribute("listNomorRuangan", listRuangan);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/viewNomorRuangan";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/formTambahNomorRuangan", method = RequestMethod.GET)
    public String tambahNomorRuangan(ModelMap modelMap, NomorRuanganDto ruanganDto, UserDto userDto, HttpSession session) throws Exception {
        List<RuanganDto> listRuangan = null;
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            listRuangan = ruanganServices.listRuangan();
            modelMap.addAttribute("listRuangan", listRuangan);
            modelMap.addAttribute("nomorRuanganDto", ruanganDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/tambah_nomor_ruangan";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/formUbahNomorRuangan", method = RequestMethod.GET)
    public String ubahNomorRuangan(ModelMap modelMap, UserDto userDto, HttpSession session, NomorRuanganDto ruanganDto, Integer index) throws Exception {
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            ruanganDto = nomorRuanganServices.listRuanganUpdate(index);
            List<RuanganDto> listRuangan = null;
            listRuangan = ruanganServices.listRuangan();
            modelMap.addAttribute("listRuangan", listRuangan);
            modelMap.addAttribute("nomorRuanganDto", ruanganDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/ubah_nomor_ruangan";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/saveNomorRuangan", method = RequestMethod.POST)
    public String saveNomorRuangan(ModelMap modelMap, NomorRuanganDto ruanganDto) throws Exception {
        nomorRuanganServices.saveDataRuangan(ruanganDto);
        return "redirect:viewNomorRuangan.htm";
    }

    @RequestMapping(value = "/deleteNomorRuangan", method = RequestMethod.GET)
    public String deleteNomorRuangan(ModelMap modelMap, NomorRuanganDto ruanganDto, Integer index) throws Exception {
        nomorRuanganServices.hapusNomorRuangan(index);
        return "redirect:viewNomorRuangan.htm";
    }

    @RequestMapping(value = "/ubahNomorRuangan", method = RequestMethod.POST)
    public String updateNomorRuangan(ModelMap modelMap, NomorRuanganDto ruanganDto) throws Exception {
        try {
            nomorRuanganServices.updateDataRuangan(ruanganDto);
        } catch (Exception e) {
        }
        return "redirect:viewNomorRuangan.htm";
    }

}
