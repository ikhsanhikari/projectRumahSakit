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
public class RawatInapModel {
    Integer id_rawat_inap;
    Integer id_pasien;
    String tgl_masuk;
    String tgl_keluar;
    Integer id_nomor_ruangan;
    String catatan_medis_rawat_inap;

    public Integer getId_rawat_inap() {
        return id_rawat_inap;
    }

    public void setId_rawat_inap(Integer id_rawat_inap) {
        this.id_rawat_inap = id_rawat_inap;
    }

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public Integer getId_nomor_ruangan() {
        return id_nomor_ruangan;
    }

    public void setId_nomor_ruangan(Integer id_nomor_ruangan) {
        this.id_nomor_ruangan = id_nomor_ruangan;
    }

    public String getCatatan_medis_rawat_inap() {
        return catatan_medis_rawat_inap;
    }

    public void setCatatan_medis_rawat_inap(String catatan_medis_rawat_inap) {
        this.catatan_medis_rawat_inap = catatan_medis_rawat_inap;
    }
}
