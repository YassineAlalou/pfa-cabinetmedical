package com.Echallenge.Dev.service;

import com.Echallenge.Dev.classe.Role;
import com.Echallenge.Dev.classe.User;
import com.Echallenge.Dev.dao.RoleRepository;
import com.Echallenge.Dev.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User saveUser(String n, String p, String dateNaiss, String login, String password, String confirmedPassword) {
        User user = userRepository.findByLogin(login);
        if( user != null)
            throw new RuntimeException("User Already Exists");
        // if ( !password.equals(confirmedPassword))
            // throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        User User = new User();
        User.setLogin(login);
        User.setPassword(bCryptPasswordEncoder.encode(password));
        User.setDateNaiss(dateNaiss);
        User.setNom(n);
        User.setPrenom(p);
        userRepository.save(User);
        addRoleToUser(login,"USER");
        return User;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User loadUserByUsername(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void addRoleToUser(String login, String rolename) {
        User user = userRepository.findByLogin(login);
        Role role = roleRepository.findByLibelle(rolename);
        user.getRoles().add(role);

    }

    @Override
    public List<User> getAll(){

        return userRepository.findAll();
    }

    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }

    public User updateUser(User user, long id) {
        User userEx = userRepository.getOne(id);
        userEx.setLogin(user.getLogin());
        if( user.getPassword() != "")
        {
            userEx.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
        }

        userRepository.save(userEx);
        System.out.println(userEx);
        return userEx;
    }

    public User findById(long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public User saveUserR(String nom, String prenom, String dateNaiss, String login, String password, String confirmedPassword, long id) {

        User user1 = userRepository.findByLogin(login);
        if( user1 != null)
            throw new RuntimeException("User Already Exists");
        if ( ! password.equals(confirmedPassword))
            throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        User user = new User();
        user.setLogin(login);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setDateNaiss(dateNaiss);
        user.setNom(nom);
        user.setPrenom(prenom);
        userRepository.save(user);
        addRoleToUser(login,"USER");
        return user;
    }


}
