package resumebasegradle.net.illay.resumebase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import resumebasegradle.net.illay.resumebase.model.Resume;

/**
 * Interface that extends JpaRepository
 * @author illay
 * @version 1.0
 */

public interface ResumeRepository extends JpaRepository<Resume, Long>{
	
	Optional<Resume> findById(Long id);
	
	Page<Resume> findAll(Pageable pageable);
	
	/**
	 * Query for full-text search on fields: skills, education
	 * @param keyword
	 * @return
	 */
	@Query(value = "SELECT * FROM resumes "
			+ "WHERE MATCH (skills, education) AGAINST (?1)", 
			nativeQuery = true)
	public List<Resume> fulltextSearch(String keyword);
}
