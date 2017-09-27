/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.ObatMasukDto;

/**
 *
 * @author hikari
 */
public interface ObatMasukServices {
    public List<ObatMasukDto> listObatMasuk() throws Exception;

    public void saveDataObatMasuk(ObatMasukDto obatDto) throws Exception;

    public void updateDataObatMasuk(ObatMasukDto obatDto) throws Exception;

    public ObatMasukDto getListObatMasukUpdate(Integer id) throws Exception;

    public void hapusObatMasuk(Integer id);
}
