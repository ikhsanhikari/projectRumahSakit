/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dto;

/**
 *
 * @author hikari
 */
public class TindakanDto {
    private Integer id_tindakan;
    private Integer id_pasien;
    private Integer id_klinik;
    private String nama_tindakan;

    public Integer getId_tindakan() {
        return id_tindakan;
    }

    public void setId_tindakan(Integer id_tindakan) {
        this.id_tindakan = id_tindakan;
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

    public String getNama_tindakan() {
        return nama_tindakan;
    }

    public void setNama_tindakan(String nama_tindakan) {
        this.nama_tindakan = nama_tindakan;
    }
}
