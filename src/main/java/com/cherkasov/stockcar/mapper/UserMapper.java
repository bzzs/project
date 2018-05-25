package com.cherkasov.stockcar.mapper;

import com.cherkasov.stockcar.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    String selectAllUsers = "Select * from user";
    String selectUserById = "Select * from user where id = id_user = #{id_user}";

    @Select(selectAllUsers)
    public List<User> selectAllUsers();

    @Select(selectUserById)
    public User selectUserById(int id_user);

    @Insert("Insert into user(id_user,name_user,email_user,URI_user) value (#{id_user},#{name_user},#{email_user},#{URI_user})")
    public void AddUser (@Param("id_user") int id_user, @Param("name_user") String name_user, @Param("email_user") String email_user, @Param("URI_user") String URI_user);

}
