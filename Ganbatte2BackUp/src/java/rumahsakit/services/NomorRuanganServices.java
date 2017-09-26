/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.NomorRuanganDto;
import rumahsakit.dto.RuanganDto;

/**
 *
 * @author hikari
 */
public interface NomorRuanganServices {
    
    public List<NomorRuanganDto> listRuangan() throws Exception;
    
    public List<NomorRuanganDto> listRuanganNative() throws Exception;

    public NomorRuanganDto listRuanganUpdate(Integer id) throws Exception;

    public void saveDataRuangan(NomorRuanganDto ruanganDto);

    public void updateDataRuangan(NomorRuanganDto ruanganDto) throws Exception;

    public void hapusNomorRuangan(Integer id);
    
    
}
