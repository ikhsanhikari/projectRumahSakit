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
public class JenisKlinikDto {

    Integer id_jenis_klinik;
    String nama_klinik;
    String biaya;

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }
    public Integer getId_jenis_klinik() {
        return id_jenis_klinik;
    }

    public void setId_jenis_klinik(Integer id_jenis_klinik) {
        this.id_jenis_klinik = id_jenis_klinik;
    }

    public String getNama_klinik() {
        return nama_klinik;
    }

    public void setNama_klinik(String nama_klinik) {
        this.nama_klinik = nama_klinik;
    }
}
