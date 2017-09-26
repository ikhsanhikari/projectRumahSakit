/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import java.util.List;
import rumahsakit.dto.RuanganDto;

/**
 *
 * @author sou
 */
public interface RuanganServices {
    public List<RuanganDto> listRuangan() throws Exception;

    public RuanganDto listRuanganUpdate(Integer id) throws Exception;

    public void saveDataRuangan(RuanganDto ruanganDto);

    public void updateDataRuangan(RuanganDto ruanganDto) throws Exception;

    public void hapusRuangan(Integer id);
}
