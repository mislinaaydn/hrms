package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result register(JobSeeker jobSeeker, String passwordAgain);
	  List<JobSeeker> getAll();
	  List<String> getAllEmail();
	  List<String> getAllIdentityNumber();
}