/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.ObatDto;
import rumahsakit.dto.ObatKeluarDto;

/**
 *
 * @author sou
 */
public interface ObatServices {
 
    public List<ObatDto> listObat() throws Exception;

    public void saveDataObat(ObatDto obatDto) throws Exception;

    public void updateDataObat(ObatDto obatDto) throws Exception;

    public ObatDto getListObatUpdate(Integer id) throws Exception;

    public void hapusObat(Integer id);
    
    public List<ObatKeluarDto> listObatBelumdiAmbil();
    
    public List<ObatKeluarDto> listObatSudahdiAmbil();
    
}
