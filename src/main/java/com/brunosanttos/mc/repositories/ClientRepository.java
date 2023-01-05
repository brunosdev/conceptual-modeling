package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
