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
import org.springframework.web.bind.annotation.SessionAttributes;
import rumahsakit.dao.UserDao;
import rumahsakit.dto.JenisKlinikDto;
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatKeluarDto;
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
@SessionAttributes({"hikari", "jenis"})
@Controller
public class UserController {

    @Autowired
    UserServices userServices;

    @Autowired
    PasienServices pasienServices;

    @Autowired
    JenisKlinikServices jenisKlinikServices;

    @Autowired
    ObatServices obatServices;

    @Autowired
    KlinikServices klinikServices;

    @RequestMapping(value = "/hikari", method = RequestMethod.GET)
    public String getHikari(ModelMap map) {

        return "hikari";
    }

    @RequestMapping(value = "/formLogin", method = RequestMethod.GET)
    public String cekLogin(ObatDto obatDto, UserDto userDto, String username, String pass, ModelMap modelMap, PasienDto pasienDto, HttpSession session) throws Exception {
        Integer index = userServices.loginUser(username, pass);
        List<PasienDto> listPasien = null;
        List<ObatDto> listObat = null;
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
        modelMap.addAttribute("pasienDto", pasienDto);
        modelMap.addAttribute("listPasien", listPasien);
        modelMap.addAttribute("listPasienBerita", listPasienBerita);
        userDto = userServices.selectUser(username, pass);
        listObat = obatServices.listObat();
        modelMap.addAttribute("obatDto", obatDto);
        modelMap.addAttribute("listObat", listObat);
        if (index > 0 && userDto.getJenis().equals("pendaftaran")) {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("hikari", userDto.getUsername());
            modelMap.addAttribute("jenis", userDto.getJenis());
            modelMap.addAttribute("warn", "selamat datang di halaman " + userDto.getJenis());
            return "pendaftaran/home";
        } else if (index > 0 && userDto.getJenis().equals("poliklinik")) {
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            Integer jumlahMenunggu = pasienServices.jumlahPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            modelMap.addAttribute("jumlahMenunggu", jumlahMenunggu);
            modelMap.addAttribute("hikari", userDto.getUsername());
            modelMap.addAttribute("jenis", userDto.getJenis());
            modelMap.addAttribute("warn", "selamat datang di halaman " + userDto.getJenis());
            return "poliKlinik/home";
        } else if (index > 0 && userDto.getJenis().equals("rawatinap")) {
            List<KlinikDto> klinikMenunggu = null;
            Integer jumlahRawatInap = klinikServices.jumlahKlinikRawatInap();
            klinikMenunggu = klinikServices.listKlinikRawatInap();
            modelMap.addAttribute("klinikRawatInap", klinikMenunggu);
            modelMap.addAttribute("jumlahRawatInap", jumlahRawatInap);
            modelMap.addAttribute("hikari", userDto.getUsername());
            modelMap.addAttribute("jenis", userDto.getJenis());
            modelMap.addAttribute("warn", "selamat datang di halaman " + userDto.getJenis());
            return "RawatInap/home";
        } else if (index > 0 && userDto.getJenis().equals("apotik")) {
            List<ObatKeluarDto> obatBelumDiambil=null;
            obatBelumDiambil=obatServices.listObatBelumdiAmbil();
            modelMap.addAttribute("obatBelumDiambil", obatBelumDiambil);
            Integer jumlahObatBelumDiambil=obatBelumDiambil.size();
            modelMap.addAttribute("jumlahObatBelumDiambil", jumlahObatBelumDiambil);
            modelMap.addAttribute("hikari", userDto.getUsername());
            modelMap.addAttribute("jenis", userDto.getJenis());
            modelMap.addAttribute("warn", "selamat datang di halaman " + userDto.getJenis());
            return "apotik/home";
        } else if (index > 0 && userDto.getJenis().equals("dokter")) {
            List<KlinikDto> klinikSudahDiPeriksa = null;
            klinikSudahDiPeriksa = klinikServices.listKlinikDokterSudahDiPeriksa();
            modelMap.addAttribute("klinikSudahDiPeriksa", klinikSudahDiPeriksa);
            List<PasienDto> pasienMenunggu = null;
            pasienMenunggu = pasienServices.listPasienMenunggu();
            modelMap.addAttribute("pasienMenunggu", pasienMenunggu);
            List<KlinikDto> klinikMenunggu = null;
            klinikMenunggu = klinikServices.listKlinikDokterMenunggu();
            Integer jumlahKlinikMenunggu = klinikServices.jumlahKlinikMenunggu();
            modelMap.addAttribute("klinikMenunggu", klinikMenunggu);
            modelMap.addAttribute("jumlahKlinikMenunggu", jumlahKlinikMenunggu);
            modelMap.addAttribute("hikari", userDto.getUsername());
            modelMap.addAttribute("jenis", userDto.getJenis());
            modelMap.addAttribute("warn", "selamat datang di halaman " + userDto.getJenis());
            return "dokter/home";
        } else {
            modelMap.addAttribute("warn", "maaf anda memasukkan password yang salah");
            return "login";
        }

    }

}
