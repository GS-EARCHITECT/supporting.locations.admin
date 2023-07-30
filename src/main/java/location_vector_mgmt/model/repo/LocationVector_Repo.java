package location_vector_mgmt.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import location_vector_mgmt.model.master.LocationVector;

@Repository("locationVectorRepo")
public interface LocationVector_Repo extends JpaRepository<LocationVector, Long> 
{
	@Query(value = "SELECT * FROM PLACE_LOCATION_VECTORS a WHERE a.location_seq_no in :ids order by location_seq_no", nativeQuery = true)
	ArrayList<LocationVector> getSelectLocationVectorDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM PLACE_LOCATION_VECTORS a WHERE upper(trim(a.location_id)) in :ids order by location_seq_no", nativeQuery = true)
	ArrayList<LocationVector> getSelectLocationsByIds(@Param("ids") ArrayList<String> ids);

	@Query(value = "SELECT coalesce(a.PLACE_VECTOR,' ') FROM PLACE_LOCATION_VECTORS a WHERE a.location_seq_no in :ids  order by location_seq_no", nativeQuery = true)
	ArrayList<String> getSelectLocationVectors(@Param("ids") ArrayList<String> ids);
	
	@Modifying
	@Query(value = "DELETE FROM PLACE_LOCATION_VECTORS a WHERE a.location_seq_no in :ids", nativeQuery = true)
	void delSelectLocationVectorDetails(@Param("ids") ArrayList<Long> ids);

	@Modifying
	@Query(value = "DELETE FROM PLACE_LOCATION_VECTORS a WHERE upper(trim(a.location_id)) in :ids order by location_seq_no", nativeQuery = true)
	void delSelectLocationsByIds(@Param("ids") ArrayList<String> ids);

	@Modifying
	@Query(value = "DELETE FROM PLACE_LOCATION_VECTORS a WHERE a.location_seq_no in :ids  order by location_seq_no", nativeQuery = true)
	void delSelectLocationVectors(@Param("ids") ArrayList<String> ids);
}