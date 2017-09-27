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
 * @author sou
 */
@Controller
public class RuanganController {

    @Autowired
    RuanganServices ruanganServices;
    
    @Autowired
    KlinikServices klinikServices;

    @RequestMapping(value = "/viewRuangan", method = RequestMethod.GET)
    public String viewRuangan(ModelMap modelMap, RuanganDto ruanganDto, UserDto userDto, HttpSession session) throws Exception {
        List<RuanganDto> listRuangan = null;
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            listRuangan = ruanganServices.listRuangan();
            modelMap.addAttribute("ruanganDto", ruanganDto);
            modelMap.addAttribute("listRuangan", listRuangan);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/viewRuangan";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/formTambahRuangan", method = RequestMethod.GET)
    public String formTambahRuangan(ModelMap modelMap, RuanganDto ruanganDto, UserDto userDto, HttpSession session) throws Exception {
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            
            modelMap.addAttribute("ruanganDto", ruanganDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/tambah_ruangan";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/view_update_ruangan", method = RequestMethod.GET)
    public String formUpdateRuangan(ModelMap modelMap, RuanganDto ruanganDto, Integer index, UserDto userDto, HttpSession session) throws Exception {
        try {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            
            ruanganDto = ruanganServices.listRuanganUpdate(index);
            modelMap.addAttribute("ruanganDto", ruanganDto);
            String nama = session.getAttribute("hikari").toString();
            String jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                modelMap.addAttribute("userDto", userDto);
                return "login";
            } else {
                if (jenis.equals("rawatinap")) {
                    return "RawatInap/ubah_ruangan";
                } else {
                    modelMap.addAttribute("userDto", userDto);
                    return "login";
                }
            }
        } catch (Exception e) {
            return "login";
        }   
    }

    @RequestMapping(value = "/saveRuangan", method = RequestMethod.POST)
    public String saveRuangan(ModelMap modelMap, RuanganDto ruanganDto) throws Exception {
        ruanganServices.saveDataRuangan(ruanganDto);
        return "redirect:viewRuangan.htm";
    }

    @RequestMapping(value = "/ubahRuangan", method = RequestMethod.POST)
    public String updateRuangan(ModelMap modelMap, RuanganDto ruanganDto) throws Exception {
        ruanganServices.updateDataRuangan(ruanganDto);
        return "redirect:viewRuangan.htm";
    }

    @RequestMapping(value = "/deleteRuangan", method = RequestMethod.GET)
    public String deleteRuangan(ModelMap modelMap, RuanganDto ruanganDto, Integer index) throws Exception {
        ruanganServices.hapusRuangan(index);
        return "redirect:viewRuangan.htm";
    }

        
}
