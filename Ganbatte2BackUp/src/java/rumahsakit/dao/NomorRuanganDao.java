/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.NomorRuanganModel;

/**
 *
 * @author hikari
 */
public interface NomorRuanganDao {

    public List<NomorRuanganModel> listNomorRuangan() throws Exception;

    public List<NomorRuanganModel> listNomorRuanganUpdate(Integer id) throws Exception;

    public void saveDataRuangan(NomorRuanganModel ruanganModel);

    public void updateNomorRuangan(NomorRuanganModel ruanganModel) throws Exception;

    public void hapusNomorRuangan(Integer id);
    
    public List<Object[]> listRuanganNative();
    
    public NomorRuanganModel getNomorRuanganById(Integer id);
    
    public void updateNomorKosong(Integer index);
    
    final String queryListRuangan="select nr.id_nomor_ruangan,r.jenis_ruangan,nr.nomor_ruangan,nr.status_ruangan\n" +
                                  "from ruangan r inner join nomor_ruangan nr on r.id_ruangan=nr.id_ruangan";
}
