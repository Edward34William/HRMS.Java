package furkanyazar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	List<Employer> findByEmail(String email);

	Employer getById(int id);

	Employer findByEmailAndPassword(String email, String password);

}
