package hdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publishers") 
public class Publisher {
	@Id @GeneratedValue
	public Long id;
	public String name;
	
	private Publisher() {}
	public Publisher(String name) {
		this.name = name;
	}
}
