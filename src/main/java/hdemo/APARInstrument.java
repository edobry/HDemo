package hdemo;

import javax.persistence.*;

@Entity
@Table(name="apar_instruments") 
public class APARInstrument {
	@Id @GeneratedValue
    private long id;

	@OneToOne(targetEntity=Publisher.class)
	private long PublisherId;

	@OneToOne(targetEntity=Publication.class)
	private long PublicationId;
	
    private String url;
    
	protected APARInstrument(long PublisherId, long PublicationId, String url) {
		this.PublisherId = PublisherId;
		this.PublicationId = PublicationId;
		this.url = url;
	}
}
