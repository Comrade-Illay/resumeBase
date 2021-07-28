package resumebasegradle.net.illay.resumebase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class that represents resume with properties <b>id</b>, <b>name</b>, <b>surname</b>, <b>email</b>, <b>phoneNumber</b>, 
 * <b>skills</b>, <b>education</b>, <b>exprience</b>
 * @author illay
 * @version 1.0
 * Simple JavaBean domain object that represents Resume in database
 */

@Entity 
@Table(name = "resumes")
@Getter
@Setter
@ToString
@ApiModel(value ="Resume")
public class Resume {
	/*
	public Resume(int i, String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		// TODO Auto-generated constructor stub
	}
    */
	/**
	 * Field id
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	/**
	 * Field name
	 */
	
	@Column(name = "name")
	@ApiModelProperty(value ="Name of employee", example ="Ivan")
	private String name; 
	
	/**
	 * Field surname
	 */
	@Column(name = "surname")
	@ApiModelProperty(value ="Surname of employee", example ="Ivanov")
	private String surname; 
	
	/**
	 * Field e_mail
	 */
	@Column(name = "e_mail")
	@ApiModelProperty(value ="E-mail of employee", example ="my_name_mail@gmail.com")
	private String email;

	/**
	 * Field phone_number
	 */
	@Column(name = "phone_number")
	@ApiModelProperty(value ="Phone number of employee", example ="+375 29 555 55 55")
	private String phoneNumber;

	/**
	 * Field skills
	 */
	@Column(name = "skills")
	@ApiModelProperty(value ="Skills of employee", example ="Java, Php, CSS")
	private String skills;

	/**
	 * Field education
	 */
	@Column(name = "education")
	@ApiModelProperty(value ="Education of employee", example ="State University")
	private String education;

	/**
	 * Field expirience
	 */
	@Column(name = "expirience")
	@ApiModelProperty(value ="Expirience of employee", example ="3 years")
	private String expirience;	
	
}