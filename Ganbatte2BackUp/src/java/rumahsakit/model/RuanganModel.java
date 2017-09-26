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
public class RuanganModel {
    Integer id_ruangan;
    String jenis_ruangan;
    Double harga_ruangan;

    public Integer getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(Integer id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public String getJenis_ruangan() {
        return jenis_ruangan;
    }

    public void setJenis_ruangan(String jenis_ruangan) {
        this.jenis_ruangan = jenis_ruangan;
    }

    public Double getHarga_ruangan() {
        return harga_ruangan;
    }

    public void setHarga_ruangan(Double harga_ruangan) {
        this.harga_ruangan = harga_ruangan;
    }
}
