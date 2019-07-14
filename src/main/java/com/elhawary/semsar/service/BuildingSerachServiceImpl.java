package com.elhawary.semsar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.semsar.model.Buildings;
import com.elhawary.semsar.repository.BuildingsRepository;

@Service
public class BuildingSerachServiceImpl implements BuildingSerachService {

	@Autowired
	private BuildingsRepository buildingsRepository;
	
	@Override
	public List<Buildings> searchByAllAttributes(String department, String main, String sub, String neig, int rooms,
			int bath, int floor, String furniture, String finishing, String pyment, String purpose, double minArea,
			double maxAre, double minPrice, double maxPrice) {
		return buildingsRepository
				.findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndRoomsNumberAndBathroomNumberAndFloorNumberAndFurnitureAndFinishingTypeAndPaymentMethodAndPurposeAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
						department, main, sub, neig, rooms, bath, floor, furniture, finishing, pyment, purpose, minArea,
						maxAre, minPrice, maxPrice);
	}

	@Override
	public List<Buildings> searchByAllAttributesWithoutRoomsNumber(String department, String main, String sub,
			String neig, String furniture, String finishing, String pyment, String purpose, double minArea,
			double maxAre, double minPrice, double maxPrice) {
		return buildingsRepository
				.findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndFurnitureAndFinishingTypeAndPaymentMethodAndPurposeAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
						department, main, sub, neig, furniture, finishing, pyment, purpose, minArea, maxAre, minPrice,
						maxPrice);
	}

	@Override
	public List<Buildings> searchByDepartmentAddressPymentPurposeAreaPrice(String department, String main, String sub,
			String neig, String pyment, String purpose, double minArea, double maxAre, double minPrice,
			double maxPrice) {
		return buildingsRepository
				.findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndPaymentMethodAndPurposeAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
						department, main, sub, neig, pyment, purpose, minArea, maxAre, minPrice, maxPrice);
	}

	@Override
	public List<Buildings> searchByRequeredAttributes(String department, String main, String sub, String neig,
			double minArea, double maxArea, double minPrice, double maxPrice) {
		return buildingsRepository
				.findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
						department, main, sub, neig, minArea, maxArea, minPrice, maxPrice);
	}

	@Override
	public List<Buildings> searchByPrice(double minPrice, double maxPrice) {
		return buildingsRepository.findAllByBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(minPrice, maxPrice);
	}

	@Override
	public List<Buildings> searchByArea(double minArea, double maxAre) {
		return buildingsRepository.findAllByAreaGreaterThanEqualOrAreaLessThanEqual(minArea, maxAre);
	}
}
