package hdemo.repos;

import hdemo.entities.ASARInstrument;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ASARRepository extends JpaRepository<ASARInstrument, Long> {
}
