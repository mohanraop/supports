package support.service;

import java.util.List;

import support.domain.entity.SupplyHierarchy;



public interface FacilityService {
	List<String> findFacilityCodesStartWith(String query);
	SupplyHierarchy getSupplyHierarchy(String facilityCode);
}
