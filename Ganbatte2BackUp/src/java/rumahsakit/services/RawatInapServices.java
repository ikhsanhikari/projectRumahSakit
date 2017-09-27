/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.RawatInapDto;

/**
 *
 * @author hikari
 */
public interface RawatInapServices {
    
    public List<RawatInapDto> listRawatInap() throws Exception;
    
    public List<RawatInapDto> listRawatInapNative() throws Exception;

    public List<RawatInapDto> listRuanganPasien() throws Exception;
    
    public RawatInapDto listRawatInapUpdate(Integer id) throws Exception;

    public void saveDataRawatInap(RawatInapDto rawatInapDto);

    public void updateDataRawatInap(RawatInapDto rawatInapDto) throws Exception;

    public void hapusRawatInap(Integer id);
    
    public void updateNativeRawatInap(Integer index);
    
    public Integer cekPaasienRawatInap(Integer index);
}
