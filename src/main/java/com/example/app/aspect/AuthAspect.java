package com.example.app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
// import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.app.exception.ForbiddenException;
import com.example.app.exception.UnauthorizedException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Aspect
@Component
public class AuthAspect {
    @Before("execution(* com.example.app.controller.AdminController.*(..)) && !execution(* com.example.app.controller.AdminController.getLoginPage(..)) && !execution(* com.example.app.controller.AdminController.loginAdmin(..))")
    public void authenticateAndAuthorizeAdmin() throws UnauthorizedException, ForbiddenException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        HttpSession session = request.getSession();

        // Check if user is authenticated
        if (session.getAttribute("user") == null) {
            throw new UnauthorizedException("User not authenticated");
        }

        // Check if user is authorized
        if (!session.getAttribute("role").equals("admin")) {
            throw new ForbiddenException("User not authorized");
        }
    }

    @Before("execution(* com.example.app.controller.PatientController.*(..)) && !execution(* com.example.app.controller.PatientController.getLoginPage(..)) && !execution(* com.example.app.controller.PatientController.loginPatient(..)) && !execution(* com.example.app.controller.PatientController.registerPatient(..)) && !execution(* com.example.app.controller.PatientController.getRegisterPage(..))")
    public void authenticateAndAuthorizePatients() throws UnauthorizedException, ForbiddenException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        HttpSession session = request.getSession();

        // Check if user is authenticated
        if (session.getAttribute("user") == null) {
            throw new UnauthorizedException("User not authenticated");
        }

        // Check if user is authorized
        if (!session.getAttribute("role").equals("patient")) {
            throw new ForbiddenException("User not authorized");
        }
    }

    // @Before("execution(* com.example.app.controller.*.*(..))")

}
