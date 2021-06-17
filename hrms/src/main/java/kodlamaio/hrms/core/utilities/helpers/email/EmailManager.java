package kodlamaio.hrms.core.utilities.helpers.email;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class EmailManager implements EmailService {

	@Override
	public Result send(String to, String title, String message) {
		return new SuccessResult("E-posta başarıyla gönderildi.");
	}

}
