package resumebasegradle.net.illay.resumebase.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import resumebasegradle.net.illay.resumebase.dto.ResumeDto;
import resumebasegradle.net.illay.resumebase.model.Resume;
import resumebasegradle.net.illay.resumebase.repository.ResumeRepository;
import resumebasegradle.net.illay.resumebase.utils.MappingUtils;

/**
 * Class that implements method for interaction with database
 * @author illay
 * @version 1.0 
 */


@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
	
	private final ResumeRepository resumeRepository; 

	private final MappingUtils mappingUtils;

	/**
	 * Method return resume by id
     * @param id
     * @return
	 */	
	public ResumeDto getById(Long id) {
		return mappingUtils.mapToResumeDto(resumeRepository.getById(id));
	}
		
	/**
	 * Method return resume by id with optional case
     * @param id
     * @return
	 */	
	public Optional<ResumeDto> findById(Long id) {		
		List<ResumeDto> resume =  resumeRepository.findById(id)
				                                   .stream().map(mappingUtils::mapToResumeDto)
				                                   .collect(Collectors.toList());
		Optional<ResumeDto> opt = resume.stream().findAny();
		return opt;
	}
	
	/**
	 * Method for saving resume in database
	 * @param resume
	 */
	public void save(Resume resume) {		
		resumeRepository.save(resume);
		
	}
	
	/**
	 * Method for deleting resume by id
	 * @param id
	 */
	public void delete(Long id) {
		resumeRepository.deleteById(id);		
	}
	
	/**
	 * Method which returns all resume
	 * @param pageable
	 * @return
	 */
	
	@Cacheable("resumes")
	public Page<Resume> getAll(Pageable pageable) {	
		List<Resume> resume = resumeRepository.findAll(pageable).stream()
                .collect(Collectors.toList());				                                 
		return new PageImpl<>(resume);
	}
	
	/**
	 * Full-text search method
	 * @param keyword
	 * @return
	 */
	public List<Resume> search(String keyword){
		return resumeRepository.fulltextSearch(keyword)
				               .stream() 
				               .collect(Collectors.toList());
	
	}

}
