package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "job_seeker_verifications")
@PrimaryKeyJoinColumn(name = "verification_code_id", referencedColumnName = "id")
public class JobSeekerVerification extends VerificationCode {
	@Column(name = "job_seeker_id")
	private int jobSeekerId;

}