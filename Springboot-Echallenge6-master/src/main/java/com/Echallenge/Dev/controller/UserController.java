package com.Echallenge.Dev.controller;


import com.Echallenge.Dev.classe.User;
import com.Echallenge.Dev.service.UserService;
import com.Echallenge.Dev.service.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    UserServiceImpl userServiceimpl ;

    @PostMapping("/register")
    public User register(@RequestBody UserForm user){
        return userService.saveUser(user.getNom(),user.getPrenom(),user.getDateNaiss(),user.getLogin(),user.getPassword(),user.getRepassword());
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return userServiceimpl.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userServiceimpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long  id){
        userServiceimpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id)
    {
        return userServiceimpl.updateUser(user,id);
    }

    @PostMapping("/registeruser/{id}")
    public User registerUser(@RequestBody UserForm user, @PathVariable long id){
        return userService.saveUserR(user.getNom(),user.getPrenom(),user.getDateNaiss(),user.getLogin(),user.getPassword(),user.getRepassword(),id);
    }

}


@Data
class UserForm{
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String login;
    private String password;
    private String repassword;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
