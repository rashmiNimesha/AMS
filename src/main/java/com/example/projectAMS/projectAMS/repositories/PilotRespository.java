package com.example.projectAMS.projectAMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectAMS.projectAMS.entities.Pilot;

@Repository
public interface PilotRespository extends JpaRepository<Pilot, Long>{
 
}