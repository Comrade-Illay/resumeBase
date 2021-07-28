package resumebasegradle.net.illay.resumebase.utils;

import org.springframework.stereotype.Service;

import resumebasegradle.net.illay.resumebase.dto.ResumeDto;
import resumebasegradle.net.illay.resumebase.model.Resume;

/**
 * Class for transferring information from dto to entity and back
 * @author illay
 * @version 1.0
 */
@Service
public class MappingUtils {
 
	/**Method for transferring inforamtion from entity to dto
	 * @param resume
	 * @return
	 */
	public ResumeDto mapToResumeDto(Resume resume) {
	
	   ResumeDto dto = ResumeDto.newBuilder()	  
		.setId(resume.getId())	
		.setName(resume.getName())
		.setSurname(resume.getSurname())
		.setEmail(resume.getEmail())
		.setPhoneNumber(resume.getPhoneNumber())
		.setSkills(resume.getSkills())
		.setEducation(resume.getEducation())
		.setExpirience(resume.getExpirience())
		.build();
	   
		return dto;
	}
	
	/**
	 * Method for transferring information from dto to entity
	 * @param dto
	 * @return
	 */
	public Resume mapToResume(ResumeDto dto) {
		
		Resume resume = new Resume();
		resume.setId(dto.getId());
		resume.setName(dto.getName());
		resume.setSurname(dto.getSurname());
		resume.setEmail(dto.getEmail());
		resume.setPhoneNumber(dto.getPhoneNumber());
		resume.setSkills(dto.getSkills());
	    resume.setEducation(dto.getEducation());
		resume.setExpirience(dto.getExpirience());
		return resume;
	}
	
	
}
