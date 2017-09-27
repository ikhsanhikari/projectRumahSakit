/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.ObatModel;

/**
 *
 * @author sou
 */
public interface ObatDao {

    public List<ObatModel> listObat();

    public List<ObatModel> listObatUpdate(Integer id);

    public ObatModel getObatById(Integer id);

    public void saveDataObat(ObatModel obatModel);

    public void updateDataObat(ObatModel obatModel);

    public void hapusObat(Integer id);
    
    public List<Object[]> listObatBelumDiAmbil();
    
    public List<Object[]> listObatSudahDiAmbil();
    
    String sqlBelumDiAmbil="SELECT p.nama_pasien , ok.jumlah_obat_keluar,o.nama_obat,ok.harga_obat_keluar,ok.tgl_pembayaran,ok.id_obat_keluar,ok.status_obat "
            + "FROM \n" +
              "pasien p,obat_keluar ok,obat o "
            + "where p.id_pasien = ok.id_pasien "
            + "AND ok.id_obat=o.id_obat and ok.status_obat='belum diambil'";
    String sqlSudahDiAmbil="SELECT p.nama_pasien , ok.jumlah_obat_keluar,o.nama_obat,ok.harga_obat_keluar,ok.tgl_pembayaran ,ok.id_obat_keluar,ok.status_obat "
            + "FROM \n" +
              "pasien p,obat_keluar ok,obat o "
            + "where p.id_pasien = ok.id_pasien "
            + "AND ok.id_obat=o.id_obat and ok.status_obat='sudah diambil'";
}
