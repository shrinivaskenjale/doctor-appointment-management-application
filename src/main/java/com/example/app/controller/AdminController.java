package com.example.app.controller;

import java.time.LocalDate;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.dao.AppDAO;
import com.example.app.entity.Admin;
import com.example.app.entity.Appointment;
import com.example.app.entity.Doctor;
import com.example.app.model.AdminUpdateAppointmentBody;
import com.example.app.model.AppointmentListBody;
import com.example.app.model.DoctorRegisterBody;
import com.example.app.model.LoginBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AppDAO appDAO;

    @Autowired
    public AdminController(AppDAO appDAO) {
        super();
        this.appDAO = appDAO;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String loginAdmin(@Valid @ModelAttribute LoginBody body, BindingResult result, Model model,
            HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result);
            return "admin/login";
        }

        Admin admin = null;

        try {
            admin = appDAO.findAdminByEmail(body.getEmail());
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("loginError", "Email or password does not match.");
            return "admin/login";
        }

        HttpSession session = request.getSession();
        if (admin.getPassword().equals(body.getPassword())) {
            // session.setAttribute("isAuthenticated", true);
            session.setAttribute("role", "admin");
            // session.setAttribute("adminId", admin.getId());
            session.setAttribute("user", admin);
        } else {
            model.addAttribute("loginError", "Email or password does not match.");
            return "admin/login";
        }

        return "redirect:/";
    }

    @GetMapping("/register-doctor")
    public String getDoctorRegisterPage() {
        return "admin/register-doctor";
    }

    @PostMapping("/register-doctor")
    public String registerDoctor(@Valid @ModelAttribute DoctorRegisterBody body, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result);
            return "admin/register-doctor";
        }

        Doctor doctor = new Doctor(body.getFullName(), body.getEmail(), body.getMobileNumber(), body.getGender(),
                body.getSpecialization());
        appDAO.save(doctor);
        return "redirect:/";
    }

    @GetMapping("/doctor-list")
    public String getDoctorList(Model model) {
        List<Doctor> doctors = appDAO.findDoctors();
        model.addAttribute("doctors", doctors);
        return "admin/doctor-list";
    }

    @PostMapping("/delete-doctor")
    public String deleteDoctor(@RequestParam("doctorId") int doctorId) {
        appDAO.deleteDoctorById(doctorId);
        return "redirect:/admin/doctor-list";
    }

    @GetMapping("/edit-doctor/{doctorId}")
    public String getEditDoctorPage(@PathVariable int doctorId, Model model) {
        Doctor doctor = appDAO.findDoctorById(doctorId);
        model.addAttribute("doctor", doctor);
        return "admin/edit-doctor";
    }

    @PostMapping("/edit-doctor/{doctorId}")
    public String editDoctor(@PathVariable int doctorId, @Valid @ModelAttribute DoctorRegisterBody body,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            Doctor doctor = appDAO.findDoctorById(doctorId);
            model.addAttribute("doctor", doctor);

            model.addAttribute("errors", result);
            return "admin/edit-doctor";
        }

        Doctor doctor = appDAO.findDoctorById(doctorId);
        doctor.setFullName(body.getFullName());
        doctor.setEmail(body.getEmail());
        doctor.setMobileNumber(body.getMobileNumber());
        doctor.setGender(body.getGender());
        doctor.setSpecialization(body.getSpecialization());

        appDAO.update(doctor);

        return "redirect:/admin/doctor-list";
    }

    @GetMapping("/appointment-list")
    public String getAppointmentListPage(@ModelAttribute AppointmentListBody body, Model model) {
        List<Appointment> appointments = null;
        if (body.getDate() != null) {
            model.addAttribute("date", body.getDate());
            appointments = appDAO.findAppointmentsByDate(body.getDate());
        } else {
            appointments = appDAO.findAppointments();
        }
        model.addAttribute("appointments", appointments);
        return "admin/appointment-list";
    }

    @GetMapping("/edit-appointment/{appointmentId}")
    public String getEditappointmentPage(@PathVariable int appointmentId, Model model) {
        Appointment appointment = appDAO.findAppointmentById(appointmentId);
        model.addAttribute("appointment", appointment);
        return "admin/edit-appointment";
    }

    @PostMapping("/edit-appointment/{appointmentId}")
    public String editAppointment(@PathVariable int appointmentId, @ModelAttribute AdminUpdateAppointmentBody body) {
        Appointment appointment = appDAO.findAppointmentById(appointmentId);
        appointment.setStatus(body.getStatus());
        appointment.setRemarks(body.getRemarks());

        appDAO.update(appointment);

        return "redirect:/admin/appointment-list";
    }

}
