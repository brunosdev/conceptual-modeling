package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
