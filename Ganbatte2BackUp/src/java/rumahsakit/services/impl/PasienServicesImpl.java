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
import rumahsakit.dao.PasienDao;
import rumahsakit.dao.impl.PasienDaoImpl;
import rumahsakit.dto.PasienDto;
import rumahsakit.model.PasienModel;
import rumahsakit.services.PasienServices;

/**
 *
 * @author sou
 */
@Service
@Transactional
public class PasienServicesImpl implements PasienServices {

    @Autowired
    PasienDao pasienDao;

    @Override
    public List<PasienDto> listPasien() throws Exception {
        List<PasienDto> listDto = null;
        List<PasienModel> listModel = null;
        PasienDto pasienDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = pasienDao.listPasien();
            if (listModel != null) {
                for (PasienModel pm : listModel) {
                    pasienDto = new PasienDto();
                    pasienDto.setId_pasien(pm.getId_pasien());
                    pasienDto.setAgama(pm.getAgama());
                    pasienDto.setAlamat(pm.getAlamat());
                    pasienDto.setJenis_kelamin(pm.getJenis_kelamin());
                    pasienDto.setKeterangan(pm.getKeterangan());
                    pasienDto.setTgl_lahir_pasien(pm.getTgl_lahir_pasien());
                    pasienDto.setNama_pasien(pm.getNama_pasien());
                    listDto.add(pasienDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public void saveDataPasien(PasienDto pasienDto) throws Exception {
        PasienModel pasienModel = null;
        try {
            pasienModel = new PasienModel();
            pasienModel.setId_pasien(1);
            pasienModel.setNama_pasien(pasienDto.getNama_pasien());
            pasienModel.setAlamat(pasienDto.getAlamat());
            pasienModel.setAgama(pasienDto.getAgama());
            pasienModel.setJenis_kelamin(pasienDto.getJenis_kelamin());
            pasienModel.setKeterangan("menunggu..");
            pasienModel.setTgl_lahir_pasien(pasienDto.getTgl_lahir_pasien());
            pasienDao.saveDataPasien(pasienModel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateDataPasien(PasienDto pasienDto) throws Exception {
        PasienModel pasienModel = null;
        try {
            pasienModel = new PasienModel();
            pasienModel.setId_pasien(pasienDto.getId_pasien());
            pasienModel.setNama_pasien(pasienDto.getNama_pasien());
            pasienModel.setAlamat(pasienDto.getAlamat());
            pasienModel.setAgama(pasienDto.getAgama());
            pasienModel.setJenis_kelamin(pasienDto.getJenis_kelamin());
            pasienModel.setKeterangan(pasienDto.getKeterangan());
            pasienModel.setTgl_lahir_pasien(pasienDto.getTgl_lahir_pasien());
            pasienDao.updateDataPasien(pasienModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PasienDto getListPasienUpdate(Integer id) throws Exception {
        List<PasienModel> listModel = null;
        PasienDto pasienDto = null;
        try {
            listModel = pasienDao.listPasienUpdate(id);
            if (listModel != null) {
                for (PasienModel pm : listModel) {
                    pasienDto = new PasienDto();
                    pasienDto.setId_pasien(pm.getId_pasien());
                    pasienDto.setAgama(pm.getAgama());
                    pasienDto.setAlamat(pm.getAlamat());
                    pasienDto.setJenis_kelamin(pm.getJenis_kelamin());
                    pasienDto.setKeterangan(pm.getKeterangan());
                    pasienDto.setTgl_lahir_pasien(pm.getTgl_lahir_pasien());
                    pasienDto.setNama_pasien(pm.getNama_pasien());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pasienDto;
    }

    @Override
    public void hapusPasien(Integer id) {
        try {
            pasienDao.hapusPasien(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String waktuSekarang() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public List<PasienDto> listPasienBerita() {
        List<PasienDto> dataListDto = new ArrayList<>();
        List<Object[]> dataList = pasienDao.listPasienBerita();
        if (dataList != null) {
            for (Object[] object : dataList) {
                PasienDto dto = new PasienDto();
                dto.setNama_pasien(object[0].toString());
                dto.setAlamat(object[1].toString());
                dto.setKeterangan(object[2].toString());
                dto.setKeluhan(object[3].toString());
                dto.setPenyakit(object[4].toString());
                dto.setNama_klinik(object[5].toString());
                dataListDto.add(dto);
            }
        }
        return dataListDto;
    }

    @Override
    public Integer jumlahPasien() {
        List<PasienModel> listModel = null;
        Integer index = 0;
        try {
            listModel = pasienDao.listPasien();
            for (PasienModel listModel1 : listModel) {
                index++;
            }
        } catch (Exception ex) {
            Logger.getLogger(PasienServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return index;
    }

    @Override
    public List<PasienDto> listPasien10() throws Exception {
        List<PasienDto> listDto = null;
        List<PasienModel> listModel = null;
        PasienDto pasienDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = pasienDao.listPasien10();
            if (listModel != null) {
                for (PasienModel pm : listModel) {
                    pasienDto = new PasienDto();
                    pasienDto.setId_pasien(pm.getId_pasien());
                    pasienDto.setAgama(pm.getAgama());
                    pasienDto.setAlamat(pm.getAlamat());
                    pasienDto.setJenis_kelamin(pm.getJenis_kelamin());
                    pasienDto.setKeterangan(pm.getKeterangan());
                    pasienDto.setTgl_lahir_pasien(pm.getTgl_lahir_pasien());
                    pasienDto.setNama_pasien(pm.getNama_pasien());
                    listDto.add(pasienDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public List<PasienDto> listPasienMenunggu() throws Exception {
        List<PasienDto> listDto = null;
        List<PasienModel> listModel = null;
        PasienDto pasienDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = pasienDao.listPasienMenunggu();
            if (listModel != null) {
                for (PasienModel pm : listModel) {
                    pasienDto = new PasienDto();
                    pasienDto.setId_pasien(pm.getId_pasien());
                    pasienDto.setAgama(pm.getAgama());
                    pasienDto.setAlamat(pm.getAlamat());
                    pasienDto.setJenis_kelamin(pm.getJenis_kelamin());
                    pasienDto.setKeterangan(pm.getKeterangan());
                    pasienDto.setTgl_lahir_pasien(pm.getTgl_lahir_pasien());
                    pasienDto.setNama_pasien(pm.getNama_pasien());
                    listDto.add(pasienDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public Integer jumlahPasienMenunggu() {
        List<PasienModel> listModel = null;
        Integer index = 0;
        try {
            listModel = pasienDao.listPasienMenunggu();
            for (PasienModel listModel1 : listModel) {
                index++;
            }
        } catch (Exception ex) {
            Logger.getLogger(PasienServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return index;
    }

    @Override
    public void updateKeteranganPasien(Integer index) {
        try {
            pasienDao.updateKeterangan(index);
        } catch (Exception e) {
        }
    }

}
