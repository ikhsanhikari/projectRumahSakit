/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.services;

import rumahsakit.dto.UserDto;



/**
 *
 * @author hikari
 */
public interface UserServices {
    public Integer loginUser(String username,String pass);
    public UserDto selectUser(String username,String pass);
}
