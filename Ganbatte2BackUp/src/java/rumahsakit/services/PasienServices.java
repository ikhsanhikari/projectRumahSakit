/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.PasienDto;

/**
 *
 * @author sou
 */
public interface PasienServices {
    
    public List<PasienDto> listPasien() throws Exception;
    
    public List<PasienDto> listPasienMenunggu() throws Exception;
    
    public Integer jumlahPasienMenunggu();

    public List<PasienDto> listPasien10() throws Exception;
    
    public void saveDataPasien(PasienDto pasienDto) throws Exception;

    public void updateDataPasien(PasienDto pasienDto) throws Exception;

    public PasienDto getListPasienUpdate(Integer id) throws Exception;

    public void hapusPasien(Integer id);
    
    public String waktuSekarang();
    
    public List<PasienDto> listPasienBerita();
    
    public Integer jumlahPasien();
    
    public void updateKeteranganPasien(Integer index);
}
