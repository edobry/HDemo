package hdemo.controllers;

import java.util.List;

import hdemo.entities.APARInstrument;
import hdemo.repos.APARRepository;
import hdemo.services.APARService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/apar")
public class APARController extends RUDController<APARInstrument, APARRepository> {
	@Autowired
	private APARService service;
	
	@Autowired
	public APARController(APARRepository aparRepo) {
		super(aparRepo);
	}
	
	// find by url
	@ResponseBody
	@RequestMapping(params = "url", method = RequestMethod.GET)
	public APARInstrument findByUrl(@RequestParam String url) {
		return repo.findByUrl(url);
	}
	
	// find by publisher name
	@ResponseBody
	@RequestMapping(params = "pub", method = RequestMethod.GET)
	public List<APARInstrument> findByPub(@RequestParam String pub) {
 		return repo.findByPublisherName(pub);
	}
	
	// create new APAR
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public APARInstrument createAPAR(@RequestBody APARInstrument apar){
		return service.createAPAR(apar.publisher.name, apar.publication.name);
	}
	
	//test
	@ResponseBody
	@RequestMapping(value = "test")
	public Iterable<APARInstrument> test(){
		return service.test();
	}
}
