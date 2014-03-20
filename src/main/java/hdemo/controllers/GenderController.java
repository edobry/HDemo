package hdemo.controllers;


import hdemo.entities.Gender;
import hdemo.repos.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/gender")
public class GenderController extends CRUDController<Gender, GenderRepository>{
	@Autowired
	public GenderController(GenderRepository genderRepo) {
		super(genderRepo);
	}
	
	// find by name
	@ResponseBody
	@RequestMapping(params = "name", method = RequestMethod.GET)
	public Gender findByName(@RequestParam String name) {
		return repo.findByName(name);
	}
}
