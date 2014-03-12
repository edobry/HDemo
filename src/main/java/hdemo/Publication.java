package hdemo;

import javax.persistence.*;

@Entity
@Table(name="publications") 
public class Publication {
	@Id @GeneratedValue
	private long id;
	String name;
	
	@OneToOne(targetEntity=Publisher.class)
	long PublisherId;
    
	protected Publication(long PublisherId, String name) {
		this.PublisherId = PublisherId;
		this.name = name;
	}
}
