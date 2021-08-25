package idv.maxy.maxec.core.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Max Chen
 *
 */
@MappedSuperclass
public class BaseModel {
	private String _id;
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name="ID", length=36, nullable=false, updatable=false)
	public String getId() {
		return _id;
	}
	public void setId(String _id) {
		this._id = _id;
	}

}
