/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.ObatKeluarDto;

/**
 *
 * @author sou
 */
public interface ObatKeluarServices {
    
    public List<ObatKeluarDto> listObatKeluar() throws Exception;

    public void saveDataObatKeluar(ObatKeluarDto obatDto) throws Exception;

    public void updateDataObatKeluar(ObatKeluarDto obatDto) throws Exception;

    public ObatKeluarDto getListObatKeluarUpdate(Integer id) throws Exception;

    public void hapusObatKeluar(Integer id);
    
    public void updateStatsObat(Integer id);
}
