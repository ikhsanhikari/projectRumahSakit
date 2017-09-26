/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.RuanganModel;

/**
 *
 * @author sou
 */
public interface RuanganDao {

    public List<RuanganModel> listRuangan() throws Exception;

    public List<RuanganModel> listRuanganUpdate(Integer id) throws Exception;

    public void saveDataRuangan(RuanganModel ruanganModel);

    public void updateDataRuangan(RuanganModel ruanganModel) throws Exception;

    public void hapusRuangan(Integer id);

    
}
