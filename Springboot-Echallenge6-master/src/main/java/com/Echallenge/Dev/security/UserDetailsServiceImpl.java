package com.Echallenge.Dev.security;


import com.Echallenge.Dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.Echallenge.Dev.classe.User user = userService.loadUserByUsername(login);
        if( user == null )throw new UsernameNotFoundException("User not found");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( r->{
            authorities.add(new SimpleGrantedAuthority(r.getLibelle()));
        });
        return new User(user.getLogin(),user.getPassword(),authorities);
    }
}
