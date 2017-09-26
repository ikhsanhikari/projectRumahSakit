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
import rumahsakit.dao.ObatDao;
import rumahsakit.dao.ObatKeluarDao;
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatKeluarDto;
import rumahsakit.model.ObatModel;
import rumahsakit.services.ObatServices;

/**
 *
 * @author sou
 */
@Transactional
@Service
public class ObatServicesImpl implements ObatServices{

    @Autowired
    ObatDao obatDao;
    
    @Autowired
    ObatKeluarDao obatKeluarDao;
    
    @Override
    public List<ObatDto> listObat() throws Exception {
        List<ObatDto> listDto= null;
        List<ObatModel> listModel =null;
        ObatDto obatDto=null;
        try {
            listDto= new ArrayList<>();
            listModel = obatDao.listObat();
            if(listModel!=null){
                for (ObatModel pm : listModel) {
                    obatDto= new ObatDto();
                    obatDto.setId_obat(pm.getId_obat());
                    obatDto.setKode_obat(pm.getKode_obat());
                    obatDto.setNama_obat(pm.getNama_obat());
                    obatDto.setHarga_obat(pm.getHarga_obat());
                    obatDto.setStok_obat(pm.getStok_obat());
                    listDto.add(obatDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public void saveDataObat(ObatDto obatDto) throws Exception {
        ObatModel obatModel= new ObatModel();
        obatModel.setId_obat(1);
        obatModel.setKode_obat(obatDto.getKode_obat());
        obatModel.setStok_obat(obatDto.getStok_obat());
        obatModel.setNama_obat(obatDto.getNama_obat());
        obatModel.setHarga_obat(obatDto.getHarga_obat());
        obatDao.saveDataObat(obatModel);
    }

    @Override
    public void updateDataObat(ObatDto obatDto) throws Exception {
        ObatModel obatModel= new ObatModel();
        obatModel.setId_obat(obatDto.getId_obat());
        obatModel.setStok_obat(obatDto.getStok_obat());
        obatModel.setKode_obat(obatDto.getKode_obat());
        obatModel.setNama_obat(obatDto.getNama_obat());
        obatModel.setHarga_obat(obatDto.getHarga_obat());
        obatDao.updateDataObat(obatModel);
    }

    @Override
    public ObatDto getListObatUpdate(Integer id) throws Exception {
        List<ObatModel> listModel =null;
        ObatDto obatDto=null;
        try {
            listModel = obatDao.listObatUpdate(id);
            if(listModel!=null){
                for (ObatModel pm : listModel) {
                    obatDto= new ObatDto();
                    obatDto.setId_obat(pm.getId_obat());
                    obatDto.setKode_obat(pm.getKode_obat());
                    obatDto.setNama_obat(pm.getNama_obat());
                    obatDto.setHarga_obat(pm.getHarga_obat());
                    obatDto.setStok_obat(pm.getStok_obat());
                }
            }
        } catch (Exception e) {
        }
        return obatDto;
    }

    @Override
    public void hapusObat(Integer id) {
        try {
            obatDao.hapusObat(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ObatKeluarDto> listObatBelumdiAmbil() {
        List<Object[]> listObatBelumDiambil=obatDao.listObatBelumDiAmbil();
        List<ObatKeluarDto> listDto=null;
        listDto=new ArrayList<>();
        ObatKeluarDto obatDto= null;
        for (Object[] obj : listObatBelumDiambil) {
            obatDto= new ObatKeluarDto();
            obatDto.setNama_pasien(obj[0].toString());
            obatDto.setJumlah_obat_keluar(Double.parseDouble(obj[1].toString()));
            obatDto.setNama_obat(obj[2].toString());
            obatDto.setHarga_obat_keluar(Double.parseDouble(obj[3].toString()));
            obatDto.setTgl_pembayaran(obj[4].toString());
            obatDto.setId_obat_keluar(Integer.parseInt(obj[5].toString()));
            obatDto.setStatus_obat(obj[6].toString());
            listDto.add(obatDto);
        }
        return listDto;
    }

    @Override
    public List<ObatKeluarDto> listObatSudahdiAmbil() {
        List<Object[]> listObatBelumDiambil=obatDao.listObatSudahDiAmbil();
        List<ObatKeluarDto> listDto=null;
        listDto=new ArrayList<>();
        ObatKeluarDto obatDto=null;
        for (Object[] obj : listObatBelumDiambil) {
            obatDto= new ObatKeluarDto();
            obatDto.setNama_pasien(obj[0].toString());
            obatDto.setJumlah_obat_keluar(Double.parseDouble(obj[1].toString()));
            obatDto.setNama_obat(obj[2].toString());
            obatDto.setHarga_obat_keluar(Double.parseDouble(obj[3].toString()));
            obatDto.setTgl_pembayaran(obj[4].toString());
            obatDto.setId_obat_keluar(Integer.parseInt(obj[5].toString()));
            obatDto.setStatus_obat(obj[6].toString());
            listDto.add(obatDto);
        }
        return listDto;
    }
    
}
