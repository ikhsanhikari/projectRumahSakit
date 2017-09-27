/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rumahsakit.dao.BiayaDao;
import rumahsakit.dto.BiayaDto;
import rumahsakit.model.BiayaModel;
import rumahsakit.services.BiayaServices;

/**
 *
 * @author hikari
 */
@Service
@Transactional
public class BiayaServicesImpl implements BiayaServices{

    @Autowired
    BiayaDao biayaDao;
    
    @Override
    public List<Object[]> listBiaya() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BiayaDto> listBiayaUpdate(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDataBiaya(BiayaDto biayaDto) {
        BiayaModel biayaModel= new BiayaModel();
        biayaModel.setId_biaya(1);
        biayaModel.setBiaya_administrasi(biayaDto.getBiaya_administrasi());
        biayaModel.setBiaya_ambulance(biayaDto.getBiaya_ambulance());
        biayaModel.setBiaya_dokter(biayaDto.getBiaya_dokter());
        biayaModel.setBiaya_lab(biayaDto.getBiaya_lab());
        biayaModel.setBiaya_lain_lain(biayaDto.getBiaya_lain_lain());
        biayaModel.setBiaya_observasi(biayaDto.getBiaya_observasi());
        biayaModel.setBiaya_perawatan(biayaDto.getBiaya_perawatan());
        biayaModel.setBiaya_ruangan(biayaDto.getBiaya_ruangan());
        biayaModel.setBiaya_tindakan(biayaDto.getBiaya_tindakan());
        biayaModel.setBiaya_visit_dokter(biayaDto.getBiaya_visit_spesialis());
        biayaModel.setBiaya_visit_spesialis(biayaDto.getBiaya_visit_spesialis());
        biayaModel.setId_pasien(biayaDto.getId_pasien());
        biayaModel.setTotal_biaya(0.0);
        biayaDao.saveDataBiaya(biayaModel);
    }

    @Override
    public void updateDataBiaya(BiayaDto biayaDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapusBiaya(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
