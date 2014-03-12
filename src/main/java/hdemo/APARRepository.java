package hdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface APARRepository extends JpaRepository<APARInstrument, Long> {
	APARInstrument findByUrl(String url);
}
