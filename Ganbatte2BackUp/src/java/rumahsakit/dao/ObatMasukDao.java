/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.ObatMasukModel;

/**
 *
 * @author hikari
 */
public interface ObatMasukDao {
    
    public List<ObatMasukModel> listObatMasuk();

    public List<ObatMasukModel> listObatMasukUpdate(Integer id);

    public void saveDataObatMasuk(ObatMasukModel obatMasukModel);

    public void updateDataObatMasuk(ObatMasukModel obatMasukModel);

    public void hapusObatMasuk(Integer id);
}
