/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.ObatKeluarModel;

/**
 *
 * @author sou
 */
public interface ObatKeluarDao {
     
    public List<ObatKeluarModel> listObatKeluar();

    public List<ObatKeluarModel> listObatKeluarUpdate(Integer id);

    public void saveDataObatKeluar(ObatKeluarModel obatKeluarModel);

    public void updateDataObatKeluar(ObatKeluarModel obatKeluarModel);

    public void hapusObatKeluar(Integer id);
    
    public void updateStatusObat(Integer id);
}
