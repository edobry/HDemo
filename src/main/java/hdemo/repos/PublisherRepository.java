package hdemo.repos;

import hdemo.entities.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
