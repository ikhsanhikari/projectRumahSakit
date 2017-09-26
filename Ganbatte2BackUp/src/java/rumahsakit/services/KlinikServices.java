/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.KeluhanDto;
import rumahsakit.dto.KlinikDto;
import rumahsakit.dto.TindakanDto;
import rumahsakit.model.KlinikModel;

/**
 *
 * @author sou
 */
public interface KlinikServices {

    public void insertIdPasien(Integer index);

    public Integer jumlahKlinikMenunggu();

    public List<KlinikDto> listKlinik() throws Exception;

    public List<KlinikDto> listKlinikMenunggu() throws Exception;

    public List<KlinikDto> listKlinikNative() throws Exception;

    public KlinikDto listKlinikNative(Integer id) throws Exception;
    
    public KlinikDto getKlinik(Integer id) throws Exception;

    public KlinikDto listKlinikUpdate(Integer id) throws Exception;

    public void saveDataKlinik(KlinikDto jenisKlinikDto);

    public void updateDataKlinik(KlinikDto jenisKlinikDto) throws Exception;

    public void hapusKlinik(Integer id);

    public void updateIdKlinik(KlinikDto klinikDto);

    public void insertIdPasien(KlinikDto jenisKlinikDto);

    public List<KlinikDto> listKlinikDokterMenunggu() throws Exception;

    public List<KlinikDto> listKlinikDokterSudahDiPeriksa() throws Exception;

    public List<KlinikDto> listKlinikRawatInap() throws Exception;

    public Integer jumlahKlinikRawatInap();

    public void updateKeterangan(Integer index);
    
    public String getKeluhan(Integer id);
    
    public String getTindakan(Integer id);
    
    public void saveKeluhan(KeluhanDto keluhanDto);
    
    public void saveTindakan(TindakanDto tindakanDto);
    
}
