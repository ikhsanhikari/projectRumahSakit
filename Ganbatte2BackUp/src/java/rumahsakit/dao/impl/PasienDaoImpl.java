/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.PasienDao;
import rumahsakit.model.PasienModel;

/**
 *
 * @author sou
 */
@Repository
public class PasienDaoImpl extends HibernateUtil implements PasienDao {

    @Override
    public List<PasienModel> listPasien() throws Exception {
        List<PasienModel> daftarPasien = null;
        try {
            String sql = "select model from PasienModel model";
            Query query = createQuery(sql);
            daftarPasien = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarPasien;
    }

    @Override
    public List<PasienModel> listPasienUpdate(Integer id) throws Exception {
        List<PasienModel> daftarPasien = null;
        try {
            String sql = "select model from PasienModel model where id=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarPasien = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarPasien;
    }

    @Override
    public PasienModel getPasienById(Integer id) throws Exception {
        PasienModel pasienModel= new PasienModel();
        Query query =null;
        try {
            String sql = "select model from PasienModel model where id_pasien=:id";
            query = createQuery(sql).setParameter("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (PasienModel)query.uniqueResult();
    }

    @Override
    public void saveDataPasien(PasienModel pasienModel) {
        try {
            getSession().save(pasienModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataPasien(PasienModel pasienModel) throws Exception {
        try {
            getSession().update(pasienModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusPasien(Integer id) {
        PasienModel pasienModel = null;
        try {
            pasienModel = new PasienModel();
            pasienModel.setId_pasien(id);
            getSession().delete(pasienModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object[]> listPasienBerita() {
        Query query= createNativeQuery(sqlRekamMedis);
        return query.list();
    }

    @Override
    public List<PasienModel> listPasien10() throws Exception {
        List<PasienModel> daftarPasien = null;
        try {
            String sql = "select model from PasienModel model order by id_pasien desc";
            Query query = createQuery(sql);
            query.setMaxResults(5);
            daftarPasien = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarPasien;
    }

    @Override
    public List<PasienModel> listPasienMenunggu() throws Exception {
        List<PasienModel> daftarPasien = null;
        try {
            String sql = "select model from PasienModel model where keterangan='menunggu..'";
            Query query = createQuery(sql);
            daftarPasien = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarPasien;
    }

    @Override
    public void updateKeterangan(Integer index) {
        String sql="update pasien set keterangan = 'sudah diperiksa' where id_pasien=:id";
        Query query= createNativeQuery(sql).setParameter("id", index);
        Integer t= query.executeUpdate();
    }

}
