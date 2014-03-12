package hdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ageRanges")
public class AgeRange {
	@Id @GeneratedValue
	public long id;
	public String name;

	protected AgeRange() {}
	protected AgeRange(String name) {
		this.name = name;
	}
}