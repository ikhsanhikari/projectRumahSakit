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
public class NomorRuanganDto {

    Integer id_nomor_ruangan;
    Integer id_ruangan;
    String nomor_ruangan;
    String status_ruangan;
    String jenis_ruangan;

    public String getJenis_ruangan() {
        return jenis_ruangan;
    }

    public void setJenis_ruangan(String jenis_ruangan) {
        this.jenis_ruangan = jenis_ruangan;
    }
    
    public Integer getId_nomor_ruangan() {
        return id_nomor_ruangan;
    }

    public void setId_nomor_ruangan(Integer id_nomor_ruangan) {
        this.id_nomor_ruangan = id_nomor_ruangan;
    }

    public Integer getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(Integer id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public String getNomor_ruangan() {
        return nomor_ruangan;
    }

    public void setNomor_ruangan(String nomor_ruangan) {
        this.nomor_ruangan = nomor_ruangan;
    }

    public String getStatus_ruangan() {
        return status_ruangan;
    }

    public void setStatus_ruangan(String status_ruangan) {
        this.status_ruangan = status_ruangan;
    }
}
