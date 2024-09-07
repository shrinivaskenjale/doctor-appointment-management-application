package com.example.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.entity.Admin;
import com.example.app.entity.Appointment;
import com.example.app.entity.Doctor;
import com.example.app.entity.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Patient patient) {
		entityManager.persist(patient);
	}

	@Override
	@Transactional
	public void save(Appointment appointment) {
		entityManager.persist(appointment);
	}

	@Override
	@Transactional
	public void save(Doctor doctor) {
		entityManager.persist(doctor);
	}

	@Override
	@Transactional
	public void save(Admin admin) {
		entityManager.persist(admin);
	}

	@Override
	public Appointment findAppointmentById(int id) {
		return entityManager.find(Appointment.class, id);
	}

	@Override
	public Admin findAdminById(int id) {
		return entityManager.find(Admin.class, id);
	}

	@Override
	public Doctor findDoctorById(int id) {
		return entityManager.find(Doctor.class, id);
	}

	@Override
	public Patient findPatientById(int id) {
		return entityManager.find(Patient.class, id);
	}

	@Override
	@Transactional
	public void deleteAdminById(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		entityManager.remove(admin);
	}

	@Override
	@Transactional
	public void deletePatientById(int id) {
		Patient patient = entityManager.find(Patient.class, id);
		entityManager.remove(patient);
	}

	@Override
	@Transactional
	public void deleteDoctorById(int id) {
		Doctor doctor = entityManager.find(Doctor.class, id);
		entityManager.remove(doctor);
	}

	@Override
	@Transactional
	public void deleteAppointmentById(int id) {
		Appointment appointment = entityManager.find(Appointment.class, id);
		entityManager.remove(appointment);
	}

	@Override
	public List<Appointment> findAppointmentsByDoctorId(int id) {
		TypedQuery<Appointment> query = entityManager.createQuery("from Appointment where doctor.id = :doctorId",
				Appointment.class);

		query.setParameter("doctorId", id);

		return query.getResultList();
	}

	@Override
	public List<Appointment> findAppointmentsByPatientId(int id) {
		TypedQuery<Appointment> query = entityManager.createQuery("from Appointment where patient.id = :patientId",
				Appointment.class);

		query.setParameter("patientId", id);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Doctor doctor) {
		entityManager.merge(doctor);
	}

	@Override
	@Transactional
	public void update(Patient patient) {
		entityManager.merge(patient);
	}

	@Override
	@Transactional
	public void update(Admin admin) {
		entityManager.merge(admin);
	}

	@Override
	@Transactional
	public void update(Appointment appointment) {
		entityManager.merge(appointment);
	}

	@Override
	public Patient findPatientByEmail(String email) {
		TypedQuery<Patient> query = entityManager.createQuery("from Patient where email = :email",
				Patient.class);

		query.setParameter("email", email);

		return query.getSingleResult();
	}

	@Override
	public Admin findAdminByEmail(String email) {
		TypedQuery<Admin> query = entityManager.createQuery("from Admin where email = :email",
				Admin.class);

		query.setParameter("email", email);

		return query.getSingleResult();
	}

	@Override
	public List<Doctor> findDoctors() {
		return entityManager.createQuery("from Doctor", Doctor.class).getResultList();
	}

	@Override
	public List<Appointment> findAppointments() {
		return entityManager.createQuery("from Appointment", Appointment.class).getResultList();
	}

	@Override
	public List<Appointment> findAppointmentsByDate(LocalDate date) {
		TypedQuery<Appointment> query = entityManager.createQuery("from Appointment where date = :date",
				Appointment.class);
		query.setParameter("date", date);
		return query.getResultList();
	}

}
