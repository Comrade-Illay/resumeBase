package resumebasegradle.net.illay.resumebase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import resumebasegradle.net.illay.resumebase.dto.ResumeDto;
import resumebasegradle.net.illay.resumebase.model.Resume;

/**
 * Interface that define methods for interaction with database
 * @author illay
 * @version 1.0
 */

public interface ResumeService {
	
    /**
     * Method return resume by id with optional case
     * @param id
     * @return
     */
	Optional<ResumeDto> findById(Long id); 
	
	/**
	 * Method for saving resume in database
	 * @param resume
	 */
	void save(Resume resume);
	
	/**
	 * Method for deleting resume by id
	 * @param id
	 */
	void delete(Long id); 
	
	/**
	 * Method which returns all resume
	 * @return
	 */
	Page<Resume> getAll(Pageable pageable);
	
	 /**
     * Method return resume by id
     * @param id
     * @return
     */
	ResumeDto getById(Long Id);
	
	/**
	 * Full-text search method
	 * @param keyword
	 * @return
	 */
    List<Resume> search(String keyword);
	
}