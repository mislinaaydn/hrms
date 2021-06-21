package kodlamaio.hrms.entities.concretes;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User{


	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="date_of_birth")
	private int dateOfBirth;
} 
