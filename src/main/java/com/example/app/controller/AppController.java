package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AppController {
	@GetMapping("/")
	public String getHomePage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("==================================");
		// System.out.println(session.getAttribute("isAuthenticated"));
		System.out.println(session.getAttribute("role"));
		// System.out.println(session.getAttribute("adminId"));
		// System.out.println(session.getAttribute("patientId"));

		model.addAttribute("name", "Shrinivas");
		return "home";
	}
}
