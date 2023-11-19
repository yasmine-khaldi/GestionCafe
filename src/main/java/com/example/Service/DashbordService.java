package com.example.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface DashbordService {

	ResponseEntity<Map<String, Object>> getCount();
}
