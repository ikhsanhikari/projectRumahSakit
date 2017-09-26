/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.BiayaDao;
import rumahsakit.model.BiayaModel;

/**
 *
 * @author hikari
 */
@Repository
public class BiayaDaoImpl extends HibernateUtil implements BiayaDao{

    @Override
    public List<Object[]> listBiaya() {
        String sql="select id_biaya,nama_pasien, ";
        Query query = createNativeQuery(sql);
        return query.list();
    }

    @Override
    public List<BiayaModel> listBiayaUpdate(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDataBiaya(BiayaModel obatModel) {
        try {
            getSession().save(obatModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataBiaya(BiayaModel obatModel) {
        try {
            getSession().update(obatModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusBiaya(Integer id) {
        BiayaModel biayaModel= new BiayaModel();
        biayaModel.setId_biaya(id);
        try {
            getSession().delete(biayaModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
