package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	@Autowired
	private EmployerDao employerDao;
	
	
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(employer.getCompanyName() +" eklendi");
	}

	

	@Override
	public Result delete(Employer employer) {
		employerDao.delete(employer);
		return new SuccessResult(employer.getCompanyName()+"silindi");
		
	}

}
