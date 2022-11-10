package org.example.overview.members.restcontroller;

import exception.DatabaseDuplicateException;
import exception.InputEmptyException;
import exception.InputInvalidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

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
