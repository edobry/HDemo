package hdemo.repos;

import hdemo.entities.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
