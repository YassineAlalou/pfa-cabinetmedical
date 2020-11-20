package com.Echallenge.Dev.service;

import com.Echallenge.Dev.classe.Role;
import com.Echallenge.Dev.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){

        return roleRepository.findAll();
    }

    public  Role findById(long id){

        return roleRepository.findById((int) id).get();
    }

    public Role saveRole(Role r){
        Role a = new Role();
        // a.setId(r.getId());
        a.setLibelle(r.getLibelle());
        roleRepository.save(a);
        return a;
    }

    public void deleteRole(long id){
        roleRepository.deleteById((int) id);
    }

    public Role updateRole(Role role, int id){
        Role roleEx = roleRepository.getOne(id);
        roleEx.setLibelle(role.getLibelle());
       roleRepository.save(roleEx);
        return roleEx;
    }


}
