package resumebasegradle.net.illay.resumebase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import resumebasegradle.net.illay.resumebase.dto.ResumeDto;

class ResumeDtoTest {

	@Test
	void tryResuemDto() {
		
		ResumeDto.Builder builder = ResumeDto.newBuilder();
		ResumeDto resumeDtoEntity = builder
				                    .setId(10)
				                    .setName("Nikolay")
				                    .setSurname("Nikolaev")
				                    .setEmail("msdnns")
				                    .setPhoneNumber("+156495959")
				                    .setSkills("Great drinker")
				                    .setEducation("University")
				                    .setExpirience("0 years")
				                    .build();
		
		assertNotNull(resumeDtoEntity);
		assertNotNull(resumeDtoEntity.getId());
		assertNotNull(resumeDtoEntity.getName());
		assertNotNull(resumeDtoEntity.getSurname());
		assertNotNull(resumeDtoEntity.getEmail());
		assertNotNull(resumeDtoEntity.getPhoneNumber());
		assertNotNull(resumeDtoEntity.getSkills());
		assertNotNull(resumeDtoEntity.getEducation());
		assertNotNull(resumeDtoEntity.getExpirience());
		
	}
	

}
