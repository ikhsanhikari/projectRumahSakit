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
public class BiayaModel {
    Integer id_biaya;
    Integer id_pasien;
    Double biaya_ruangan;
    Double biaya_ambulance;
    Double biaya_administrasi;
    Double biaya_dokter;
    Double biaya_observasi;
    Double biaya_tindakan;
    Double biaya_visit_dokter;
    Double biaya_visit_spesialis;
    Double biaya_perawatan;
    Double biaya_lab;
    Double biaya_lain_lain;
    Double total_biaya;

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }
    
    public Integer getId_biaya() {
        return id_biaya;
    }

    public void setId_biaya(Integer id_biaya) {
        this.id_biaya = id_biaya;
    }

   

    public Double getBiaya_ruangan() {
        return biaya_ruangan;
    }

    public void setBiaya_ruangan(Double biaya_ruangan) {
        this.biaya_ruangan = biaya_ruangan;
    }

    public Double getBiaya_ambulance() {
        return biaya_ambulance;
    }

    public void setBiaya_ambulance(Double biaya_ambulance) {
        this.biaya_ambulance = biaya_ambulance;
    }

    public Double getBiaya_administrasi() {
        return biaya_administrasi;
    }

    public void setBiaya_administrasi(Double biaya_administrasi) {
        this.biaya_administrasi = biaya_administrasi;
    }

    public Double getBiaya_dokter() {
        return biaya_dokter;
    }

    public void setBiaya_dokter(Double biaya_dokter) {
        this.biaya_dokter = biaya_dokter;
    }

    public Double getBiaya_observasi() {
        return biaya_observasi;
    }

    public void setBiaya_observasi(Double biaya_observasi) {
        this.biaya_observasi = biaya_observasi;
    }

    public Double getBiaya_tindakan() {
        return biaya_tindakan;
    }

    public void setBiaya_tindakan(Double biaya_tindakan) {
        this.biaya_tindakan = biaya_tindakan;
    }

    public Double getBiaya_visit_dokter() {
        return biaya_visit_dokter;
    }

    public void setBiaya_visit_dokter(Double biaya_visit_dokter) {
        this.biaya_visit_dokter = biaya_visit_dokter;
    }

    public Double getBiaya_visit_spesialis() {
        return biaya_visit_spesialis;
    }

    public void setBiaya_visit_spesialis(Double biaya_visit_spesialis) {
        this.biaya_visit_spesialis = biaya_visit_spesialis;
    }

    public Double getBiaya_perawatan() {
        return biaya_perawatan;
    }

    public void setBiaya_perawatan(Double biaya_perawatan) {
        this.biaya_perawatan = biaya_perawatan;
    }

    public Double getBiaya_lab() {
        return biaya_lab;
    }

    public void setBiaya_lab(Double biaya_lab) {
        this.biaya_lab = biaya_lab;
    }

    public Double getBiaya_lain_lain() {
        return biaya_lain_lain;
    }

    public void setBiaya_lain_lain(Double biaya_lain_lain) {
        this.biaya_lain_lain = biaya_lain_lain;
    }

    public Double getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(Double total_biaya) {
        this.total_biaya = total_biaya;
    }
    
    
}
