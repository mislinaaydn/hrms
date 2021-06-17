package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_positions")
public class JobPositionControllers {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionControllers(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>>  getAll(){
		
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public kodlamaio.hrms.core.utilities.results.Result add(@RequestBody JobPosition jobPosition) {
		return  this.jobPositionService.add(jobPosition);
	}
	
}