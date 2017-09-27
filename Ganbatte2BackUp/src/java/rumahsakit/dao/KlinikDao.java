/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.KeluhanModel;
import rumahsakit.model.KlinikModel;
import rumahsakit.model.TindakanModel;

/**
 *
 * @author sou
 */
public interface KlinikDao {

    public List<KlinikModel> listKlinik() throws Exception;

    public List<KlinikModel> listKlinikUpdate(Integer id) throws Exception;

    public KlinikModel getKlinikById(Integer id) throws Exception;

    public void saveDataKlinik(KlinikModel jenisKlinikModel);

    public void updateDataKlinik(KlinikModel jenisKlinikModel) throws Exception;

    public void hapusKlinik(Integer id);
    
    public List<Object []> listKlinikNative();
    
    public List<Object []> listKlinikNative(Integer id);
    
    public List<Object[]> listKlinikDokterMenunggu();
    
    public List<Object[]> listKlinikDokterSudahDiPeriksa();
    
    public List<Object[]> listKlinikRawatInap();
    
    public List<KlinikModel> listKlinikMenunggu();
    
    public void insertIdPasien(Integer index);
    
    public void updateIdKlinik(Integer index,Integer where);
    
    public List<Object []> getKlinik(Integer index);
    
    public void updateKeterangan(Integer id);
    
    public void saveKeluhan(KeluhanModel keluhanModel);
    
    public void saveTindakan (TindakanModel tindakanModel);
    
    public List<KeluhanModel> getKeluhan( Integer id);
    
    public List<TindakanModel> getTindakan( Integer id);
    
    
    
    
    final String sqlListKlinik="select k.id_klinik,"
                + "p.nama_pasien,k.keluhan,"
                + "jk.nama_klinik,k.penyakit,"
                + "k.catatan_medis_klinik,k.biaya,k.keteranganKlinik,k.proses_perawatan,k.tindakan\n" +
                  "from pasien p inner join "
                + "klinik k inner join jenis_klinik jk "
                + "on p.Id_pasien=k.id_pasien "
                + "and k.jenis_klinik=jk.Id_Jenis_Kelinik";
    
    final String sqlListKlinikById="select k.id_klinik,"
                + "p.nama_pasien,k.keluhan,"
                + "jk.nama_klinik,k.penyakit,"
                + "k.catatan_medis_klinik,k.biaya,k.keteranganKlinik,k.proses_perawatan,k.tindakan\n" +
                  "from pasien p inner join "
                + "klinik k inner join jenis_klinik jk "
                + "on p.Id_pasien=k.id_pasien "
                + "and k.jenis_klinik=jk.Id_Jenis_Kelinik where id_klinik=:id";
    
    final String sqlListKlinikDokterMenunggu="select k.id_klinik,"
                + "p.nama_pasien,k.keluhan,"
                + "jk.nama_klinik,k.penyakit,"
                + "k.catatan_medis_klinik,k.biaya,k.keteranganKlinik,k.proses_perawatan\n" +
                  "from pasien p inner join "
                + "klinik k inner join jenis_klinik jk "
                + "on p.Id_pasien=k.id_pasien "
                + "and k.jenis_klinik=jk.Id_Jenis_Kelinik"
            + " where k.keteranganKlinik='menunggu..'";
    final String sqlListKlinikDokterSudahDiperiksa="select k.id_klinik,"
                + "p.nama_pasien,k.keluhan,"
                + "jk.nama_klinik,k.penyakit,"
                + "k.catatan_medis_klinik,k.biaya,k.keteranganKlinik,k.proses_perawatan,k.tindakan\n" +
                  "from pasien p inner join "
                + "klinik k inner join jenis_klinik jk "
                + "on p.Id_pasien=k.id_pasien "
                + "and k.jenis_klinik=jk.Id_Jenis_Kelinik"
            + " where k.keteranganKlinik='sudah diperiksa'";
    final String sqlListKlinikRawatInap="select k.id_klinik,"
                + "p.nama_pasien,k.keluhan,"
                + "jk.nama_klinik,k.penyakit,"
                + "k.catatan_medis_klinik,k.biaya,k.keteranganKlinik,k.proses_perawatan,p.id_pasien\n" +
                  "from pasien p inner join "
                + "klinik k inner join jenis_klinik jk "
                + "on p.Id_pasien=k.id_pasien "
                + "and k.jenis_klinik=jk.Id_Jenis_Kelinik"
            + " where k.proses_perawatan='Rawat Inap'";
    
}


