package resumebasegradle.net.illay.resumebase.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class that represent base entity in database with propertie <b> id </b>
 * @author illay
 * @version 1.0
 */

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	/**
	 * Field id
	 * Getter and Setter are generated automatically with annotation
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

}
