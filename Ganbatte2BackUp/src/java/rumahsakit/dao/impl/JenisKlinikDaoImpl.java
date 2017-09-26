/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.JenisKlinikDao;
import rumahsakit.model.JenisKlinikModel;

/**
 *
 * @author sou
 */
@Repository
public class JenisKlinikDaoImpl extends HibernateUtil implements JenisKlinikDao{

    @Override
    public List<JenisKlinikModel> listJenisKlinik() throws Exception {
        List<JenisKlinikModel> daftarJenisKlinik = null;
        try {
            String sql = "select model from JenisKlinikModel model";
            Query query = createQuery(sql);
            daftarJenisKlinik = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarJenisKlinik;
    }

    @Override
    public List<JenisKlinikModel> listJenisKlinikUpdate(Integer id) throws Exception {
        List<JenisKlinikModel> daftarJenisKlinik = null;
        try {
            String sql = "select model from JenisKlinikModel model where id_jenis_klinik=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarJenisKlinik = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarJenisKlinik;
    }

    @Override
    public JenisKlinikModel getJenisKlinikById(Integer id) throws Exception {
        JenisKlinikModel jenisKlinikModel= new JenisKlinikModel();
        Query query =null;
        try {
            String sql = "select model from JenisKlinikModel model where id_jenis_klinik=:id";
            query = createQuery(sql).setParameter("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JenisKlinikModel)query.uniqueResult();
    }

    @Override
    public void saveDataJenisKlinik(JenisKlinikModel jenisKlinikModel) {
        try {
            getSession().save(jenisKlinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataJenisKlinik(JenisKlinikModel jenisKlinikModel) throws Exception {
        try {
            getSession().update(jenisKlinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusJenisKlinik(Integer id) {
        JenisKlinikModel jenisKlinikModel= new JenisKlinikModel();
        try {
            jenisKlinikModel.setId_jenis_klinik(id);
            getSession().delete(jenisKlinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
