package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Hotel;



public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

}
