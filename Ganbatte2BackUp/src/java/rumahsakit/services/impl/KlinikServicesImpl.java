/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rumahsakit.dao.JenisKlinikDao;
import rumahsakit.dao.KlinikDao;
import rumahsakit.dao.PasienDao;
import rumahsakit.dto.KeluhanDto;
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.TindakanDto;
import rumahsakit.model.JenisKlinikModel;
import rumahsakit.model.KeluhanModel;
import rumahsakit.model.KlinikModel;
import rumahsakit.model.PasienModel;
import rumahsakit.model.TindakanModel;
import rumahsakit.services.KlinikServices;

/**
 *
 * @author sou
 */
@Service
@Transactional
public class KlinikServicesImpl implements KlinikServices {

    @Autowired
    KlinikDao klinikDao;

    @Autowired
    PasienDao pasienDao;

    @Autowired
    JenisKlinikDao jenisKlinikDao;

    @Override
    public List<KlinikDto> listKlinik() throws Exception {
        List<KlinikDto> listDto = null;
        List<KlinikModel> listModel = null;
        KlinikDto klinikDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = klinikDao.listKlinik();
            for (KlinikModel klinikModel : listModel) {
                klinikDto = new KlinikDto();
                klinikDto.setId_klinik(klinikModel.getId_klinik());
                klinikDto.setId_pasien(klinikModel.getId_pasien());
                klinikDto.setCatatan_medis_klinik(klinikModel.getCatatan_medis_klinik());
                klinikDto.setJenis_klinik(klinikModel.getJenis_klinik());
                klinikDto.setKeluhan(klinikModel.getKeluhan());
                klinikDto.setTindakan(klinikModel.getTindakan());
                klinikDto.setPenyakit(klinikModel.getPenyakit());
                klinikDto.setBiaya(klinikModel.getBiaya());
                klinikDto.setKeterangan(klinikModel.getKeterangan());
                listDto.add(klinikDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public KlinikDto listKlinikUpdate(Integer id) throws Exception {
        List<KlinikModel> listModel = null;
        KlinikDto klinikDto = null;
        try {
            listModel = klinikDao.listKlinikUpdate(id);
            for (KlinikModel klinikModel : listModel) {
                klinikDto = new KlinikDto();
                klinikDto.setBiaya(klinikModel.getBiaya());
                klinikDto.setId_klinik(klinikModel.getId_klinik());
                klinikDto.setId_pasien(klinikModel.getId_pasien());
                klinikDto.setCatatan_medis_klinik(klinikModel.getCatatan_medis_klinik());
                klinikDto.setJenis_klinik(klinikModel.getJenis_klinik());
                //klinikDto.setKeluhan(klinikModel.getKeluhan());
                klinikDto.setKeterangan(klinikModel.getKeterangan());
                klinikDto.setPenyakit(klinikModel.getPenyakit());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return klinikDto;
    }

    @Override
    public void saveDataKlinik(KlinikDto klinikDto) {
        KlinikModel klinikModel = null;
        try {
            klinikModel = new KlinikModel();
            klinikModel.setId_klinik(1);
            JenisKlinikModel jenisKlinikModel = jenisKlinikDao.getJenisKlinikById(klinikDto.getJenis_klinik());
            klinikModel.setId_pasien(klinikDto.getId_pasien());
            klinikModel.setJenis_klinik(klinikDto.getJenis_klinik());
            klinikModel.setKeluhan(klinikDto.getKeluhan());
            klinikModel.setProses_perawatan(klinikDto.getJenis_perawatan());
            klinikModel.setPenyakit(klinikDto.getPenyakit());
            klinikModel.setCatatan_medis_klinik(klinikDto.getCatatan_medis_klinik());
            klinikModel.setBiaya(jenisKlinikModel.getBiaya());
            klinikModel.setKeterangan("menunggu..");
            klinikDao.saveDataKlinik(klinikModel);
        } catch (Exception ex) {
            Logger.getLogger(KlinikServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDataKlinik(KlinikDto klinikDto) throws Exception {
        KlinikModel klinikModel = null;
        try {
            klinikModel = new KlinikModel();
            klinikModel.setId_klinik(klinikDto.getId_klinik());
            klinikModel.setId_pasien(klinikDto.getId_pasien());
            klinikModel.setJenis_klinik(klinikDto.getJenis_klinik());
            klinikModel.setKeluhan(getKeluhan(klinikModel.getId_klinik()));
            klinikModel.setTindakan(getTindakan(klinikModel.getId_klinik()));
            klinikModel.setBiaya(klinikDto.getBiaya());
            klinikModel.setProses_perawatan(klinikDto.getJenis_perawatan());
            klinikModel.setPenyakit(klinikDto.getPenyakit());
            klinikModel.setKeterangan("sudah diperiksa");
            klinikModel.setCatatan_medis_klinik(klinikDto.getCatatan_medis_klinik());
            klinikDao.updateDataKlinik(klinikModel);
        } catch (Exception ex) {
            Logger.getLogger(KlinikServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hapusKlinik(Integer id) {
        try {
            klinikDao.hapusKlinik(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KlinikDto> listKlinikNative() throws Exception {
        List<Object[]> dataList = klinikDao.listKlinikNative();
        List<KlinikDto> listDto = new ArrayList<>();
        for (Object[] obj : dataList) {
            KlinikDto kd = new KlinikDto();
            kd.setId_klinik(Integer.parseInt(obj[0].toString()));
            kd.setNama_pasien(obj[1].toString());
            kd.setKeluhan(obj[2].toString());
            kd.setTindakan(obj[9].toString());
            kd.setNama_klinik(obj[3].toString());
            kd.setPenyakit(obj[4].toString());
            kd.setCatatan_medis_klinik(obj[5].toString());
            kd.setKeterangan(obj[7].toString());
            kd.setJenis_perawatan(obj[8].toString());
            kd.setBiaya(Double.parseDouble(obj[6].toString()));
            listDto.add(kd);
        }
        return listDto;
    }

    @Override
    public void insertIdPasien(Integer index) {
        try {
            klinikDao.insertIdPasien(index);
        } catch (Exception e) {
        }
    }

    @Override
    public void updateIdKlinik(KlinikDto klinikDto) {
        try {
            klinikDao.updateIdKlinik(klinikDto.getJenis_klinik(), klinikDto.getId_klinik());
        } catch (Exception e) {

        }
    }

    @Override
    public void insertIdPasien(KlinikDto klinikDto) {
        KlinikModel klinikModel = null;
        try {
            klinikModel = new KlinikModel();
            klinikModel.setId_klinik(1);
            JenisKlinikModel jenisKlinikModel = jenisKlinikDao.getJenisKlinikById(klinikDto.getJenis_klinik());
            klinikModel.setId_pasien(klinikDto.getId_pasien());
            klinikModel.setJenis_klinik(klinikDto.getJenis_klinik());
            klinikModel.setKeluhan("-");
            klinikModel.setProses_perawatan("-");
            klinikModel.setPenyakit("-");
            klinikModel.setTindakan("-");
            klinikModel.setKeterangan("menunggu..");
            klinikModel.setCatatan_medis_klinik("-");
            klinikModel.setBiaya(jenisKlinikModel.getBiaya());
            klinikDao.saveDataKlinik(klinikModel);
        } catch (Exception ex) {
            Logger.getLogger(KlinikServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KlinikDto getKlinik(Integer id) throws Exception {
        List<Object[]> dataList = klinikDao.getKlinik(id);
        KlinikDto kd = null;
        for (Object[] obj : dataList) {
            kd = new KlinikDto();
            kd.setId_klinik(Integer.parseInt(obj[0].toString()));
            kd.setNama_pasien(obj[11].toString());
            kd.setKeluhan(obj[2].toString());
            kd.setNama_klinik(obj[16].toString());
            kd.setPenyakit(obj[4].toString());
            kd.setTgl_lahir_pasien(obj[12].toString());
            kd.setJenis_kelamin(obj[13].toString());
            kd.setAlamat(obj[14].toString());
            kd.setAgama(obj[15].toString());
            kd.setCatatan_medis_klinik(obj[5].toString());
            kd.setBiaya(Double.parseDouble(obj[7].toString()));
            kd.setId_pasien(Integer.parseInt(obj[10].toString()));
        }
        return kd;
    }

    @Override
    public List<KlinikDto> listKlinikMenunggu() throws Exception {
        List<KlinikDto> listDto = null;
        List<KlinikModel> listModel = null;
        KlinikDto klinikDto = null;
        try {
            listDto = new ArrayList<>();
            listModel = klinikDao.listKlinikMenunggu();
            for (KlinikModel klinikModel : listModel) {
                klinikDto = new KlinikDto();
                klinikDto.setId_klinik(klinikModel.getId_klinik());
                klinikDto.setId_pasien(klinikModel.getId_pasien());
                klinikDto.setCatatan_medis_klinik(klinikModel.getCatatan_medis_klinik());
                klinikDto.setJenis_klinik(klinikModel.getJenis_klinik());
                klinikDto.setKeluhan(klinikModel.getKeluhan());
                klinikDto.setPenyakit(klinikModel.getPenyakit());
                klinikDto.setBiaya(klinikModel.getBiaya());
                klinikDto.setKeterangan(klinikModel.getKeterangan());
                listDto.add(klinikDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDto;
    }

    @Override
    public Integer jumlahKlinikMenunggu() {
        Integer index=0;
        List<KlinikModel> klinikModels=klinikDao.listKlinikMenunggu();
        for (KlinikModel klinikModel : klinikModels) {
            index++;
        }
        return index;
    }

    @Override
    public List<KlinikDto> listKlinikDokterMenunggu() throws Exception {
        List<Object[]> dataList = klinikDao.listKlinikDokterMenunggu();
        List<KlinikDto> listDto = new ArrayList<>();
        for (Object[] obj : dataList) {
            KlinikDto kd = new KlinikDto();
            kd.setId_klinik(Integer.parseInt(obj[0].toString()));
            kd.setNama_pasien(obj[1].toString());
            kd.setKeluhan(obj[2].toString());
            kd.setNama_klinik(obj[3].toString());
            kd.setPenyakit(obj[4].toString());
            kd.setCatatan_medis_klinik(obj[5].toString());
            kd.setKeterangan(obj[7].toString());
            kd.setJenis_perawatan(obj[8].toString());
            kd.setBiaya(Double.parseDouble(obj[6].toString()));
            listDto.add(kd);
        }
        return listDto;
    }

    @Override
    public List<KlinikDto> listKlinikRawatInap() throws Exception {
        List<Object[]> dataList = klinikDao.listKlinikRawatInap();
        List<KlinikDto> listDto = new ArrayList<>();
        for (Object[] obj : dataList) {
            KlinikDto kd = new KlinikDto();
            kd.setId_klinik(Integer.parseInt(obj[0].toString()));
            kd.setNama_pasien(obj[1].toString());
            kd.setKeluhan(obj[2].toString());
            kd.setNama_klinik(obj[3].toString());
            kd.setPenyakit(obj[4].toString());
            kd.setCatatan_medis_klinik(obj[5].toString());
            kd.setKeterangan(obj[7].toString());
            kd.setJenis_perawatan(obj[8].toString());
            kd.setId_pasien(Integer.parseInt(obj[9].toString()));
            kd.setBiaya(Double.parseDouble(obj[6].toString()));
            listDto.add(kd);
        }
        return listDto;
    }

    @Override
    public Integer jumlahKlinikRawatInap() {
        Integer index=0;
        List<Object[]> klinikModels=klinikDao.listKlinikRawatInap();
        for (Object[] klinikModel : klinikModels) {
            index++;
        }
        return index;
    }

    @Override
    public void updateKeterangan(Integer index) {
        klinikDao.updateKeterangan(index);
    }

    @Override
    public List<KlinikDto> listKlinikDokterSudahDiPeriksa() throws Exception {
        List<Object[]> dataList = klinikDao.listKlinikDokterSudahDiPeriksa();
        List<KlinikDto> listDto = new ArrayList<>();
        for (Object[] obj : dataList) {
            KlinikDto kd = new KlinikDto();
            kd.setId_klinik(Integer.parseInt(obj[0].toString()));
            kd.setNama_pasien(obj[1].toString());
            kd.setKeluhan(obj[2].toString());
            kd.setNama_klinik(obj[3].toString());
            kd.setPenyakit(obj[4].toString());
            kd.setCatatan_medis_klinik(obj[5].toString());
            kd.setKeterangan(obj[7].toString());
            kd.setJenis_perawatan(obj[8].toString());
            kd.setBiaya(Double.parseDouble(obj[6].toString()));
            kd.setTindakan(obj[9].toString());
            listDto.add(kd);
        }
        return listDto;
    }

    @Override
    public String getKeluhan(Integer id) {
        String rs="";
        List<KeluhanModel> listKeluhan=klinikDao.getKeluhan(id);
        for (KeluhanModel lk : listKeluhan) {
            rs+=lk.getNama_keluhan()+",";
        }
        return rs;
    }

    @Override
    public String getTindakan(Integer id) {
         String rs="";
        List<TindakanModel> listTindakan=klinikDao.getTindakan(id);
        for (TindakanModel lt : listTindakan) {
            rs+=lt.getNama_tindakan()+",";
        }
        return rs;
    }

    @Override
    public void saveKeluhan(KeluhanDto keluhanDto) {
        KeluhanModel keluhanModel= new KeluhanModel();
        keluhanModel.setId_keluhan(1);
        keluhanModel.setId_klinik(keluhanDto.getId_klinik());
        keluhanModel.setId_pasien(keluhanDto.getId_pasien());
        keluhanModel.setNama_keluhan(keluhanDto.getNama_keluhan());
        klinikDao.saveKeluhan(keluhanModel);
    }

    @Override
    public void saveTindakan(TindakanDto tindakanDto) {
        TindakanModel tindakanModel= new TindakanModel();
        tindakanModel.setId_tindakan(1);
        tindakanModel.setId_klinik(tindakanDto.getId_klinik());
        tindakanModel.setId_pasien(tindakanDto.getId_pasien());
        tindakanModel.setNama_tindakan(tindakanDto.getNama_tindakan());
        klinikDao.saveTindakan(tindakanModel);
    }

    @Override
    public KlinikDto listKlinikNative(Integer id) throws Exception {
        List<Object[]> dataList = klinikDao.listKlinikNative();
        KlinikDto kd=null;
        for (Object[] obj : dataList) {
            kd = new KlinikDto();
            kd.setId_klinik(Integer.parseInt(obj[0].toString()));
            kd.setNama_pasien(obj[1].toString());
            kd.setKeluhan(obj[2].toString());
            kd.setTindakan(obj[9].toString());
            kd.setNama_klinik(obj[3].toString());
            kd.setPenyakit(obj[4].toString());
            kd.setCatatan_medis_klinik(obj[5].toString());
            kd.setKeterangan(obj[7].toString());
            kd.setJenis_perawatan(obj[8].toString());
            kd.setBiaya(Double.parseDouble(obj[6].toString()));
        }
        return kd;
    }
}
