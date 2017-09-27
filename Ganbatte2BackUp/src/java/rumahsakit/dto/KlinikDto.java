/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dto;

/**
 *
 * @author sou
 */
public class KlinikDto {

    Integer id_klinik;
    Integer id_pasien;
    String keluhan;
    Integer jenis_klinik;
    String penyakit;
    String catatan_medis_klinik;
    String nama_pasien;
    String nama_klinik;
    Double biaya;
    String tgl_lahir_pasien;
    String jenis_kelamin;
    String alamat;
    String agama;
    String keterangan;
    String jenis_perawatan;
    String tindakan;

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }
    public String getJenis_perawatan() {
        return jenis_perawatan;
    }

    public void setJenis_perawatan(String jenis_perawatan) {
        this.jenis_perawatan = jenis_perawatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTgl_lahir_pasien() {
        return tgl_lahir_pasien;
    }

    public void setTgl_lahir_pasien(String tgl_lahir_pasien) {
        this.tgl_lahir_pasien = tgl_lahir_pasien;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public Double getBiaya() {
        return biaya;
    }

    public void setBiaya(Double biaya) {
        this.biaya = biaya;
    }

    public String getNama_klinik() {
        return nama_klinik;
    }

    public void setNama_klinik(String nama_klinik) {
        this.nama_klinik = nama_klinik;
    }
    
    public Integer getId_klinik() {
        return id_klinik;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public void setId_klinik(Integer id_klinik) {
        this.id_klinik = id_klinik;
    }

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
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
