package com.example.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Constents.CafeConstents;
import com.example.JWT.JwtFilter;
import com.example.Service.CategoryService;
import com.example.model.Category;
import com.example.repository.CategoryRep;
import com.example.utils.CafeUtils;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRep categoryDAO;

	@Autowired
	JwtFilter jwtFilter;
	
	
	
	@Override
	public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
		try {
			if (jwtFilter.isAdmin()) {
				if (ValidateCategoryMap(requestMap, false)) {
					categoryDAO.save(getCategoryFromMap(requestMap, false));
					return CafeUtils.getResponseEntity("Category Added Successfully.", HttpStatus.OK);
				}
			}
			return CafeUtils.getResponseEntity(CafeConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean ValidateCategoryMap(Map<String, String> requestMap, boolean validateId) {
		if (requestMap.containsKey("name")) {
			if (requestMap.containsKey("id") && validateId) {
				return true;
			} else if (!validateId) {
				return true;
			}
		}
		return false;
	}

	private Category getCategoryFromMap(Map<String, String> requMap, Boolean isAdd) {
		Category category = new Category();
		if (isAdd) {
			category.setId(Integer.parseInt(requMap.get("id")));
		}
		category.setName(requMap.get("name"));
		return category;
	}

	@Override
	public ResponseEntity<List<Category>> getAllCategory(String filterValue) {
		try {
			if (!Strings.isNullOrEmpty(filterValue) && filterValue.equalsIgnoreCase("true")) {
				log.info("Inside If");
				return new ResponseEntity<List<Category>>(categoryDAO.getAllCategory(), HttpStatus.OK);
			}
			return new ResponseEntity<>(categoryDAO.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<Category>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
		try {
			if (jwtFilter.isAdmin()) {
				if (ValidateCategoryMap(requestMap, true)) {

					Optional optional = categoryRep.findById(Integer.parseInt(requestMap.get("id")));
					if (!optional.isEmpty()) {
						categoryRep.save(getCategoryFromMap(requestMap, true));
						return CafeUtils.getResponseEntity("Category Updated Successfully.", HttpStatus.OK);
					} else {
						return CafeUtils.getResponseEntity("Category id does not exist.", HttpStatus.OK);
					}
				}
				return CafeUtils.getResponseEntity(CafeConstents.INVALID_DATA, HttpStatus.BAD_REQUEST);
			} else
				return CafeUtils.getResponseEntity(CafeConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	

}
