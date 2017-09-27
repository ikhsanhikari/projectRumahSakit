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
import rumahsakit.dao.ObatKeluarDao;
import rumahsakit.dao.PasienDao;
import rumahsakit.dto.ObatKeluarDto;
import rumahsakit.model.ObatKeluarModel;
import rumahsakit.model.ObatModel;
import rumahsakit.model.PasienModel;
import rumahsakit.services.ObatKeluarServices;

/**
 *
 * @author sou
 */
@Service
@Transactional
public class ObatKeluarServicesImpl implements ObatKeluarServices{

    @Autowired
    ObatKeluarDao obatKeluarDao;
    
    @Autowired
    ObatDao obatDao;
    
    @Autowired
    PasienDao pasienDao;
    
    
    @Override
    public List<ObatKeluarDto> listObatKeluar() throws Exception {
        List<ObatKeluarDto> listDto= null;
        List<ObatKeluarModel> listModel =null;
        ObatKeluarDto obatDto=null;
        try {
            listDto= new ArrayList<>();
            listModel = obatKeluarDao.listObatKeluar();
            if(listModel!=null){
                for (ObatKeluarModel pm : listModel) {
                    obatDto = new ObatKeluarDto();
                    obatDto.setId_obat_keluar(pm.getId_obat_keluar());
                    obatDto.setId_obat(pm.getId_obat());
                    obatDto.setJumlah_obat_keluar(pm.getJumlah_obat_keluar());
                    obatDto.setId_pasien(pm.getId_pasien());
                    obatDto.setHarga_obat_keluar(pm.getHarga_obat_keluar());
                    obatDto.setTgl_obat_keluar(pm.getTgl_obat_keluar());
                    obatDto.setTgl_pembayaran(pm.getTgl_pembayaran());
                    listDto.add(obatDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public void saveDataObatKeluar(ObatKeluarDto obatDto) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        String currDate = dateFormat.format(date); 
        ObatModel obatModel= null;
        obatModel=obatDao.getObatById(obatDto.getId_obat());
        ObatKeluarModel obatKeluarModel =new ObatKeluarModel();
        obatKeluarModel.setId_obat_keluar(1);
        obatKeluarModel.setHarga_obat_keluar(obatModel.getHarga_obat()*obatDto.getJumlah_obat_keluar());
        obatKeluarModel.setTgl_obat_keluar(currDate);
        obatKeluarModel.setTgl_pembayaran("-");
        obatKeluarModel.setId_pasien(obatDto.getId_pasien());
        obatKeluarModel.setJumlah_obat_keluar(obatDto.getJumlah_obat_keluar());
        obatModel.setStok_obat(obatModel.getStok_obat()-obatDto.getJumlah_obat_keluar());
        obatKeluarModel.setId_obat(obatDto.getId_obat());
        obatKeluarModel.setStatus_obat("belum diambil");
        obatKeluarDao.saveDataObatKeluar(obatKeluarModel);
    }

    @Override
    public void updateDataObatKeluar(ObatKeluarDto obatDto) throws Exception {
        ObatKeluarModel obatKeluarModel =new ObatKeluarModel();
        obatKeluarModel.setId_obat_keluar(obatDto.getId_obat_keluar());
        obatKeluarModel.setHarga_obat_keluar(obatDto.getHarga_obat_keluar());
        obatKeluarModel.setTgl_obat_keluar(obatDto.getTgl_obat_keluar());
        obatKeluarModel.setTgl_pembayaran(obatDto.getTgl_pembayaran());
        obatKeluarModel.setId_pasien(obatDto.getId_pasien());
        obatKeluarModel.setJumlah_obat_keluar(obatDto.getJumlah_obat_keluar());
        obatKeluarModel.setId_obat(obatDto.getId_obat());
        obatKeluarDao.updateDataObatKeluar(obatKeluarModel);
    }

    @Override
    public ObatKeluarDto getListObatKeluarUpdate(Integer id) throws Exception {
        List<ObatKeluarModel> listModel =null;
        ObatKeluarDto obatDto=null;
        try {
            listModel = obatKeluarDao.listObatKeluarUpdate(id);
            if(listModel!=null){
                for (ObatKeluarModel pm : listModel) {
                    obatDto= new ObatKeluarDto();
                    obatDto.setId_obat(pm.getId_obat());
                    obatDto.setId_obat_keluar(pm.getId_obat_keluar());
                    obatDto.setId_pasien(pm.getId_pasien());
                    obatDto.setHarga_obat_keluar(pm.getHarga_obat_keluar());
                    obatDto.setTgl_obat_keluar(pm.getTgl_obat_keluar());
                    obatDto.setJumlah_obat_keluar(pm.getJumlah_obat_keluar());
                    obatDto.setTgl_pembayaran(pm.getTgl_pembayaran());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obatDto;
    }

    @Override
    public void hapusObatKeluar(Integer id) {
        try {
            obatKeluarDao.hapusObatKeluar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatsObat(Integer id) {
        try {
            obatKeluarDao.updateStatusObat(id);
        } catch (Exception e) {
        }
    }
    
}
