package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.BookingDetails;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Integer> {

	@Query("SELECT bd FROM BookingDetails bd WHERE bd.user = : userId")
	List<BookingDetails> findbookingsOfUser(
	  @Param("userId") Integer userId);
}
