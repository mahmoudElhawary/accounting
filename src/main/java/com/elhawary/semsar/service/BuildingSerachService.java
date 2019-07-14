package com.elhawary.semsar.service;

import java.util.List;

import com.elhawary.semsar.model.Buildings;

public interface BuildingSerachService {

	List<Buildings> searchByAllAttributes(String department, String main, String sub, String neig, int rooms, int bath,
			int floor, String furniture, String finishing, String pyment, String purpose, double minArea, double maxAre,
			double minPrice, double maxPrice);

	List<Buildings> searchByAllAttributesWithoutRoomsNumber(String department, String main, String sub, String neig,
			String furniture, String finishing, String pyment, String purpose, double minArea, double maxAre,
			double minPrice, double maxPrice);

	List<Buildings> searchByDepartmentAddressPymentPurposeAreaPrice(String department, String main, String sub,
			String neig, String pyment, String purpose, double minArea, double maxAre, double minPrice,
			double maxPrice);

	List<Buildings> searchByRequeredAttributes(String department, String main, String sub, String neig, double minArea,
			double maxAre, double minPrice, double maxPrice);
	
	List<Buildings> searchByPrice(double minPrice,double maxPrice);
	
	List<Buildings> searchByArea(double minArea, double maxAre) ;
}
