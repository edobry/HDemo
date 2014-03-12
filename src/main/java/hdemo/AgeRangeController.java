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
@RequestMapping("/age")
public class AgeRangeController {
	AgeRangeRepository ageRepo;

	@Autowired
	public AgeRangeController(AgeRangeRepository ageRepo) {
		this.ageRepo = ageRepo;
	}

	// get all
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<AgeRange> getAll() {
		return ageRepo.findAll();
	}

	// get by id
	@ResponseBody
	@RequestMapping("{id}")
	public AgeRange getById(@PathVariable long id) {
		return ageRepo.findOne(id);
	}

	// find by name
	@ResponseBody
	@RequestMapping(params = "name", method = RequestMethod.GET)
	public AgeRange findByName(@RequestParam String name) {
		return ageRepo.findByName(name);
	}

	// create new age range
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public AgeRange createAgeRange(@RequestBody AgeRange range) {
		return ageRepo.save(range);
	}

	// update age range
	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public AgeRange updateAgeRange(@RequestBody AgeRange range) {
		return ageRepo.save(range);
	}

	// delete age range
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteAgeRange(@PathVariable long id) {
		ageRepo.delete(id);
	}
}
