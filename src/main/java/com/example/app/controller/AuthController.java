package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@GetMapping("/access-denied")
	public String getAccessDeniedPage() {

		return "access-denied";
	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// session.setAttribute("isAuthenticated", false);
		session.setAttribute("role", null);
		session.setAttribute("user", null);
		// session.setAttribute("adminId", null);
		// session.setAttribute("patientId", null);

		return "redirect:/";
	}
}
