package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.ActivationEmployerService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.ActivationEmployerDao;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class ActivationEmployerManager implements ActivationEmployerService {
	
	private ActivationEmployerDao activationEmployerDao;

	@Autowired
	public ActivationEmployerManager(ActivationEmployerDao activationEmployerDao) {
		super();
		this.activationEmployerDao = activationEmployerDao;
	}

	@Override
	public DataResult<List<ActivationEmployer>> getAll() {
		return new SuccessDataResult<List<ActivationEmployer>>(activationEmployerDao.findAll(), "Aktivasyonlar listelendi");
	}

	@Override
	public Result add(ActivationEmployer activationEmployer, User user) {
		activationEmployer.setIsActivated(false);
		activationEmployer.setUser(user);
		activationEmployerDao.save(activationEmployer);
		return new Result(true, "Aktivasyon eklendi");
	}

	@Override
	public DataResult<ActivationEmployer> getByUserId(int id) {
		return new SuccessDataResult<ActivationEmployer>(activationEmployerDao.getByUserId(id));
	}

	@Override
	public DataResult<List<ActivationEmployer>> findByIsActivated(Boolean isActivated) {
		return new SuccessDataResult<List<ActivationEmployer>>(activationEmployerDao.findByIsActivated(isActivated));
	}

	@Override
	public DataResult<ActivationEmployer> findByIsActivatedAndUser_EmailAndUser_Password(Boolean isActivated,
			String email, String password) {
		return new SuccessDataResult<ActivationEmployer>(activationEmployerDao.findByIsActivatedAndUser_EmailAndUser_Password(isActivated, email, password));
	}

}
