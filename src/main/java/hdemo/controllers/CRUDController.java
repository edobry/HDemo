package hdemo.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class CRUDController<T, R extends JpaRepository<T, Long>> extends RUDController<T, R> {
	private CRUDController() {}
	public CRUDController(R repo){
		super(repo);
	}
	
	// create new entity
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public T createEntity(@RequestBody T entity) {
		return repo.save(entity);
	}
}