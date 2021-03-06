package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Job;

public interface JobService {
	
	DataResult<List<Job>> getAll();
	DataResult<List<Job>> findByName(String name);
	
	Result add(Job job);

}
