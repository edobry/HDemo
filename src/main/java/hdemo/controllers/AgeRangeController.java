package hdemo.controllers;

import hdemo.entities.AgeRange;
import hdemo.repos.AgeRangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/age")
public class AgeRangeController extends CRUDController<AgeRange, AgeRangeRepository> {
	@Autowired
	public AgeRangeController(AgeRangeRepository ageRepo) {
		super(ageRepo);
	}
	
	// find by name
	@ResponseBody
	@RequestMapping(params = "name", method = RequestMethod.GET)
	public AgeRange findByName(@RequestParam String name) {
		return repo.findByName(name);
	}
}
