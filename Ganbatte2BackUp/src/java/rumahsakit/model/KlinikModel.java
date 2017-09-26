/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.model;

/**
 *
 * @author sou
 */
public class KlinikModel {

    Integer id_klinik;
    Integer id_pasien;
    String keluhan;
    Integer jenis_klinik;
    String tindakan;
    String penyakit;
    String catatan_medis_klinik;
    Double biaya;
    String keterangan;
    String proses_perawatan;

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }
    
    
    public String getProses_perawatan() {
        return proses_perawatan;
    }

    public void setProses_perawatan(String proses_perawatan) {
        this.proses_perawatan = proses_perawatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public Double getBiaya() {
        return biaya;
    }

    public void setBiaya(Double biaya) {
        this.biaya = biaya;
    }
    public Integer getId_klinik() {
        return id_klinik;
    }

    public void setId_klinik(Integer id_klinik) {
        this.id_klinik = id_klinik;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public Integer getJenis_klinik() {
        return jenis_klinik;
    }

    public void setJenis_klinik(Integer jenis_klinik) {
        this.jenis_klinik = jenis_klinik;
    }


    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getCatatan_medis_klinik() {
        return catatan_medis_klinik;
    }

    public void setCatatan_medis_klinik(String catatan_medis_klinik) {
        this.catatan_medis_klinik = catatan_medis_klinik;
    }

}
