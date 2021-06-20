package kodlamaio.hrms.core.helpers.email.abstracts;

public interface CodeGeneratorService {
	String generateCode();
	void sendCode(String email);
}
