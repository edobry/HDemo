package hdemo.entities;

import javax.persistence.*;

@Entity
@Table(name="asar_instruments") 
public class ASARInstrument {
	@Id @GeneratedValue
    private long id;

	@OneToOne(targetEntity=Gender.class)
	long GenderId;

	@OneToOne(targetEntity=AgeRange.class)
	long AgeRangeId;
	    
	protected ASARInstrument(long GenderId, long AgeRangeId) {
		this.GenderId = GenderId;
		this.AgeRangeId = AgeRangeId;
	}
}
