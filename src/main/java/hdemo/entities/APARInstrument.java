package hdemo.entities;

import javax.persistence.*;

@Entity
@Table(name="apar_instruments")
public class APARInstrument {
	@Id @GeneratedValue
    public long id;

	@OneToOne(targetEntity=Publisher.class)
	@JoinColumn(name="PublisherId")
	public Publisher publisher;

	@OneToOne(targetEntity=Publication.class)
	@JoinColumn(name="PublicationId")
	public Publication publication;
	
    public String url;
    
    private APARInstrument() {}
	public APARInstrument(Publisher pub, Publication publ, String url) {
		this.publisher = pub;
		this.publication = publ;
		this.url = url;
	}
}
