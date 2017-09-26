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
public class ObatDto {

    Integer id_obat;
    String kode_obat;
    String nama_obat;
    Double harga_obat;
    Double stok_obat;

    public Double getStok_obat() {
        return stok_obat;
    }

    public void setStok_obat(Double stok_obat) {
        this.stok_obat = stok_obat;
    }

    public Integer getId_obat() {
        return id_obat;
    }

    public void setId_obat(Integer id_obat) {
        this.id_obat = id_obat;
    }

    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public Double getHarga_obat() {
        return harga_obat;
    }

    public void setHarga_obat(Double harga_obat) {
        this.harga_obat = harga_obat;
    }
}
