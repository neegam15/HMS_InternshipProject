package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.RoomDetails;

public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer> {
	@Transactional
	@Modifying
	@Query("update RoomDetails set isAvailable=true where roomId= :id")
	public void setAvailableToTrue(@Param("id") int roomId);
	@Transactional
	@Modifying
	@Query("update RoomDetails set bookingDetails=null where roomId= :id")
	public void freeTheRoom(@Param("id") int roomId);
	@Transactional
	@Modifying
	@Query("select r from RoomDetails r where roomNo= :rno")
	public RoomDetails getRoomByNumber(@Param("rno") int roomNumber);
}
