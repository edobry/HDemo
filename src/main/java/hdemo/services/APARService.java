package hdemo.services;

import java.util.List;

import hdemo.entities.APARInstrument;
import hdemo.entities.Publication;
import hdemo.entities.Publisher;
import hdemo.entities.QAPARInstrument;
import hdemo.repos.APARRepository;
import hdemo.repos.PublicationRepository;
import hdemo.repos.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APARService {
	@Autowired
	private APARRepository aparRepo;
	@Autowired
	private PublisherRepository pubRepo;
	@Autowired
	private PublicationRepository publRepo;
	
	public APARInstrument createAPAR(String pub, String publ){
		Publisher publisher = pubRepo.save(new Publisher(pub));
		Publication publication = publRepo.save(new Publication(publ, publisher));
		
		return aparRepo.save(new APARInstrument(publisher, publication, publisher.name + "\\" + publication.name));
	}
	
	public Iterable<APARInstrument> test(){
		QAPARInstrument apar = QAPARInstrument.aPARInstrument;
		return aparRepo.findAll(apar.publication.name.contains(" "));
	}
}
