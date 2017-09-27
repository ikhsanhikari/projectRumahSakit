/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.ObatMasukModel;
import rumahsakit.model.RawatInapModel;

/**
 *
 * @author hikari
 */
public interface RawatInapDao {
    
    public List<RawatInapModel> listRawatInap() throws Exception;
    
    public List<Object[]> listRawatInapNative() throws Exception;

    public List<RawatInapModel> listRawatInapUpdate(Integer id) throws Exception;

    public void saveDataRawatInap(RawatInapModel rawatInapModel);

    public void updateDataRawatInap(RawatInapModel rawatInapModel) throws Exception;

    public RawatInapModel getRawatInapById(Integer id);
    
    public void hapusRawatInap(Integer id);
    
    public void updateNativeRawatInap(Integer index);
    
    public List<RawatInapModel> cekPasienRawatInap(Integer index);
    
    public List<Object[]> listRuanganPasien() throws Exception;
    
    final String sqlRuanganPasien="SELECT p.id_pasien,p.nama_pasien ,nr.nomor_ruangan, r.jenis_ruangan from ruangan r, nomor_ruangan nr, pasien p, rawat_inap ri where r.id_ruangan=nr.id_ruangan and p.Id_pasien = ri.id_pasien and ri.id_nomor_ruangan = nr.id_nomor_ruangan";

    final String sqlRawatInap="select ri.id_rawat_inap , p.nama_pasien,ri.tgl_masuk,ri.tgl_keluar,nr.nomor_ruangan,ri.catatan_medis_rawat_inap from rawat_inap ri inner join pasien p inner join nomor_ruangan nr on ri.id_pasien=p.Id_pasien and ri.id_nomor_ruangan = nr.id_nomor_ruangan";
}
