package location_vector_mgmt.model.dto;

import java.io.Serializable;

public class LocationVector_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3254399826631545955L;
	private Long locationSeqNo;
	private String locationId;
	private Long mapidSeqNo;
	private String placeVector;
	private Long specificationSeqNo;

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Long getMapidSeqNo() {
		return mapidSeqNo;
	}

	public void setMapidSeqNo(Long mapidSeqNo) {
		this.mapidSeqNo = mapidSeqNo;
	}

	public String getPlaceVector() {
		return placeVector;
	}

	public void setPlaceVector(String placeVector) {
		this.placeVector = placeVector;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public LocationVector_DTO(Long locationSeqNo, String locationId, Long mapidSeqNo, String placeVector,
			Long specificationSeqNo) {
		super();
		this.locationSeqNo = locationSeqNo;
		this.locationId = locationId;
		this.mapidSeqNo = mapidSeqNo;
		this.placeVector = placeVector;
		this.specificationSeqNo = specificationSeqNo;
	}

	public LocationVector_DTO() {
		super();
	}

}