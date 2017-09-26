/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.RuanganDao;
import rumahsakit.model.RuanganModel;


@Repository
public class RuanganDaoImpl extends HibernateUtil implements RuanganDao{

    @Override
    public List<RuanganModel> listRuangan() throws Exception {
        List<RuanganModel> daftarRuangan = null;
        try {
            String sql = "select model from RuanganModel model";
            Query query = createQuery(sql);
            daftarRuangan = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarRuangan;
    }

    @Override
    public List<RuanganModel> listRuanganUpdate(Integer id) throws Exception {
        List<RuanganModel> daftarRuangan = null;
        try {
            String sql = "select model from RuanganModel model where id_ruangan=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarRuangan = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarRuangan;
    }

    

    @Override
    public void saveDataRuangan(RuanganModel ruanganModel) {
        try {
            getSession().save(ruanganModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataRuangan(RuanganModel ruanganModel) throws Exception {
        try {
            getSession().update(ruanganModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusRuangan(Integer id) {
        RuanganModel ruanganModel = new RuanganModel();
        ruanganModel.setId_ruangan(id);
        try {
            getSession().delete(ruanganModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
