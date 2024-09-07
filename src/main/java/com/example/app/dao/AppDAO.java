package com.example.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.app.entity.Admin;
import com.example.app.entity.Appointment;
import com.example.app.entity.Doctor;
import com.example.app.entity.Patient;

public interface AppDAO {
	void save(Patient patient);

	void save(Appointment appointment);

	void save(Doctor doctor);

	void save(Admin admin);

	Appointment findAppointmentById(int id);

	Admin findAdminById(int id);

	Patient findPatientById(int id);

	Doctor findDoctorById(int id);

	void deleteAppointmentById(int id);

	void deleteAdminById(int id);

	void deleteDoctorById(int id);

	void deletePatientById(int id);

	List<Appointment> findAppointmentsByDoctorId(int id);

	List<Appointment> findAppointmentsByPatientId(int id);

	void update(Doctor doctor);

	void update(Appointment appointment);

	void update(Patient patient);

	void update(Admin admin);

	Patient findPatientByEmail(String email);

	Admin findAdminByEmail(String email);

	List<Doctor> findDoctors();

	List<Appointment> findAppointments();

	List<Appointment> findAppointmentsByDate(LocalDate date);
}
