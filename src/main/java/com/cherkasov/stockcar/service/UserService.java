package com.cherkasov.stockcar.service;

import com.cherkasov.stockcar.entity.User;
import com.cherkasov.stockcar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service(value = "userService")

public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers (){
        return userMapper.selectAllUsers();
    };

    public void addNewUser(int id_user,String name_user,String email_user,String URI_user){
        userMapper.AddUser(id_user, name_user, email_user, URI_user);
    }

    public User getUserById(int id_user){
        return userMapper.selectUserById(id_user);
    }
}
