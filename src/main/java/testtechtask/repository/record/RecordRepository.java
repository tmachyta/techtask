package testtechtask.repository.record;

import org.springframework.data.jpa.repository.JpaRepository;
import testtechtask.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
