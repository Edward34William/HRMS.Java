package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Github;
import furkanyazar.hrms.entities.concretes.User;

public interface GithubService {
	
	Result add(Github github, User User);

	DataResult<Github> findByUserId(int userId);

	Result edit(String github, int id);

}
