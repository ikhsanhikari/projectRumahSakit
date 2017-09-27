/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.ObatMasukDao;
import rumahsakit.model.ObatMasukModel;

/**
 *
 * @author hikari
 */
@Repository
public class ObatMasukDaoImpl extends HibernateUtil implements ObatMasukDao{

    @Override
    public List<ObatMasukModel> listObatMasuk() {
        List<ObatMasukModel> daftarObatMasuk = null;
        try {
            String sql = "select model from ObatMasukModel model";
            Query query = createQuery(sql);
            daftarObatMasuk = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarObatMasuk;
    }

    @Override
    public List<ObatMasukModel> listObatMasukUpdate(Integer id) {
        List<ObatMasukModel> daftarObatMasuk = null;
        try {
            String sql = "select model from ObatMasukModel model where id_obat_masuk=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarObatMasuk = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarObatMasuk;
    }

    @Override
    public void saveDataObatMasuk(ObatMasukModel obatMasukModel) {
        try {
            getSession().save(obatMasukModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataObatMasuk(ObatMasukModel obatMasukModel) {
        try {
            getSession().update(obatMasukModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusObatMasuk(Integer id) {
        ObatMasukModel obatMasukModel= new ObatMasukModel();
        obatMasukModel.setId_obat_masuk(id);
        getSession().delete(obatMasukModel);
    }
    
}
