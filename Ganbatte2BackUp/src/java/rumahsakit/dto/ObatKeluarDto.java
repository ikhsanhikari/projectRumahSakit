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
public class ObatKeluarDto {

    Integer id_obat_keluar;
    Integer id_obat;
    Integer id_pasien;
    String tgl_obat_keluar;
    Double harga_obat_keluar;
    String tgl_pembayaran;
    Double jumlah_obat_keluar;
    String nama_obat;
    String nama_pasien;
    String status_obat;

    public String getStatus_obat() {
        return status_obat;
    }

    public void setStatus_obat(String status_obat) {
        this.status_obat = status_obat;
    }

    public Double getHarga_obat_keluar() {
        return harga_obat_keluar;
    }

    public void setHarga_obat_keluar(Double harga_obat_keluar) {
        this.harga_obat_keluar = harga_obat_keluar;
    }

    public Double getJumlah_obat_keluar() {
        return jumlah_obat_keluar;
    }

    public void setJumlah_obat_keluar(Double jumlah_obat_keluar) {
        this.jumlah_obat_keluar = jumlah_obat_keluar;
    }
    
    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    

    public Integer getId_obat_keluar() {
        return id_obat_keluar;
    }

    public void setId_obat_keluar(Integer id_obat_keluar) {
        this.id_obat_keluar = id_obat_keluar;
    }

    public Integer getId_obat() {
        return id_obat;
    }

    public void setId_obat(Integer id_obat) {
        this.id_obat = id_obat;
    }

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getTgl_obat_keluar() {
        return tgl_obat_keluar;
    }

    public void setTgl_obat_keluar(String tgl_obat_keluar) {
        this.tgl_obat_keluar = tgl_obat_keluar;
    }

    
    public String getTgl_pembayaran() {
        return tgl_pembayaran;
    }

    public void setTgl_pembayaran(String tgl_pembayaran) {
        this.tgl_pembayaran = tgl_pembayaran;
    }

}
