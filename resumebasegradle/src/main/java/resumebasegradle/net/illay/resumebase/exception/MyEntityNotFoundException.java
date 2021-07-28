package resumebasegradle.net.illay.resumebase.exception;

import java.util.List;

import org.springframework.data.domain.Page;

import resumebasegradle.net.illay.resumebase.model.Resume;


/**
 * Class for handle "not found exception"
 * @author illay
 * @version 1.0
 */
public class MyEntityNotFoundException extends RuntimeException {

	/**
	 * Constructor for creating exception message for getById(Long id) method
	 * @param id
	 */
    public MyEntityNotFoundException(Long id) {
        super("Entity is not found, id=" + id);
    }
    
    /**
	 * Constructor for creating exception message for search(String keyword) method
	 * @param keyword
	 */
    public MyEntityNotFoundException(String keyword) {
        super("No resumes that contains: " + keyword);
    }
    
    /**
	 * Constructor for creating exception message for getAll() method
	 */
    public MyEntityNotFoundException() {
        super("Entitys is not found");
    }
    
    /**
     * Method is required for checking collection in search(String keyword) method
     * @param resume
     * @param keyword
     * @return
     * @throws MyEntityNotFoundException
     */
    public static List<Resume> requireNotEmpty(List<Resume> resume,String keyword) throws MyEntityNotFoundException{
    	if (resume.isEmpty()) {
    		throw new MyEntityNotFoundException(keyword);
    	}
    	return resume;
    }
    
    /**
     * Method is required for checking collection in getAll() method
     * @param resume
     * @return
     * @throws MyEntityNotFoundException
     */
    public static Page<Resume> requireNotEmpty(Page<Resume> resume) throws MyEntityNotFoundException{
    	if (resume.isEmpty()) {
    		throw new MyEntityNotFoundException();
    	}
    	return resume;
    }    
    
}