/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.KlinikDao;
import rumahsakit.model.KeluhanModel;
import rumahsakit.model.KlinikModel;
import rumahsakit.model.TindakanModel;

/**
 *
 * @author sou
 */
@Repository
public class KlinikDaoImpl extends HibernateUtil implements KlinikDao {

    @Override
    public List<KlinikModel> listKlinik() throws Exception {
        List<KlinikModel> daftarKlinik = null;
        try {
            String sql = "select model from KlinikModel model";
            Query query = createQuery(sql);
            daftarKlinik = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarKlinik;
    }

    @Override
    public List<KlinikModel> listKlinikUpdate(Integer id) throws Exception {
        List<KlinikModel> daftarKlinik = null;
        try {
            String sql = "select model from KlinikModel model where id_klinik=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarKlinik = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarKlinik;
    }

    @Override
    public KlinikModel getKlinikById(Integer id) throws Exception {
        KlinikModel KlinikModel = new KlinikModel();
        Query query = null;
        try {
            String sql = "select model from KlinikModel model where id_klinik=:id";
            query = createQuery(sql).setParameter("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (KlinikModel) query.uniqueResult();
    }

    @Override
    public void saveDataKlinik(KlinikModel klinikModel) {
        try {
            getSession().save(klinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataKlinik(KlinikModel klinikModel) throws Exception {
        try {
            getSession().update(klinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusKlinik(Integer id) {
        KlinikModel klinikModel = new KlinikModel();
        try {
            klinikModel.setId_klinik(id);
            getSession().delete(klinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object[]> listKlinikNative() {
        Query query=null;
        try {
            query = createNativeQuery(sqlListKlinik);
        } catch (Exception e) {
        }
        
        return query.list();
    }

    @Override
    public void insertIdPasien(Integer index) {
        String sql = "insert into klinik (id_pasien,keluhan,jenis_klinik,penyakit,catatan_medis_klinik,biaya,proses_perawatan) "
                + "values(:index,'-',0,'-','-',0.0,'-')";
        Query query = createNativeQuery(sql).setParameter("index", index);
        Integer r = query.executeUpdate();
    }

    @Override
    public void updateIdKlinik(Integer index, Integer where) {
        String sql = "update klinik set jenis_klinik = :index where id_klinik = :where";
        Query query = createNativeQuery(sql).setParameter("index", index).setParameter("where", where);
        Integer r = query.executeUpdate();
    }

    @Override
    public List<Object[]> getKlinik(Integer index) {
        String sql = "select k.*,p.*,jk.nama_klinik from pasien p inner join klinik k inner join jenis_klinik jk on p.Id_pasien=k.id_pasien and k.jenis_klinik=jk.Id_Jenis_Kelinik where k.id_klinik=:id";
        Query query = createNativeQuery(sql).setParameter("id", index);
        return query.list();
    }

    @Override
    public List<KlinikModel> listKlinikMenunggu() {
        List<KlinikModel> daftarKlinik = null;
        try {
            String sql = "select model from KlinikModel model where keterangan='menunggu..'";
            Query query = createQuery(sql);
            daftarKlinik = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarKlinik;
    }

    @Override
    public List<Object[]> listKlinikDokterMenunggu() {
        Query query = createNativeQuery(sqlListKlinikDokterMenunggu);
        return query.list();
    }

    @Override
    public List<Object[]> listKlinikRawatInap() {
        Query query = createNativeQuery(sqlListKlinikRawatInap);
        return query.list();
    }

    @Override
    public void updateKeterangan(Integer id) {
        String sql = "update klinik set proses_perawatan = 'sedang di rawat inap' where id_pasien=:id";
        Query query = createNativeQuery(sql).setParameter("id", id);
        Integer t = query.executeUpdate();
    }

    @Override
    public List<Object[]> listKlinikDokterSudahDiPeriksa() {
        Query query = createNativeQuery(sqlListKlinikDokterSudahDiperiksa);
        return query.list();
    }

    @Override
    public void saveKeluhan(KeluhanModel keluhanModel) {
        try {
            getSession().save(keluhanModel);
        } catch (Exception e) {
        }
    }

    @Override
    public void saveTindakan(TindakanModel tindakanModel) {
        try {
            getSession().save(tindakanModel);
        } catch (Exception e) {
        }
    }

    @Override
    public List<KeluhanModel> getKeluhan(Integer id) {
         List<KeluhanModel> daftarKeluhan = null;
        try {
            String sql = "select model from KeluhanModel model where id_klinik=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarKeluhan = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarKeluhan;
    }

    @Override
    public List<TindakanModel> getTindakan(Integer id) {
        List<TindakanModel> daftarTindakan = null;
        try {
            String sql = "select model from TindakanModel model where id_klinik=:id";
            Query query = createQuery(sql).setParameter("id", id);
            daftarTindakan = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daftarTindakan;
    }

    @Override
    public List<Object[]> listKlinikNative(Integer id) {
        Query query = createNativeQuery(sqlListKlinik).setParameter("id", id);
        return query.list();
    }

}
