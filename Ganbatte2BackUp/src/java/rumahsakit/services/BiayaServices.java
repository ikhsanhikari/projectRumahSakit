/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.BiayaDto;

/**
 *
 * @author hikari
 */
public interface BiayaServices {
    
    public List<Object[]> listBiaya();

    public List<BiayaDto> listBiayaUpdate(Integer id);

    public void saveDataBiaya(BiayaDto biayaDto);

    public void updateDataBiaya(BiayaDto biayaDto);

    public void hapusBiaya(Integer id);
    
}
