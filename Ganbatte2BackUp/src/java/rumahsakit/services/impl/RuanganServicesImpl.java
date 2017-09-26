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
import rumahsakit.dao.RuanganDao;
import rumahsakit.dto.RuanganDto;
import rumahsakit.model.RuanganModel;
import rumahsakit.services.RuanganServices;

/**
 *
 * @author sou
 */
@Transactional
@Service
public class RuanganServicesImpl implements RuanganServices {

    @Autowired
    RuanganDao ruanganDao;

    @Override
    public List<RuanganDto> listRuangan() throws Exception {
        List<RuanganDto> listDto = null;
        List<RuanganModel> listModel = null;
        RuanganDto ruanganDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = ruanganDao.listRuangan();
            for (RuanganModel ruanganModel : listModel) {
                ruanganDto = new RuanganDto();
                ruanganDto.setId_ruangan(ruanganModel.getId_ruangan());
                ruanganDto.setJenis_ruangan(ruanganModel.getJenis_ruangan());
                ruanganDto.setHarga_ruangan(ruanganModel.getHarga_ruangan());
                listDto.add(ruanganDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public RuanganDto listRuanganUpdate(Integer id) throws Exception {
        List<RuanganModel> listModel = null;
        RuanganDto ruanganDto = null;
        try {
            listModel = ruanganDao.listRuanganUpdate(id);
            for (RuanganModel ruanganModel : listModel) {
                ruanganDto = new RuanganDto();
                ruanganDto.setId_ruangan(ruanganModel.getId_ruangan());
                ruanganDto.setJenis_ruangan(ruanganModel.getJenis_ruangan());
                ruanganDto.setHarga_ruangan(ruanganModel.getHarga_ruangan());
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ruanganDto;
    }

    @Override
    public void saveDataRuangan(RuanganDto ruanganDto) {
        RuanganModel ruanganModel = new RuanganModel();
        ruanganModel.setId_ruangan(1);
        ruanganModel.setJenis_ruangan(ruanganDto.getJenis_ruangan());
        ruanganModel.setHarga_ruangan(ruanganDto.getHarga_ruangan());
        ruanganDao.saveDataRuangan(ruanganModel);
    }

    @Override
    public void updateDataRuangan(RuanganDto ruanganDto) throws Exception {
        RuanganModel ruanganModel = new RuanganModel();
        ruanganModel.setId_ruangan(ruanganDto.getId_ruangan());
        ruanganModel.setJenis_ruangan(ruanganDto.getJenis_ruangan());
        ruanganModel.setHarga_ruangan(ruanganDto.getHarga_ruangan());
        ruanganDao.updateDataRuangan(ruanganModel);
    }

    @Override
    public void hapusRuangan(Integer id) {
        try {
            ruanganDao.hapusRuangan(id);
        } catch (Exception e) {
        }
    }

}
