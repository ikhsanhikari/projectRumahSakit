/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.RawatInapDao;
import rumahsakit.model.RawatInapModel;

/**
 *
 * @author hikari
 */
@Repository
public class RawatInapDaoImpl extends HibernateUtil implements RawatInapDao{

    @Override
    public List<RawatInapModel> listRawatInap() throws Exception {
        List<RawatInapModel> daftarRawatInap = null;
        try {
            String sql = "select model from RawatInapModel model";
            Query query = createQuery(sql);
            daftarRawatInap = query.list();
        } catch (Exception e) {

        }
        return daftarRawatInap;
    }

    @Override
    public List<RawatInapModel> listRawatInapUpdate(Integer id) throws Exception {
        List<RawatInapModel> daftarRawatInap = null;
        try {
            String sql = "select model from RawatInapModel model where id_rawat_inap=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarRawatInap = query.list();
        } catch (Exception e) {

        }
        return daftarRawatInap;
    }

   

    @Override
    public void saveDataRawatInap(RawatInapModel rawatInapModel) {
        try {
            getSession().save(rawatInapModel);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateDataRawatInap(RawatInapModel rawatInapModel) throws Exception {
        try {
            getSession().update(rawatInapModel);
        } catch (Exception e) {
        }
    }

    @Override
    public void hapusRawatInap(Integer id) {
        RawatInapModel rawatInapModel= new RawatInapModel();
        rawatInapModel.setId_rawat_inap(id);
        try {
            getSession().delete(rawatInapModel);
        } catch (Exception e) {
           
        }
    }

    @Override
    public List<Object[]> listRawatInapNative() throws Exception {
        Query query= createNativeQuery(sqlRawatInap);
        return query.list();
    }

    @Override
    public void updateNativeRawatInap(Integer index) {
        String sql="update rawat_inap set tgl_keluar = curdate() where id_rawat_inap =:id ";
        Query query= createNativeQuery(sql).setParameter("id", index);
        Integer u=query.executeUpdate();
    }

    @Override
    public RawatInapModel getRawatInapById(Integer id) {
         RawatInapModel obatModel= new RawatInapModel();
        Query query =null;
        try {
            String sql = "select model from RawatInapModel model where id_rawat_inap=:id";
            query = createQuery(sql).setParameter("id", id);
        } catch (Exception e) {
        }
        return (RawatInapModel)query.uniqueResult();
    }

    @Override
    public List<RawatInapModel> cekPasienRawatInap(Integer index) {
        List<RawatInapModel> daftarRawatInap = null;
        try {
            String sql = "select model from RawatInapModel model where id_pasien=:id";
            Query query = createQuery(sql).setParameter("id", index);
            daftarRawatInap = query.list();
        } catch (Exception e) {

        }
        return daftarRawatInap;
    }

    @Override
    public List<Object[]> listRuanganPasien() throws Exception {
        Query query= createNativeQuery(sqlRuanganPasien);
        return query.list();
    }

}
