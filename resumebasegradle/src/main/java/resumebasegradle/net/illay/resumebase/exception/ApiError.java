package resumebasegradle.net.illay.resumebase.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class responsible for creating error message
 * @author illay
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	/**
	 * Field message
	 */
    private String message;
    
    /**
     * Field debug message
     */
    private String debugMessage;
    
    /**
     * List of errors
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;
    
    /**
     * Сonstructor - creating new error message
     * @param message
     * @param debugMessage
     */
    public ApiError(String message, String debugMessage){
        this.message=message;
        this.debugMessage=debugMessage;
    }
}