package hdemo.controllers;

import hdemo.entities.Publication;
import hdemo.entities.Publisher;
import hdemo.repos.PublicationRepository;
import hdemo.repos.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publ")
public class PublicationController extends CRUDController<Publication, PublicationRepository> {
	@Autowired
	public PublicationController(PublicationRepository publRepo) {
		super(publRepo);
	}
}
