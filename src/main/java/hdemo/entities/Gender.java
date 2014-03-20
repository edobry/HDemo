package hdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genders") 
public class Gender {
	@Id @GeneratedValue
	public long id;
	public String name;

	protected Gender() {}
	protected Gender(String name) {
		this.name = name;
	}
}
