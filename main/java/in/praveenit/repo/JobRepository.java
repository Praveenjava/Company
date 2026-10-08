package in.praveenit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.praveenit.entity.JobApplication;

public interface JobRepository extends JpaRepository<JobApplication, Long> {}
