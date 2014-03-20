package hdemo.controllers;

import hdemo.entities.Publisher;
import hdemo.repos.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pub")
public class PublisherController extends CRUDController<Publisher, PublisherRepository> {
	@Autowired
	public PublisherController(PublisherRepository pubRepo) {
		super(pubRepo);
	}
}
