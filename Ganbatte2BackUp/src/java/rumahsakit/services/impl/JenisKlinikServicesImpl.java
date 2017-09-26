/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rumahsakit.dao.JenisKlinikDao;
import rumahsakit.dto.JenisKlinikDto;
import rumahsakit.model.JenisKlinikModel;
import rumahsakit.services.JenisKlinikServices;

/**
 *
 * @author sou
 */
@Service
@Transactional
public class JenisKlinikServicesImpl implements JenisKlinikServices{
    
    @Autowired
    JenisKlinikDao jenisKlinikDao;

    @Override
    public List<JenisKlinikDto> listJenisKlinik() throws Exception {
        List<JenisKlinikDto> listDto= null;
        List<JenisKlinikModel> listModel=null;
        JenisKlinikDto jenisKlinikDto= null;
        try {
            listDto= new ArrayList<>();
            listModel= jenisKlinikDao.listJenisKlinik();
            for (JenisKlinikModel jenisKlinikModel : listModel) {
                jenisKlinikDto= new JenisKlinikDto();
                jenisKlinikDto.setId_jenis_klinik(jenisKlinikModel.getId_jenis_klinik());
                jenisKlinikDto.setNama_klinik(jenisKlinikModel.getNama_klinik());
                jenisKlinikDto.setBiaya(String.valueOf(jenisKlinikModel.getBiaya()));
                listDto.add(jenisKlinikDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
        
    }

    @Override
    public JenisKlinikDto listJenisKlinikUpdate(Integer id) throws Exception {
        List<JenisKlinikModel> listModel=null;
        JenisKlinikDto jenisKlinikDto= null;
        try {
            listModel= jenisKlinikDao.listJenisKlinikUpdate(id);
            for (JenisKlinikModel jenisKlinikModel : listModel) {
                jenisKlinikDto= new JenisKlinikDto();
                jenisKlinikDto.setId_jenis_klinik(jenisKlinikModel.getId_jenis_klinik());
                jenisKlinikDto.setNama_klinik(jenisKlinikModel.getNama_klinik());
                jenisKlinikDto.setBiaya(String.valueOf(jenisKlinikModel.getBiaya()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jenisKlinikDto;
    }

    

    @Override
    public void saveDataJenisKlinik(JenisKlinikDto jenisKlinikDto) {
        JenisKlinikModel jenisKlinikModel =null; 
        try {
            jenisKlinikModel=new JenisKlinikModel();
            jenisKlinikModel.setId_jenis_klinik(jenisKlinikDto.getId_jenis_klinik());
            jenisKlinikModel.setNama_klinik(jenisKlinikDto.getNama_klinik());
            jenisKlinikModel.setBiaya(Double.parseDouble(jenisKlinikDto.getBiaya()));
            jenisKlinikDao.saveDataJenisKlinik(jenisKlinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataJenisKlinik(JenisKlinikDto jenisKlinikDto) throws Exception {
        JenisKlinikModel jenisKlinikModel =null; 
        try {
            jenisKlinikModel=new JenisKlinikModel();
            jenisKlinikModel.setId_jenis_klinik(jenisKlinikDto.getId_jenis_klinik());
            jenisKlinikModel.setNama_klinik(jenisKlinikDto.getNama_klinik());
            jenisKlinikModel.setBiaya(Double.parseDouble(jenisKlinikDto.getBiaya()));
            jenisKlinikDao.updateDataJenisKlinik(jenisKlinikModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusJenisKlinik(Integer id) {
        try {
            jenisKlinikDao.hapusJenisKlinik(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
