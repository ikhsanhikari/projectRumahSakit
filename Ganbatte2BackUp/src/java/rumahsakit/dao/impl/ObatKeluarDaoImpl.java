/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.ObatKeluarDao;
import rumahsakit.model.ObatKeluarModel;

/**
 *
 * @author sou
 */
@Repository
public class ObatKeluarDaoImpl extends HibernateUtil implements ObatKeluarDao {

    @Override
    public List<ObatKeluarModel> listObatKeluar() {
        List<ObatKeluarModel> daftarObatKeluar = null;
        try {
            String sql = "select model from ObatKeluarModel model";
            Query query = createQuery(sql);
            daftarObatKeluar = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarObatKeluar;
    }

    @Override
    public List<ObatKeluarModel> listObatKeluarUpdate(Integer id) {
        List<ObatKeluarModel> daftarObatKeluar = null;
        try {
            String sql = "select model from ObatKeluarModel model where id_obat_keluar=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarObatKeluar = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarObatKeluar;
    }

    @Override
    public void saveDataObatKeluar(ObatKeluarModel obatKeluarModel) {
        try {
            getSession().save(obatKeluarModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataObatKeluar(ObatKeluarModel obatKeluarModel) {
        try {
            getSession().update(obatKeluarModel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void hapusObatKeluar(Integer id) {
        ObatKeluarModel obatKeluarModel = new ObatKeluarModel();
        obatKeluarModel.setId_obat_keluar(id);
        getSession().delete(obatKeluarModel);
    }

    @Override
    public void updateStatusObat(Integer id) {
        String sql = "update obat_keluar set status_obat='sudah diambil',tgl_pembayaran=curdate() where id_obat_keluar = :id";
        Query query = createNativeQuery(sql).setParameter("id", id);
        Integer r = query.executeUpdate();
    }

}
