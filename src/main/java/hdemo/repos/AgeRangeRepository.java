package hdemo.repos;

import hdemo.entities.AgeRange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRangeRepository extends JpaRepository<AgeRange, Long> {
	AgeRange findByName(String name);
}