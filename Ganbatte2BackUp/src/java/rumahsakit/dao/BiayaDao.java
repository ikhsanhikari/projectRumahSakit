/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.BiayaModel;

/**
 *
 * @author hikari
 */
public interface BiayaDao {

    public List<Object[]> listBiaya();

    public List<BiayaModel> listBiayaUpdate(Integer id);

    public void saveDataBiaya(BiayaModel obatModel);

    public void updateDataBiaya(BiayaModel obatModel);

    public void hapusBiaya(Integer id);
}
