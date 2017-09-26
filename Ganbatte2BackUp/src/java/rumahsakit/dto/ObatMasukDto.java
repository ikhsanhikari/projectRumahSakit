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
public class ObatMasukDto {
    private Integer id_obat_masuk;
    Integer id_obat;
    String tgl_obat_masuk;
    Double jumlah_obat_masuk;
    Double harga_beli_obat_masuk;

    public Integer getId_obat_masuk() {
        return id_obat_masuk;
    }

    public void setId_obat_masuk(Integer id_obat_masuk) {
        this.id_obat_masuk = id_obat_masuk;
    }

    public Integer getId_obat() {
        return id_obat;
    }

    public void setId_obat(Integer id_obat) {
        this.id_obat = id_obat;
    }

    public String getTgl_obat_masuk() {
        return tgl_obat_masuk;
    }

    public void setTgl_obat_masuk(String tgl_obat_masuk) {
        this.tgl_obat_masuk = tgl_obat_masuk;
    }

    

    public Double getJumlah_obat_masuk() {
        return jumlah_obat_masuk;
    }

    public void setJumlah_obat_masuk(Double jumlah_obat_masuk) {
        this.jumlah_obat_masuk = jumlah_obat_masuk;
    }

    public Double getHarga_beli_obat_masuk() {
        return harga_beli_obat_masuk;
    }

    public void setHarga_beli_obat_masuk(Double harga_beli_obat_masuk) {
        this.harga_beli_obat_masuk = harga_beli_obat_masuk;
    }
}
