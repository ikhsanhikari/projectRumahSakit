/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rumahsakit.dao.UserDao;
import rumahsakit.model.UserModel;

/**
 *
 * @author hikari
 */
@Repository
public class UserDaoImpl extends HibernateUtil implements UserDao{

    @Override
    public List<UserModel> loginUser(String username, String pass) {
        List<UserModel> listUser = null;
        String sql = "select model from UserModel model where username=:uname and pass= :pwd";
        Query q = null;
        q = createQuery(sql).setParameter("uname", username).setParameter("pwd", pass);
        listUser = q.list();
        return listUser;
    }
    
}
