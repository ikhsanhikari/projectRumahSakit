/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rumahsakit.dao.UserDao;
import rumahsakit.dto.UserDto;
import rumahsakit.model.UserModel;
import rumahsakit.services.UserServices;

/**
 *
 * @author hikari
 */
@Service
@Transactional
public class UserServicesImpl implements UserServices{

    @Autowired
    UserDao userDao;
    
    @Override
    public Integer loginUser(String username, String pass) {
        List<UserDto> listDto=new ArrayList<>();
        List<UserModel> listModel=userDao.loginUser(username, pass);
        Integer index=0;
        for (UserModel lm : listModel) {
            index++;
        }
        return index;
    }

    @Override
    public UserDto selectUser(String username, String pass) {
        List<UserDto> listDto=new ArrayList<>();
        List<UserModel> listModel=userDao.loginUser(username, pass);
        Integer index=0;
        UserDto userDto=null;
        for (UserModel lm : listModel) {
            userDto= new UserDto();
            userDto.setId(lm.getId());
            userDto.setNama(lm.getNama());
            userDto.setJenis(lm.getJenis());
            userDto.setPass(lm.getPass());
            userDto.setUsername(lm.getUsername());
        }
        return userDto;
    }
    
}
