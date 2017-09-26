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
import rumahsakit.dao.NomorRuanganDao;
import rumahsakit.dto.NomorRuanganDto;
import rumahsakit.model.NomorRuanganModel;
import rumahsakit.services.NomorRuanganServices;

/**
 *
 * @author hikari
 */
@Transactional
@Service
public class NomorRuanganServicesImpl implements NomorRuanganServices{

    @Autowired
    NomorRuanganDao nomorRuanganDao;
    
    @Override
    public List<NomorRuanganDto> listRuangan() throws Exception {
        List<NomorRuanganDto> listDto = null;
        List<NomorRuanganModel> listModel = null;
        NomorRuanganDto ruanganDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = nomorRuanganDao.listNomorRuangan();
            for (NomorRuanganModel ruanganModel : listModel) {
                ruanganDto = new NomorRuanganDto();
                ruanganDto.setId_nomor_ruangan(ruanganModel.getId_nomor_ruangan());
                ruanganDto.setId_ruangan(ruanganModel.getId_ruangan());
                ruanganDto.setNomor_ruangan(ruanganModel.getNomor_ruangan());
                ruanganDto.setStatus_ruangan(ruanganModel.getStatus_ruangan());
                listDto.add(ruanganDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public NomorRuanganDto listRuanganUpdate(Integer id) throws Exception {
        List<NomorRuanganModel> listModel = null;
        NomorRuanganDto ruanganDto = null;
        try {
            listModel = nomorRuanganDao.listNomorRuanganUpdate(id);
            for (NomorRuanganModel ruanganModel : listModel) {
                ruanganDto = new NomorRuanganDto();
                ruanganDto.setId_nomor_ruangan(ruanganModel.getId_nomor_ruangan());
                ruanganDto.setId_ruangan(ruanganModel.getId_ruangan());
                ruanganDto.setNomor_ruangan(ruanganModel.getNomor_ruangan());
                ruanganDto.setStatus_ruangan(ruanganModel.getStatus_ruangan());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ruanganDto;
    }

    @Override
    public void saveDataRuangan(NomorRuanganDto ruanganDto) {
        NomorRuanganModel nrm= new NomorRuanganModel();
        nrm.setId_nomor_ruangan(1);
        nrm.setId_ruangan(ruanganDto.getId_ruangan());
        nrm.setNomor_ruangan(ruanganDto.getNomor_ruangan());
        nrm.setStatus_ruangan("kosong");
        nomorRuanganDao.saveDataRuangan(nrm);
    }

    @Override
    public void updateDataRuangan(NomorRuanganDto ruanganDto) throws Exception {
        NomorRuanganModel nrm= new NomorRuanganModel();
        nrm.setId_nomor_ruangan(ruanganDto.getId_nomor_ruangan());
        nrm.setId_ruangan(ruanganDto.getId_ruangan());
        nrm.setNomor_ruangan(ruanganDto.getNomor_ruangan());
        nrm.setStatus_ruangan(ruanganDto.getStatus_ruangan());
        nomorRuanganDao.updateNomorRuangan(nrm);
    }

    @Override
    public void hapusNomorRuangan(Integer id) {
        try {
            nomorRuanganDao.hapusNomorRuangan(id);
        } catch (Exception e) {
        }
    }

    @Override
    public List<NomorRuanganDto> listRuanganNative() throws Exception {
        List<Object[]> listModel= nomorRuanganDao.listRuanganNative();
        List<NomorRuanganDto> listDto= new ArrayList<>();
        for (Object[] obj : listModel) {
            NomorRuanganDto nrd= new NomorRuanganDto();
            nrd.setId_nomor_ruangan(Integer.parseInt(obj[0].toString()));
            nrd.setJenis_ruangan(obj[1].toString());
            nrd.setNomor_ruangan(obj[2].toString());
            nrd.setStatus_ruangan(obj[3].toString());
            listDto.add(nrd);
        }
        return listDto;
    }

}
