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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rumahsakit.dao.NomorRuanganDao;
import rumahsakit.dao.ObatMasukDao;
import rumahsakit.dao.RawatInapDao;
import rumahsakit.dto.RawatInapDto;
import rumahsakit.model.NomorRuanganModel;
import rumahsakit.model.ObatMasukModel;
import rumahsakit.model.RawatInapModel;
import rumahsakit.services.RawatInapServices;

/**
 *
 * @author hikari
 */
@Transactional
@Service

public class RawatInapServicesImpl implements RawatInapServices {

    @Autowired
    RawatInapDao rawatInapDao;

    @Autowired
    NomorRuanganDao nomorRuanganDao;

    @Override
    public List<RawatInapDto> listRawatInap() throws Exception {
        List<RawatInapDto> listDto = null;
        List<RawatInapModel> listModel = null;
        RawatInapDto rawatInapDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = rawatInapDao.listRawatInap();
            for (RawatInapModel rawatInapModel : listModel) {
                rawatInapDto = new RawatInapDto();
                rawatInapDto.setId_rawat_inap(rawatInapModel.getId_rawat_inap());
                rawatInapDto.setId_pasien(rawatInapModel.getId_pasien());
                rawatInapDto.setId_nomor_ruangan(rawatInapModel.getId_nomor_ruangan());
                rawatInapDto.setTgl_keluar(rawatInapModel.getTgl_keluar());
                rawatInapDto.setTgl_masuk(rawatInapModel.getTgl_masuk());
                rawatInapDto.setCatatan_medis_rawat_inap(rawatInapModel.getCatatan_medis_rawat_inap());
                listDto.add(rawatInapDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public RawatInapDto listRawatInapUpdate(Integer id) throws Exception {
        List<RawatInapModel> listModel = null;
        RawatInapDto rawatInapDto = null;
        try {
            listModel = rawatInapDao.listRawatInapUpdate(id);
            for (RawatInapModel rawatInapModel : listModel) {
                rawatInapDto = new RawatInapDto();
                rawatInapDto.setId_rawat_inap(rawatInapModel.getId_rawat_inap());
                rawatInapDto.setId_pasien(rawatInapModel.getId_pasien());
                rawatInapDto.setId_nomor_ruangan(rawatInapModel.getId_nomor_ruangan());
                rawatInapDto.setTgl_keluar(rawatInapModel.getTgl_keluar());
                rawatInapDto.setTgl_masuk(rawatInapModel.getTgl_masuk());
                rawatInapDto.setCatatan_medis_rawat_inap(rawatInapModel.getCatatan_medis_rawat_inap());
            }
        } catch (Exception e) {

        }
        return rawatInapDto;
    }

    @Override
    public void saveDataRawatInap(RawatInapDto rawatInapDto) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currDate = dateFormat.format(date);
        NomorRuanganModel nomorRuanganModel = nomorRuanganDao.getNomorRuanganById(rawatInapDto.getId_nomor_ruangan());
        RawatInapModel rawatInapModel = new RawatInapModel();
        List<RawatInapModel> rim = new ArrayList<>();
        try {
            rim = rawatInapDao.listRawatInap();
            nomorRuanganModel.setStatus_ruangan("terisi");
            rawatInapModel.setId_rawat_inap(1);
            rawatInapModel.setId_pasien(rawatInapDto.getId_pasien());
            rawatInapModel.setId_nomor_ruangan(rawatInapDto.getId_nomor_ruangan());
            rawatInapModel.setTgl_keluar("0000-00-00");
            rawatInapModel.setTgl_masuk(currDate);
            rawatInapModel.setCatatan_medis_rawat_inap(rawatInapDto.getCatatan_medis_rawat_inap());
            rawatInapDao.saveDataRawatInap(rawatInapModel);
        } catch (Exception ex) {
            Logger.getLogger(RawatInapServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateDataRawatInap(RawatInapDto rawatInapDto) throws Exception {
        RawatInapModel rawatInapModel = new RawatInapModel();
        rawatInapModel.setId_rawat_inap(rawatInapDto.getId_rawat_inap());
        rawatInapModel.setId_pasien(rawatInapDto.getId_pasien());
        rawatInapModel.setId_nomor_ruangan(rawatInapDto.getId_nomor_ruangan());
        rawatInapModel.setTgl_keluar(rawatInapDto.getTgl_keluar());
        rawatInapModel.setTgl_masuk(rawatInapDto.getTgl_masuk());
        rawatInapModel.setCatatan_medis_rawat_inap(rawatInapDto.getCatatan_medis_rawat_inap());
        rawatInapDao.updateDataRawatInap(rawatInapModel);
    }

    @Override
    public void hapusRawatInap(Integer id) {
        try {
            rawatInapDao.hapusRawatInap(id);
        } catch (Exception e) {
        }
    }

    @Override
    public List<RawatInapDto> listRawatInapNative() throws Exception {
        List<RawatInapDto> listDto = new ArrayList<>();
        List<Object[]> listModel = rawatInapDao.listRawatInapNative();
        for (Object[] obj : listModel) {
            RawatInapDto rid = new RawatInapDto();
            rid.setId_rawat_inap(Integer.parseInt(obj[0].toString()));
            rid.setNama_pasien(obj[1].toString());
            rid.setTgl_masuk(obj[2].toString());
            rid.setTgl_keluar(obj[3].toString());
            rid.setNomor_ruangan(obj[4].toString());
            rid.setCatatan_medis_rawat_inap(obj[5].toString());
            listDto.add(rid);
        }
        return listDto;
    }

    @Override
    public void updateNativeRawatInap(Integer index) {
        try {
            RawatInapModel rawatInapModel = rawatInapDao.getRawatInapById(index);
            if (rawatInapModel.getTgl_keluar().equals("0000-00-00")) {
                nomorRuanganDao.updateNomorKosong(index);
                rawatInapDao.updateNativeRawatInap(index);
            }

        } catch (Exception e) {
        }
    }

    @Override
    public Integer cekPaasienRawatInap(Integer index) {
        List<RawatInapModel> listRawat = rawatInapDao.cekPasienRawatInap(index);
        Integer i = 0;
        for (RawatInapModel listRawat1 : listRawat) {
            if(listRawat1.getTgl_keluar().equals("0000-00-00")){
                index++;
            }
        }
        return i;
    }

    @Override
    public List<RawatInapDto> listRuanganPasien() throws Exception {
        List<RawatInapDto> listDto = new ArrayList<>();
        List<Object[]> listModel = rawatInapDao.listRuanganPasien();
        for (Object[] obj : listModel) {
            RawatInapDto rid = new RawatInapDto();
            rid.setId_pasien(Integer.parseInt(obj[0].toString()));
            rid.setNama_pasien(obj[1].toString());
            rid.setNomor_ruangan(obj[2].toString());
            rid.setJenis_ruangan(obj[3].toString());
            listDto.add(rid);
        }
        return listDto;
    }

}
