package com.Echallenge.Dev.service;

import com.Echallenge.Dev.classe.Role;
import com.Echallenge.Dev.classe.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    public User saveUser(String nom, String prenom, String dateNaiss, String username, String password, String confirmedPassword);
    public Role save(Role role);
    public User loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);


    List<User> getAll();

    User saveUserR(String nom, String prenom, String dateNaiss, String username, String password, String repassword, long id);
}
