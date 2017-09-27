/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao;

import java.util.List;
import rumahsakit.model.UserModel;

/**
 *
 * @author hikari
 */
public interface UserDao {
    public List<UserModel> loginUser (String username,String pass);
}
