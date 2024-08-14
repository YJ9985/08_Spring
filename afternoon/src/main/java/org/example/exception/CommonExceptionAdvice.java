package org.example.exception;


import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
    private String context = "/exception";

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handel404(NoHandlerFoundException e) {
        return context + "/404";
    }

    @ExceptionHandler(Exception.class)
    public String handel500(Exception e, Model model) {
        log.error(e.getMessage());
        e.printStackTrace();

        model.addAttribute("message", e.getMessage());
        model.addAttribute("stacktrace", Arrays.asList(e.getStackTrace()));

        return context + "/error-page";
    }
}
