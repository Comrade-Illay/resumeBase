package resumebasegradle.net.illay.resumebase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import resumebasegradle.net.illay.resumebase.model.Resume;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
	
	@Autowired 
	private TestRestTemplate testRestTemplate;
	
	@SuppressWarnings("deprecation")
	@Test
	@Sql("/test.sql")
	public void getResumeByIdTest() {
		ResponseEntity<Resume> response = testRestTemplate.getForEntity("/api/v1/resume/12", Resume.class);
		
		assertEquals(new Long(12), response.getBody().getId());
		assertEquals(new String("Valisii"), response.getBody().getName());
		assertEquals(new String("Vasiliev"), response.getBody().getSurname());
		assertEquals(new String("54321@gmail.com"), response.getBody().getEmail());
		assertEquals(new String("555-55-45"), response.getBody().getPhoneNumber());
		assertEquals(new String("Junit, HTML, CSS"), response.getBody().getSkills());
		assertEquals(new String("Government University"), response.getBody().getEducation());
		assertEquals(new String("4 years"), response.getBody().getExpirience());
		
	}
	
	@Test
	public void saveResumeTest() {

		Resume resume = new Resume();

		resume.setId(15L);
		resume.setName("Ivan");
		resume.setSurname("Ivanov");
		resume.setEmail("sfdkfndk");
		resume.setPhoneNumber("+344343246");
		resume.setSkills("PHP");
		resume.setEducation("None");
		resume.setExpirience("2 years");
		
		HttpEntity<Resume> request = new HttpEntity<>(resume);
		
		ResponseEntity<Resume> response = testRestTemplate.postForEntity("/api/v1/resume/", request, Resume.class);
		
		assertNotNull(response.getBody().getId());
		assertEquals(new String("Ivan"), response.getBody().getName());
		assertEquals(new String("Ivanov"), response.getBody().getSurname());
		assertEquals(new String("sfdkfndk"), response.getBody().getEmail());
		assertEquals(new String("+344343246"), response.getBody().getPhoneNumber());
		assertEquals(new String("PHP"), response.getBody().getSkills());
		assertEquals(new String("None"), response.getBody().getEducation());
		assertEquals(new String("2 years"), response.getBody().getExpirience());
	}

}
