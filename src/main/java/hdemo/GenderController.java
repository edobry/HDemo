package hdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/gender")
public class GenderController {
	GenderRepository genderRepo;

	@Autowired
	public GenderController(GenderRepository genderRepo) {
		this.genderRepo = genderRepo;
	}

	// get all
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<Gender> getAll() {
		return genderRepo.findAll();
	}

	// get by id
	@ResponseBody
	@RequestMapping("{id}")
	public Gender getById(@PathVariable long id) {
		return genderRepo.findOne(id);
	}

	// find by name
	@ResponseBody
	@RequestMapping(params = "name", method = RequestMethod.GET)
	public Gender findByName(@RequestParam String name) {
		return genderRepo.findByName(name);
	}

	// create new gender
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Gender createGender(@RequestBody Gender gender) {
		return genderRepo.save(gender);
	}

	// update gender
	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Gender updateGender(@RequestBody Gender range) {
		return genderRepo.save(range);
	}

	// delete gender
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteGender(@PathVariable long id) {
		genderRepo.delete(id);
	}
}
