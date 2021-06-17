package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.utilities.results.Result;

public interface IdentityValidationService {
	Result validate(String tckn, String firstName, String lastName, int yearOfDate);

}
