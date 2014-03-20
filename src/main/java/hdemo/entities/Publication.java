package hdemo.entities;

import javax.persistence.*;

@Entity
@Table(name="publications") 
public class Publication {
	@Id @GeneratedValue
	public long id;
	public String name;

	@OneToOne(targetEntity=Publisher.class)
	@JoinColumn(name="PublisherId")
	public Publisher publisher;
    
	private Publication() {}
	public Publication(String name, Publisher publisher) {
		this.name = name;
		this.publisher = publisher;
	}
}
