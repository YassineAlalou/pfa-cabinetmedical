package com.Echallenge.Dev.dao;

import com.Echallenge.Dev.classe.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RoleRepository extends JpaRepository<Role,Integer>, Serializable {
    public Role findByLibelle(String Libelle);
}
