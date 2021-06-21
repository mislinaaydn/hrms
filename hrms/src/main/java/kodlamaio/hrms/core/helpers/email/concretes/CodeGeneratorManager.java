package kodlamaio.hrms.core.helpers.email.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.helpers.email.abstracts.CodeGeneratorService;
@Service
public class CodeGeneratorManager implements CodeGeneratorService{

	@Override
	public String generateCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		return verificationCode;
	}

	@Override
	public void sendCode(String email) {
		generateCode();
		String link = email + " Gönderildi";
		
	}

}
