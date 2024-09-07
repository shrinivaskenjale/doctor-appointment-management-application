package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.dao.AppDAO;
import com.example.app.entity.Appointment;
import com.example.app.entity.Doctor;
import com.example.app.entity.Patient;
import com.example.app.exception.ForbiddenException;
import com.example.app.model.BookAppointmentBody;
import com.example.app.model.LoginBody;
import com.example.app.model.PatientProfileEditBody;
import com.example.app.model.PatientRegisterBody;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/patient")
public class PatientController {

	private AppDAO appDAO;

	@Autowired
	public PatientController(AppDAO appDAO) {
		super();
		this.appDAO = appDAO;
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "patient/register";
	}

	@PostMapping("/register")
	public String registerPatient(@Valid @ModelAttribute PatientRegisterBody body, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			return "patient/register";
		}

		Patient patient = new Patient(body.getFullName(), body.getEmail(), body.getPassword(), body.getMobileNumber(),
				body.getGender(), body.getDob(), body.getAddress());
		appDAO.save(patient);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "patient/login";
	}

	@PostMapping("/login")
	public String loginPatient(@Valid @ModelAttribute LoginBody body, BindingResult result, HttpServletRequest request,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			return "patient/login";
		}

		Patient patient = null;

		try {

			patient = appDAO.findPatientByEmail(body.getEmail());
		} catch (EmptyResultDataAccessException e) {
			model.addAttribute("loginError", "Email or password does not match.");
			return "patient/login";
		}
		HttpSession session = request.getSession();
		if (patient.getPassword().equals(body.getPassword())) {
			// session.setAttribute("isAuthenticated", true);
			session.setAttribute("role", "patient");
			// session.setAttribute("patientId", patient.getId());
			session.setAttribute("user", patient);

		} else {
			model.addAttribute("loginError", "Email or password does not match.");
			return "patient/login";
		}

		return "redirect:/";
	}

	@GetMapping("/book-appointment")
	public String getAppointmentBookingPage(Model model) {
		List<Doctor> doctors = appDAO.findDoctors();
		model.addAttribute("doctors", doctors);
		return "patient/book-appointment";
	}

	@PostMapping("/book-appointment")
	public String bookAppointment(@Valid @ModelAttribute BookAppointmentBody body, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			List<Doctor> doctors = appDAO.findDoctors();
			model.addAttribute("doctors", doctors);

			model.addAttribute("errors", result);
			return "patient/book-appointment";
		}

		HttpSession session = request.getSession();
		Patient sessionPatient = (Patient) session.getAttribute("user");
		int patientId = sessionPatient.getId();

		Appointment appointment = new Appointment();
		Doctor doctor = appDAO.findDoctorById(body.getDoctorId());
		Patient patient = appDAO.findPatientById(patientId);

		// Get doctor and patient from db and set them on appointment
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		appointment.setDescription(body.getDescription());
		appointment.setStatus("Pending");
		appointment.setDate(body.getDate());

		appDAO.save(appointment);
		return "redirect:/";
	}

	@GetMapping("/my-appointments")
	public String getMyAppointmentsPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Patient patient = (Patient) session.getAttribute("user");
		List<Appointment> appointments = appDAO.findAppointmentsByPatientId(patient.getId());
		model.addAttribute("appointments", appointments);
		return "patient/my-appointment-list";
	}

	@PostMapping("/cancel-appointment/{appointmentId}")
	public String cancelAppointment(@PathVariable int appointmentId, HttpServletRequest request)
			throws ForbiddenException {
		HttpSession session = request.getSession();
		Patient patient = (Patient) session.getAttribute("user");

		Appointment appointment = appDAO.findAppointmentById(appointmentId);

		if (appointment.getPatient().getId() != patient.getId()) {
			throw new ForbiddenException("User not authorized");
		}

		appointment.setStatus("Cancelled");

		appDAO.update(appointment);

		return "redirect:/patient/my-appointments";
	}

	@GetMapping("/edit-profile")
	public String getUpdateProfilePage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient patient = (Patient) session.getAttribute("user");
		model.addAttribute("patient", patient);

		return "patient/edit-profile";
	}

	@PostMapping("/edit-profile")
	public String editProfile(@Valid @ModelAttribute PatientProfileEditBody body, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			HttpSession session = request.getSession();
			Patient patient = (Patient) session.getAttribute("user");
			model.addAttribute("patient", patient);
			model.addAttribute("errors", result);
			return "patient/edit-profile";
		}

		Patient patient = appDAO.findPatientById(body.getId());

		patient.setFullName(body.getFullName());
		patient.setEmail(body.getEmail());
		patient.setMobileNumber(body.getMobileNumber());
		patient.setAddress(body.getAddress());

		appDAO.update(patient);
		HttpSession session = request.getSession();
		session.setAttribute("user", patient);

		return "redirect:/";
	}
}
