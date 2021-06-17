package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;

public interface SystemUserService{
	DataResult< List<SystemUser> >  getAll();
	Result add(SystemUser systemUser);
	
}
