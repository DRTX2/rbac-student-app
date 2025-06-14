package com.uta.edu.ec.students.infrastructure.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(NoHandlerFoundException ex, Model model) {
        model.addAttribute("statusCode", HttpStatus.NOT_FOUND);
        model.addAttribute("errorMessage", "La página que buscas no existe.");
        return "error/custom-error";
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex, Model model) {
        model.addAttribute("statusCode", HttpStatus.NOT_FOUND);
        model.addAttribute("errorMessage", "La página que buscas no existe.");
        return "error/custom-error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model, HttpServletRequest request) {
        model.addAttribute("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);
        return "error/custom-error";
    }
}


