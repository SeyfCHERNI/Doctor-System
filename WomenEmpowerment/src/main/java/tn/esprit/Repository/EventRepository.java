package tn.esprit.Repository;

import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	@Query("from Event e where not(e.end < :from and e.start > :to)")
	public List<Event> findBetween(@Param("from") LocalDateTime start, @Param("to") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime end);
}