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
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.PasienDto;
import rumahsakit.dto.UserDto;
import rumahsakit.services.JenisKlinikServices;
import rumahsakit.services.KlinikServices;
import rumahsakit.services.ObatServices;
import rumahsakit.services.PasienServices;
import rumahsakit.services.UserServices;

/**
 *
 * @author hikari
 */
@Controller
public class LoginController {

    @Autowired
    PasienServices pasienServices;

    @Autowired
    UserServices userServices;

    @Autowired
    JenisKlinikServices jenisKlinikServices;

    @Autowired
    KlinikServices klinikServices;

    @Autowired
    ObatServices obatServices;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(UserDto userDto, ModelMap modelMap, HttpSession session, String username, String pass) throws Exception {
        String nama = null;
        String jenis = null;
        try {
            Integer index = userServices.loginUser(username, pass);
            List<PasienDto> listPasien = null;
            List<PasienDto> listPasienBerita = null;
            listPasien = pasienServices.listPasien();
            listPasienBerita = pasienServices.listPasienBerita();
            String waktu = pasienServices.waktuSekarang();
            Integer i = pasienServices.jumlahPasien();
            List<JenisKlinikDto> listJenisKlinik = null;
            List<KlinikDto> listKlinik = null;
            listKlinik = klinikServices.listKlinik();
            modelMap.addAttribute("listKlinik", listKlinik);
            listJenisKlinik = jenisKlinikServices.listJenisKlinik();
            modelMap.addAttribute("listJenisKlinik", listJenisKlinik);
            modelMap.addAttribute("waktu", waktu);
            modelMap.addAttribute("jumlah", i);
            modelMap.addAttribute("listPasien", listPasien);
            modelMap.addAttribute("listPasienBerita", listPasienBerita);
            userDto = userServices.selectUser(username, pass);
            List<ObatDto> listObat = null;
            listObat = obatServices.listObat();
            modelMap.addAttribute("listObat", listObat);
            nama = session.getAttribute("hikari").toString();
            jenis = session.getAttribute("jenis").toString();
            if (nama.equals("")) {
                return "login";
            } else {
                if (jenis.equals("poliklinik")) {
                    List<PasienDto> pasienMenunggu = null;
                    pasienMenunggu = pasienServices.listPasienMenunggu();
                    Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
                    modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
                    modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);

                    return "poliKlinik/home";
                } else if (jenis.equals("pendaftaran")) {
                    return "pendaftaran/home";
                } else if (jenis.equals("rawatinap")) {
                    return "RawatInap/home";
                } else if (jenis.equals("apotik")) {
                    return "apotik/home";
                } else if (jenis.equals("kasir")) {
                    return "kasir/home";
                } else if (jenis.equals("dokter")) {
                    return "dokter/home";
                } else {
                    return "login";
                }
            }
        } catch (NullPointerException e) {
            return "login";
        }

    }

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String logOut(UserDto userDto, ModelMap map, HttpSession session) {
        session.setAttribute("hikari", "");
        map.addAttribute("userDto", userDto);
        return "login";
    }
}
