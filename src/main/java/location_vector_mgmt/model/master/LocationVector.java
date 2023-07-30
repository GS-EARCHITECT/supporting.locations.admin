package location_vector_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PLACE_LOCATION_VECTORS database table.
 * 
 */
@Entity
@Table(name = "PLACE_LOCATION_VECTORS")
public class LocationVector implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_SEQUENCE")
	@SequenceGenerator(name = "LOCATION_SEQUENCE", sequenceName = "LOCATION_SEQUENCE", allocationSize = 1)
	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "LOCATION_ID")
	private String locationId;

	@Column(name = "MAPID_SEQ_NO")
	private Long mapidSeqNo;

	@Column(name = "PLACE_VECTOR")
	private String placeVector;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public LocationVector() {
	}

	public Long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public String getLocationId() {
		return this.locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Long getMapidSeqNo() {
		return this.mapidSeqNo;
	}

	public void setMapidSeqNo(Long mapidSeqNo) {
		this.mapidSeqNo = mapidSeqNo;
	}

	public String getPlaceVector() {
		return this.placeVector;
	}

	public void setPlaceVector(String placeVector) {
		this.placeVector = placeVector;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (locationSeqNo ^ (locationSeqNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationVector other = (LocationVector) obj;
		if (locationSeqNo != other.locationSeqNo)
			return false;
		return true;
	}

	public LocationVector(Long locationSeqNo, String locationId, java.lang.Long mapidSeqNo, String placeVector,
			java.lang.Long specificationSeqNo) {
		super();
		this.locationSeqNo = locationSeqNo;
		this.locationId = locationId;
		this.mapidSeqNo = mapidSeqNo;
		this.placeVector = placeVector;
		this.specificationSeqNo = specificationSeqNo;
	}

}