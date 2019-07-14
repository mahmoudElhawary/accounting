package com.elhawary.semsar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.semsar.model.Buildings;

@Repository
public interface BuildingsRepository extends CrudRepository<Buildings, Long> {

	List<Buildings> findAllByUserRole(String role);

	List<Buildings> findAllByUserId(Long id);

	List<Buildings> findAllByBuildingDepartmentBuildingDepartment(String department);

	List<Buildings> findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndRoomsNumberAndBathroomNumberAndFloorNumberAndFurnitureAndFinishingTypeAndPaymentMethodAndPurposeAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
			String department, String main, String sub, String neig, int rooms, int bath, int floor, String furniture,
			String finishing, String pyment, String purpose, double minArea, double maxAre, double minPrice,
			double maxPrice);

	List<Buildings> findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndFurnitureAndFinishingTypeAndPaymentMethodAndPurposeAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
			String department, String main, String sub, String neig, String furniture, String finishing, String pyment,
			String purpose, double minArea, double maxAre, double minPrice, double maxPrice);

	List<Buildings> findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndPaymentMethodAndPurposeAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
			String department, String main, String sub, String neig, String pyment, String purpose, double minArea,
			double maxAre, double minPrice, double maxPrice);

	List<Buildings> findAllByBuildingDepartmentBuildingDepartmentAndBuildingAddressMainGovernorateAndBuildingAddressSubGovernorateAndBuildingAddressNeighborhoodAndAreaGreaterThanEqualAndAreaLessThanEqualAndBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(
			String department, String main, String sub, String neig, double minArea, double maxAre, double minPrice,
			double maxPrice);

	List<Buildings> findAllByBuildingPriceGreaterThanEqualAndBuildingPriceLessThanEqual(double minPrice,double maxPrice);
	
	List<Buildings> findAllByAreaGreaterThanEqualOrAreaLessThanEqual(double minArea, double maxAre) ;

	List<Buildings> findTop18ByOrderByCreatedDateDesc();

	List<Buildings> findTop18ByOrderByBuildingContractCountDesc();

	List<Buildings> findTop18ByOrderByBuildingSearchCountDesc();

	List<Buildings> findTop18ByOrderByBuildingCommentsCommentCountDesc();

	List<Buildings> findTop18ByOrderByBuildingRateDesc();

	List<Buildings> findTop18ByOrderByBuildingViewDesc();
}
