package hdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publishers") 
public class Publisher {
	@Id @GeneratedValue
	private long id;
	String name;

	protected Publisher(String name) {
		this.name = name;
	}
}
