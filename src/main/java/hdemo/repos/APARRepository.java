package hdemo.repos;

import java.util.List;

import hdemo.entities.APARInstrument;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface APARRepository extends JpaRepository<APARInstrument, Long>, QueryDslPredicateExecutor<APARInstrument> {
	APARInstrument findByUrl(String url);
	
	List<APARInstrument> findByPublisherName(String name);
}
