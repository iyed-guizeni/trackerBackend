package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // Custom query to find reports by profile ID
    Report findByProfileId(Long profileId);
}
