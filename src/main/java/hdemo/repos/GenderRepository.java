package hdemo.repos;

import hdemo.entities.Gender;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
	Gender findByName(String name);
}
