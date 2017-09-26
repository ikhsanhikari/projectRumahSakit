/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.NomorRuanganDao;
import rumahsakit.model.NomorRuanganModel;

/**
 *
 * @author hikari
 */
@Repository
public class NomorRuanganDaoImpl extends HibernateUtil implements NomorRuanganDao {

    @Override
    public List<NomorRuanganModel> listNomorRuangan() throws Exception {
        List<NomorRuanganModel> daftarNomorRuangan = null;
        try {
            String sql = "select model from NomorRuanganModel model";
            Query query = createQuery(sql);
            daftarNomorRuangan = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarNomorRuangan;
    }

    @Override
    public List<NomorRuanganModel> listNomorRuanganUpdate(Integer id) throws Exception {
        List<NomorRuanganModel> daftarNomorRuangan = null;
        try {
            String sql = "select model from NomorRuanganModel model where id_nomor_ruangan=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarNomorRuangan = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarNomorRuangan;
    }

    @Override
    public void saveDataRuangan(NomorRuanganModel ruanganModel) {
        try {
            getSession().save(ruanganModel);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateNomorRuangan(NomorRuanganModel ruanganModel) throws Exception {
        try {
            getSession().update(ruanganModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusNomorRuangan(Integer id) {
        NomorRuanganModel ruanganModel = new NomorRuanganModel();
        ruanganModel.setId_nomor_ruangan(id);
        try {
            getSession().delete(ruanganModel);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Object[]> listRuanganNative() {
        Query query = createNativeQuery(queryListRuangan);
        return query.list();
    }

    @Override
    public NomorRuanganModel getNomorRuanganById(Integer id) {
        NomorRuanganModel obatModel = new NomorRuanganModel();
        Query query = null;
        try {
            String sql = "select model from NomorRuanganModel model where id_nomor_ruangan=:id";
            query = createQuery(sql).setParameter("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (NomorRuanganModel) query.uniqueResult();
    }

    @Override
    public void updateNomorKosong(Integer index) {
        String sql = "UPDATE nomor_ruangan nr, rawat_inap ri set nr.status_ruangan = 'kosong' where ri.id_rawat_inap=:id ";
        Query query = createNativeQuery(sql).setParameter("id", index);
        Integer u = query.executeUpdate();
    }

}
