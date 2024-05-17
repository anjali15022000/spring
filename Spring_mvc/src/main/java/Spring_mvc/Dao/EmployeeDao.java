package Spring_mvc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import Spring_mvc.Dto.EmployeeDto;

@Component
public class EmployeeDao {

	EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("aki");
	EntityManager entitymanager = entitymanagerfactory.createEntityManager();
	EntityTransaction entitytransaction = entitymanager.getTransaction();

	public void insert(EmployeeDto employeedto) {

		entitytransaction.begin();
		entitymanager.persist(employeedto);
		entitytransaction.commit();

	}

	public EmployeeDto fetchBypk(int pk) {
		EmployeeDto employeedto = entitymanager.find(EmployeeDto.class, pk);
		if (employeedto != null) {
		
			return employeedto;
		} 
		else {
			return null;
				
		}
	}

	public String deletebypk1(int pk) {

		EmployeeDto employeedto = entitymanager.find(EmployeeDto.class, pk);
		if (employeedto != null)

		{
			entitytransaction.begin();
			entitymanager.remove(employeedto);
			entitytransaction.commit();
			return "data deleted sucessfully";

		} else
			return "no data found";

	}

	public List<EmployeeDto> fetchAll() {
		Query q = entitymanager.createQuery("select a from EmployeeDto a");
		List<EmployeeDto> dtos = q.getResultList();
		if (dtos.isEmpty()) {
			return null;
		} else {
			return dtos;
		}
	}

	public String deleteAll() {
		Query query = entitymanager.createQuery("select a from EmployeeDto a");
		List<EmployeeDto> dtos = query.getResultList();

		if (dtos.isEmpty()) {
			return "data not found";
		} else {
			for (EmployeeDto a : dtos)
			{
				entitytransaction.begin();
			entitymanager.remove(a);
			entitytransaction.commit();

		}
		return"data deleted sucessfully";
	}
	}
}


