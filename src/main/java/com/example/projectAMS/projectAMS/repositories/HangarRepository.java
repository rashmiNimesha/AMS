package com.example.projectAMS.projectAMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectAMS.projectAMS.entities.Hangar;

 
@Repository
public interface HangarRepository extends JpaRepository<Hangar, Long>{
 
}