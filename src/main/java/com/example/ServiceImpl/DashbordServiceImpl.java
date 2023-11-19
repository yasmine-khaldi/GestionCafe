package com.example.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.repository.BillRep;
import com.example.repository.CategoryRep;
import com.example.repository.ProductRep;

@Service
public class DashbordServiceImpl implements DashbordService {

	@Autowired
	CategoryRep categoryDAO;

	@Autowired
	ProductRep productDAO;

	@Autowired
	BillRep billDAO;

	
	
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		Map<String, Object> map = new HashMap<>();
		map.put("categort", categoryDAO.count());
		map.put("product", productDAO.count());
		map.put("bill", billDAO.count());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
