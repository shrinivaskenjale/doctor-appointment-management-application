package com.example.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView handleUnauthorizedException(UnauthorizedException e) {
        ModelAndView modelAndView = new ModelAndView("unauthorized");
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED);
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(ForbiddenException.class)
    public ModelAndView handleForbiddenException(ForbiddenException e) {
        ModelAndView modelAndView = new ModelAndView("forbidden");
        modelAndView.setStatus(HttpStatus.FORBIDDEN);
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }
}
