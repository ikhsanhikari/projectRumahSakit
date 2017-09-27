/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.JenisKlinikDto;
import rumahsakit.model.JenisKlinikModel;

/**
 *
 * @author sou
 */
public interface JenisKlinikServices {
    public List<JenisKlinikDto> listJenisKlinik() throws Exception;

    public JenisKlinikDto listJenisKlinikUpdate(Integer id) throws Exception;

    public void saveDataJenisKlinik(JenisKlinikDto jenisKlinikDto);

    public void updateDataJenisKlinik(JenisKlinikDto jenisKlinikDto) throws Exception;

    public void hapusJenisKlinik(Integer id);
}
