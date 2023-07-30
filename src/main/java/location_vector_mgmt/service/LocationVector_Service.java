package location_vector_mgmt.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import location_vector_mgmt.model.dto.LocationVector_DTO;
import location_vector_mgmt.model.master.LocationVector;
import location_vector_mgmt.model.repo.LocationVector_Repo;

@Service("locationVectorServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LocationVector_Service implements I_LocationVector_Service 
{

	@Autowired
	private LocationVector_Repo locationVectorRepo;

	public LocationVector_DTO newLocationVector(LocationVector_DTO lMaster) 
	{
		LocationVector LocationVector = locationVectorRepo.save(this.setLocationVector(lMaster));
		lMaster = getLocationVectorDTO(LocationVector);
		return lMaster;
	}

	@Override
	public ArrayList<LocationVector_DTO> getAllLocationVectors() 
	{
		ArrayList<LocationVector> placeList = (ArrayList<LocationVector>) locationVectorRepo.findAll();
		ArrayList<LocationVector_DTO> lMasters = new ArrayList<LocationVector_DTO>();
		lMasters = placeList != null ? this.getLocationVectorDTOs(placeList) : null;
		return lMasters;
	}

	@Override
	public ArrayList<LocationVector_DTO> getSelectLocationVectorDetails(ArrayList<Long> ids)
	{
		ArrayList<LocationVector> lMasters = locationVectorRepo.getSelectLocationVectorDetails(ids);
		ArrayList<LocationVector_DTO> locationVector_DTOs = new ArrayList<LocationVector_DTO>();
		locationVector_DTOs = lMasters != null ? this.getLocationVectorDTOs(lMasters) : null;
		return locationVector_DTOs;
	}

	@Override
	public void updLocationVector(LocationVector_DTO lMaster) 
	{
		if (locationVectorRepo.existsById(lMaster.getLocationSeqNo())) 
		{
			LocationVector locationVector = this.setLocationVector(lMaster);
			locationVector.setLocationSeqNo(lMaster.getLocationSeqNo());			
			locationVectorRepo.save(locationVector);			
		}
		return;
	}

	@Override
	public void delAllLocationVectors() {
		locationVectorRepo.deleteAll();
	}

	@Override
	public void delSelectLocationVectorDetails(ArrayList<Long> placeSeqNos) 
	{
		if (placeSeqNos != null) 
		{
		locationVectorRepo.delSelectLocationVectorDetails(placeSeqNos);
		}
	}

	
	private ArrayList<LocationVector_DTO> getLocationVectorDTOs(ArrayList<LocationVector> lMasters) {
		LocationVector_DTO lDTO = null;
		ArrayList<LocationVector_DTO> lMasterDTOs = new ArrayList<LocationVector_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLocationVectorDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LocationVector_DTO getLocationVectorDTO(LocationVector lMaster) 
	{		
		LocationVector_DTO lDTO = new LocationVector_DTO();
		lDTO.setLocationSeqNo(lMaster.getLocationSeqNo());
		lDTO.setPlaceVector(lMaster.getPlaceVector());
		lDTO.setMapidSeqNo(lMaster.getMapidSeqNo());		
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());
		lDTO.setLocationId(lMaster.getLocationId());		
		return lDTO;
	}

	private LocationVector setLocationVector(LocationVector_DTO lDTO)
	{
		LocationVector lMaster = new LocationVector();
		lMaster.setPlaceVector(lDTO.getPlaceVector());
		lMaster.setMapidSeqNo(lDTO.getMapidSeqNo());		
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());
		lMaster.setLocationId(lDTO.getLocationId());		
		return lMaster;
	}
}