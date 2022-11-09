package org.example.overview.members.restcontroller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.exception.DatabaseDuplicateException;
import org.example.overview.exception.InputEmptyException;
import org.example.overview.exception.InputInvalidException;
import org.example.overview.members.controller.GlobalController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
//            NullPointerException.class,
            InputEmptyException.class,
            InputInvalidException.class,
            DatabaseDuplicateException.class })
    public ModelAndView handleExceptions(HttpServletRequest request, Exception exception) {
        System.out.println(request.getRequestURI() + " raised " + exception);

        ModelAndView modelAndView = new ModelAndView("error/error");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

}
