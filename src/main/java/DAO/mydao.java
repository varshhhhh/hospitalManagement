package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import CONTROLER.DoctorSignup;
import DTO.doctor;
import DTO.patient;
import DTO.staff;

public class mydao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(staff staff) {
		entityTransaction.begin();
		entityManager.persist(staff);
		entityTransaction.commit();
	}

	public void SaveDoctor(doctor doc) {
		entityTransaction.begin();
		entityManager.persist(doc);
		entityTransaction.commit();
	}

	public staff fetchByFindMobile(Long mobile) {
		List<staff> list = entityManager.createQuery("select x from staff x where mobile=?1").setParameter(1, mobile).getResultList();
		{
			if (list.isEmpty()) {

				return null;
			} else {
				return list.get(0);
			}
		}
	}

	public staff fetchByFindEmail(String email) {
		List<staff> lst = entityManager.createQuery("select x from staff x where email=?1").setParameter(1, email)
				.getResultList();
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}

	}

	public doctor fetchByDoctorMobile(long mobile) {

		List<doctor> list = entityManager.createQuery("select x from doctor x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public doctor fetchByDoctorEmail(String email) {
		List<doctor> lst = entityManager.createQuery("select x from doctor x where email=?1").setParameter(1, email)
				.getResultList();
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}

	}

	public staff fethByStaffId(int id) {
		return entityManager.find(staff.class , id);

	}

	public doctor fethByDoctorId(int id) {
		return entityManager.find(doctor.class, id);
	}

	public void updateStaff(staff staff) {
		entityTransaction.begin();
		entityManager.merge(staff);
		entityTransaction.commit();
	}

	public void UpadteDoctor(doctor doc) {
		entityTransaction.begin();
		entityManager.merge(doc);
		entityTransaction.commit();
	}

	public List<doctor> fetchAllDoctor() {
		return entityManager.createQuery("select x from doctor x").getResultList();

	}

	public List<staff> fetchAllStaff() {
		return entityManager.createQuery("select x from staff x").getResultList();

	}
	public void fetchPatient(patient patient) {
		entityTransaction.begin();
		entityManager.persist(patient);
		entityTransaction.commit();
	}

}
