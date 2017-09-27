/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.ObatDao;
import rumahsakit.model.ObatModel;

/**
 *
 * @author sou
 */
@Repository
public class ObatDaoImpl extends HibernateUtil implements ObatDao{

    @Override
    public List<ObatModel> listObat() {
        List<ObatModel> daftarObat = null;
        try {
            String sql = "select model from ObatModel model";
            Query query = createQuery(sql);
            daftarObat = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarObat;
    }

    @Override
    public List<ObatModel> listObatUpdate(Integer id) {
        List<ObatModel> daftarObat = null;
        try {
            String sql = "select model from ObatModel model where id_obat=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarObat = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarObat;
    }

    @Override
    public ObatModel getObatById(Integer id) {
        ObatModel obatModel= new ObatModel();
        Query query =null;
        try {
            String sql = "select model from ObatModel model where id_obat=:id";
            query = createQuery(sql).setParameter("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ObatModel)query.uniqueResult();
    }

    @Override
    public void saveDataObat(ObatModel obatModel) {
        try {
            getSession().save(obatModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataObat(ObatModel obatModel) {
        try {
            getSession().update(obatModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusObat(Integer id) {
        ObatModel obatModel = null;
        try {
            obatModel = new ObatModel();
            obatModel.setId_obat(id);
            getSession().delete(obatModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object[]> listObatBelumDiAmbil() {
        Query query=null;
        try {
            query = createNativeQuery(sqlBelumDiAmbil);
        } catch (Exception e) {
        }
        
        return query.list();
    }

    @Override
    public List<Object[]> listObatSudahDiAmbil() {
        Query query=null;
        try {
            query = createNativeQuery(sqlSudahDiAmbil);
        } catch (Exception e) {
        }
        
        return query.list();
    }
    
}
