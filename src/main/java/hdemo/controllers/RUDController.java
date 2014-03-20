package hdemo.controllers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RUDController<T, R extends JpaRepository<T, Long>> {
	protected R repo;

	public RUDController() {}
	public RUDController(R repo) {
		this.repo = repo;
	}

	// get all
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<T> getAll() {
		return repo.findAll();
	}

	// get by id
	@ResponseBody
	@RequestMapping("{id}")
	public T getById(@PathVariable long id) {
		return repo.findOne(id);
	}

	// update entity
	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T updateEntity(@RequestBody T entity) {
		return repo.save(entity);
	}

	// delete entity
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteEntity(@PathVariable long id) {
		repo.delete(id);
	}
}
