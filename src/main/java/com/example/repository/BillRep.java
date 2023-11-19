package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.Bill;

public interface BillRep extends JpaRepository<Bill, Integer> {

	List<Bill> getAllBills();

	List<Bill> getBillByUserName(@Param("username") String username);
	
}
