package location_vector_mgmt.service;

import java.util.ArrayList;
import location_vector_mgmt.model.dto.LocationVector_DTO;

public interface I_LocationVector_Service
{
    abstract public LocationVector_DTO newLocationVector(LocationVector_DTO locationVector_DTO);
    abstract public ArrayList<LocationVector_DTO> getAllLocationVectors();    
    abstract public ArrayList<LocationVector_DTO> getSelectLocationVectorDetails(ArrayList<Long> ids);
    abstract public void updLocationVector(LocationVector_DTO LocationVector_DTO);
    abstract public void delAllLocationVectors();    
    abstract public void delSelectLocationVectorDetails(ArrayList<Long> ids);    
}