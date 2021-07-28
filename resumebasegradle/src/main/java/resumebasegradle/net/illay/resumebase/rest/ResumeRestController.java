package resumebasegradle.net.illay.resumebase.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import resumebasegradle.net.illay.resumebase.dto.ResumeDto;
import resumebasegradle.net.illay.resumebase.exception.MyEntityNotFoundException;
import resumebasegradle.net.illay.resumebase.model.Resume;
import resumebasegradle.net.illay.resumebase.service.ResumeService;

/**
 * Controller-class designed to directly process requests from the client and return results
 * @author illay
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/resume/")
@Api(value ="resumeBase")
public class ResumeRestController {

	@Autowired
	private ResumeService resumeService; 


	/**
	 * Method that return resume by id using http-method "get"
	 * @param resumeId
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value ="Get resume by Id")
	public ResumeDto getResume(@PathVariable("id") Long id){
	        			
		return resumeService.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id));
		
	}	
	
	/**
	 * Method that save resume in database using http-method "post"
	 * @param resume
	 * @return
	 */
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value ="Save resume")
	public ResponseEntity<Resume> saveResume(@Valid @RequestBody Resume resume){
		
		HttpHeaders headers = new HttpHeaders();
				
		this.resumeService.save(resume);
		
		return new ResponseEntity<Resume>(resume, headers, HttpStatus.CREATED);
	}
	
	/**
	 * Method that update resume in database using http-method "put"
	 * @param resume
	 * @param builder
	 * @return
	 */
	
	@RequestMapping(value = "", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value ="Update resume")
	public ResponseEntity<Resume> updateResume(@Valid @RequestBody Resume resume, UriComponentsBuilder builder){
		
		HttpHeaders headers = new HttpHeaders();
		
		this.resumeService.save(resume);
		
		return new ResponseEntity<Resume>(resume, headers, HttpStatus.OK);
	}
	
	/**
	 * Method that delete resume by id using http-method "delete"
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value ="Delete resume")
	public ResponseEntity<ResumeDto> deleteResume(@PathVariable("id") Long id){
		
		ResumeDto resume = this.resumeService.getById(id);
		
		if(resume == null) {
			return new ResponseEntity<ResumeDto>(HttpStatus.NOT_FOUND);
		}
		
		this.resumeService.delete(id);
		
		return new ResponseEntity<ResumeDto>(resume, HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Method that return list of all resumes using http-method "get"
	 * @return
	 */

	@RequestMapping(value = "", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Show all resumes")
	public Page<Resume> getAllResumes(@PageableDefault(value = 5, page = 0,  sort = {"id"}, direction = Sort.Direction.DESC)  Pageable pageable){
		
		Page<Resume> resumes = this.resumeService.getAll(pageable);
		
		return MyEntityNotFoundException.requireNotEmpty(resumes);
		
	}
	
	/**
	 * Method that allows full-text search using http-method "get"
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value ="Searching resume by fields: skills, education")
	public List<Resume> search(@PathVariable("keyword") String keyword){
			    
		return MyEntityNotFoundException.requireNotEmpty(resumeService.search(keyword), keyword);
		
	}	
	
}
