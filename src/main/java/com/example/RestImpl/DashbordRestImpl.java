package com.example.RestImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rest.DashbordRest;
import com.example.Service.DashbordService;

@RestController
public class DashbordRestImpl implements DashbordRest{

	@Autowired
	DashbordService dashboardService;
	
	
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		// TODO Auto-generated method stub
		return dashboardService.getCount();
	}

	
}
