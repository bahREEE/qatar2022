package com.example.coupe.dao;

import com.example.coupe.entities.MyRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<MyRole, Long>{

	MyRole findByroleName(String rolename);

}
