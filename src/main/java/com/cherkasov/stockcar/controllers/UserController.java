package com.cherkasov.stockcar.controllers;

import com.cherkasov.stockcar.entity.User;
import com.cherkasov.stockcar.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping(value ="/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value = "/{id_user}")
    public ResponseEntity<User> getUserById(@PathVariable int id_user){
        return new ResponseEntity<>(userService.getUserById(id_user), HttpStatus.OK);
    }

    @RequestMapping(value="/add",params = {"id","name","email","URI"},method = RequestMethod.POST)
    public ResponseEntity<Void> addNewUser(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam String URI){
        try {
            userService.addNewUser(id, name, email, URI);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
