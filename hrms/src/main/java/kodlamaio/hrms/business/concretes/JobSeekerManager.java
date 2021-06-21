package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.helpers.email.abstracts.CodeGeneratorService;
import kodlamaio.hrms.core.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private CodeGeneratorService codeGeneratorService;
	private MernisCheckService mernisCheckService;
	private List<String> emails = new ArrayList<>();
	private List<String> identityNumber = new ArrayList<>();

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,CodeGeneratorService codeGeneratorService
			, MernisCheckService mernisCheckService, List<String> emails,
			List<String> identityNumber) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.codeGeneratorService = codeGeneratorService;
		this.mernisCheckService = mernisCheckService;
		this.emails = emails;
		this.identityNumber = identityNumber;
	}

	@Override
	public Result register(JobSeeker jobSeeker, String passwordAgain) {
		codeGeneratorService.sendCode(jobSeeker.getEmail());
		if ( identityNumberIsItUsed(jobSeeker.getIdentityNumber())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)
				&& Objects.equal(passwordAgain, jobSeeker.getPassword())) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kayıt Başarılı.");
		}else {
		return new ErrorResult("Kayıt Başarısız!");}
	}

	@Override
	public List<JobSeeker> getAll() {
		return this.jobSeekerDao.findAll();
	}

	@Override
	public List<String> getAllEmail() {
		for (int i = 0; i < getAll().size(); i++) {
			emails.add(getAll().get(i).getEmail());
		}
		return emails;
	}

	@Override
	public List<String> getAllIdentityNumber() {
		for (int i = 0; i < getAll().size(); i++) {
			identityNumber.add(getAll().get(i).getIdentityNumber());
		}
		return identityNumber;
	}

	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmail().contains(email)) {
			result = false;
		}
		return result;
	}

	public boolean identityNumberIsItUsed(String identityNumber) {
		boolean result = true;
		if (getAllIdentityNumber().contains(identityNumber)) {
			result = false;
		}
		return result;
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		jobSeekerDao.delete(jobSeeker);
		return new SuccessResult(jobSeeker.getIdentityNumber()+"tc kimlik numarasına göre silme işlemi gerçekleşti");
	}

		
	


	

}
