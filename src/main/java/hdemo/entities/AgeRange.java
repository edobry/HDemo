package hdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="age_ranges")
public class AgeRange {
	@Id @GeneratedValue
	public long id;
	public String name;

	private AgeRange() {}
	protected AgeRange(String name) {
		this.name = name;
	}
}