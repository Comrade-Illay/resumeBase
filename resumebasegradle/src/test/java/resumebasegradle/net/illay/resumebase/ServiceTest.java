package resumebasegradle.net.illay.resumebase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import resumebasegradle.net.illay.resumebase.dto.ResumeDto;
import resumebasegradle.net.illay.resumebase.model.Resume;
import resumebasegradle.net.illay.resumebase.repository.ResumeRepository;
import resumebasegradle.net.illay.resumebase.service.ResumeService;

class ServiceTest {
	
  private ResumeRepository resumeRepository; 
  private ResumeService resumeService; 
  
  @BeforeEach
  void setupResume() {
	  resumeRepository = mock(ResumeRepository.class);
	  resumeService = mock(ResumeService.class);	  
  }
  
  @Test
  void findByIdTest() {
	  ResumeDto dto = ResumeDto.newBuilder()	  
				.setId(12L)	
				.setName("Ivan")
				.setSurname("Ivanov")
				.setEmail("sfdkfndk")
				.setPhoneNumber("+344343246")
				.setSkills("PHP")
				.setEducation("None")
				.setExpirience("2 years")
				.build();
	 
	when(resumeService.findById(12L)).thenReturn(Optional.of(dto));
	
	assertNotNull(dto);
	assertEquals(dto.getId(), 12L);
	assertEquals(dto.getName(), "Ivan");
	assertEquals(dto.getSurname(), "Ivanov");
	assertEquals(dto.getEmail(), "sfdkfndk");
	assertEquals(dto.getPhoneNumber(),"+344343246");
	assertEquals(dto.getSkills(), "PHP");
	assertEquals(dto.getEducation(), "None");
	assertEquals(dto.getExpirience(), "2 years");
  }
  
  @Test
  void getByIdTest() {
	  ResumeDto dto = ResumeDto.newBuilder()	  
				.setId(12L)	
				.setName("Ivan")
				.setSurname("Ivanov")
				.setEmail("sfdkfndk")
				.setPhoneNumber("+344343246")
				.setSkills("PHP")
				.setEducation("None")
				.setExpirience("2 years")
				.build();
	 
	when(resumeService.getById(12L)).thenReturn(dto);
	
	assertNotNull(dto);
	assertEquals(dto.getId(), 12L);
	assertEquals(dto.getName(), "Ivan");
	assertEquals(dto.getSurname(), "Ivanov");
	assertEquals(dto.getEmail(), "sfdkfndk");
	assertEquals(dto.getPhoneNumber(),"+344343246");
	assertEquals(dto.getSkills(), "PHP");
	assertEquals(dto.getEducation(), "None");
	assertEquals(dto.getExpirience(), "2 years");
  }

  
  @Test
  void saveResumeTest() {
	  
	  Resume resume = new Resume(); 
		resume.setId(12L);
		resume.setName("Ivan");
		resume.setSurname("Ivanov");
		resume.setEmail("sfdkfndk");
		resume.setPhoneNumber("+344343246");
		resume.setSkills("PHP");
	    resume.setEducation("None");
		resume.setExpirience("2 years");
		
	when(resumeRepository.save(ArgumentMatchers.any(Resume.class))).thenReturn(resume);
	  
	Resume created = resumeRepository.save(resume);
	
	assertThat(created.getName()).isSameAs(resume.getName());
	
	verify(resumeRepository).save(resume);
  }
  
  @Test
  void deleteResumeTest() {
	  ResumeDto dto = ResumeDto.newBuilder()	  
				.setId(12L)	
				.setName("Ivan")
				.setSurname("Ivanov")
				.setEmail("sfdkfndk")
				.setPhoneNumber("+344343246")
				.setSkills("PHP")
				.setEducation("None")
				.setExpirience("2 years")
				.build();
			
		when(resumeService.findById(dto.getId()))
		    .thenReturn(Optional.of(dto));
		
		resumeService.delete(dto.getId());
		
		verify(resumeService).delete(dto.getId());
  }

  @Test
  void getAllTest() {
	  
	  List<Resume> resumes = new ArrayList();
	  
	  resumes.add(new Resume());
	  
	  Page<Resume> page = new PageImpl<>(resumes);
	  
	  Pageable pageable = null;
	  
	  given(resumeRepository.findAll(pageable)).willReturn(page);
	
	  Page <Resume> expected = resumeService.getAll(pageable);
	  
	  assertNotNull(page);
	  assertNull(expected);
	  assertEquals(1,page.getSize());  	  
	  verify(resumeService).getAll(pageable);
  }

}
