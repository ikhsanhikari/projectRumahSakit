/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rumahsakit.dao.ObatDao;
import rumahsakit.dao.ObatMasukDao;
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatMasukDto;
import rumahsakit.dto.ObatMasukDto;
import rumahsakit.model.ObatMasukModel;
import rumahsakit.model.ObatModel;
import rumahsakit.services.ObatMasukServices;

/**
 *
 * @author hikari
 */
@Transactional
@Service
public class ObatMasukServicesImpl implements ObatMasukServices{

    @Autowired
    ObatMasukDao obatMasukDao;
    
    @Autowired
    ObatDao obatDao;
    
    @Override
    public List<ObatMasukDto> listObatMasuk() throws Exception {
        List<ObatMasukDto> listDto= null;
        List<ObatMasukModel> listModel =null;
        ObatMasukDto obatDto=null;
        try {
            listDto= new ArrayList<>();
            listModel = obatMasukDao.listObatMasuk();
            if(listModel!=null){
                for (ObatMasukModel pm : listModel) {
                    obatDto= new ObatMasukDto();
                    obatDto.setId_obat_masuk(pm.getId_obat_masuk());
                    obatDto.setId_obat(pm.getId_obat());
                    obatDto.setTgl_obat_masuk(pm.getTgl_obat_masuk());
                    obatDto.setJumlah_obat_masuk(pm.getJumlah_obat_masuk());
                    obatDto.setHarga_beli_obat_masuk(pm.getHarga_beli_obat_masuk());
                    listDto.add(obatDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto; 
    }

    @Override
    public void saveDataObatMasuk(ObatMasukDto obatDto) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currDate = dateFormat.format(date);
        ObatMasukModel obatMasukModel= new ObatMasukModel();
        ObatModel od= obatDao.getObatById(obatDto.getId_obat());
        obatMasukModel.setId_obat_masuk(1);
        obatMasukModel.setId_obat(obatDto.getId_obat());
        obatMasukModel.setHarga_beli_obat_masuk(obatDto.getHarga_beli_obat_masuk());
        obatMasukModel.setJumlah_obat_masuk(obatDto.getJumlah_obat_masuk());
        obatMasukModel.setTgl_obat_masuk(currDate);
        od.setStok_obat(od.getStok_obat()+obatDto.getJumlah_obat_masuk());
        obatMasukDao.saveDataObatMasuk(obatMasukModel);
    }

    @Override
    public void updateDataObatMasuk(ObatMasukDto obatDto) throws Exception {
        ObatMasukModel obatMasukModel= new ObatMasukModel();
        obatMasukModel.setId_obat_masuk(obatDto.getId_obat_masuk());
        obatMasukModel.setId_obat(obatDto.getId_obat());
        obatMasukModel.setHarga_beli_obat_masuk(obatDto.getHarga_beli_obat_masuk());
        obatMasukModel.setJumlah_obat_masuk(obatDto.getJumlah_obat_masuk());
        obatMasukModel.setTgl_obat_masuk(obatDto.getTgl_obat_masuk());
        obatMasukDao.updateDataObatMasuk(obatMasukModel);
    }

    @Override
    public ObatMasukDto getListObatMasukUpdate(Integer id) throws Exception {
       List<ObatMasukModel> listModel =null;
        ObatMasukDto obatDto=null;
        try {
            listModel = obatMasukDao.listObatMasuk();
            if(listModel!=null){
                for (ObatMasukModel pm : listModel) {
                    obatDto= new ObatMasukDto();
                    obatDto.setId_obat_masuk(pm.getId_obat_masuk());
                    obatDto.setId_obat(pm.getId_obat());
                    obatDto.setTgl_obat_masuk(pm.getTgl_obat_masuk());
                    obatDto.setJumlah_obat_masuk(pm.getJumlah_obat_masuk());
                    obatDto.setHarga_beli_obat_masuk(pm.getHarga_beli_obat_masuk());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obatDto; 
    }

    @Override
    public void hapusObatMasuk(Integer id) {
        try {
            obatMasukDao.hapusObatMasuk(id);
        } catch (Exception e) {
        }
    }
    
}
