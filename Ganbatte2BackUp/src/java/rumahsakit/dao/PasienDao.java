/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.PasienModel;

/**
 *
 * @author sou
 */
public interface PasienDao {

    public List<PasienModel> listPasien() throws Exception;
    
    public List<PasienModel> listPasienMenunggu() throws Exception;
    
    public List<PasienModel> listPasien10() throws Exception;

    public List<PasienModel> listPasienUpdate(Integer id) throws Exception;
    
    public void updateKeterangan(Integer index);

    public PasienModel getPasienById(Integer id) throws Exception;

    public void saveDataPasien(PasienModel pasienModel);

    public void updateDataPasien(PasienModel pasienModel) throws Exception;

    public void hapusPasien(Integer id);    

    public List<Object []> listPasienBerita();
    
    final String sqlRekamMedis="select "
                + "p.nama_pasien,"
                + "p.alamat,"
                + "p.keterangan,"
                + "k.keluhan,"
                + "k.penyakit,"
                + "jk.nama_klinik \n" +
                  "from jenis_klinik jk "
                + "inner join klinik k "
                + "inner join pasien p " +
                  "on p.id_pasien=k.id_pasien "
                + "and k.jenis_klinik=jk.Id_Jenis_Kelinik "
                + "order by id_klinik "
                + "desc "
                + "limit 0,10";
}
