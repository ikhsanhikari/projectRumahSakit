/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.model;

/**
 *
 * @author hikari
 */
public class KeluhanModel {
    private Integer id_keluhan;
    private Integer id_pasien;
    private Integer id_klinik;
    private String nama_keluhan;

    public Integer getId_keluhan() {
        return id_keluhan;
    }

    public void setId_keluhan(Integer id_keluhan) {
        this.id_keluhan = id_keluhan;
    }

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public Integer getId_klinik() {
        return id_klinik;
    }

    public void setId_klinik(Integer id_klinik) {
        this.id_klinik = id_klinik;
    }

    public String getNama_keluhan() {
        return nama_keluhan;
    }

    public void setNama_keluhan(String nama_keluhan) {
        this.nama_keluhan = nama_keluhan;
    }
}
