/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.JenisKlinikModel;

/**
 *
 * @author sou
 */
public interface JenisKlinikDao {
    
    public List<JenisKlinikModel> listJenisKlinik() throws Exception;

    public List<JenisKlinikModel> listJenisKlinikUpdate(Integer id) throws Exception;

    public JenisKlinikModel getJenisKlinikById(Integer id) throws Exception;

    public void saveDataJenisKlinik(JenisKlinikModel jenisKlinikModel);

    public void updateDataJenisKlinik(JenisKlinikModel jenisKlinikModel) throws Exception;

    public void hapusJenisKlinik(Integer id);   
}
