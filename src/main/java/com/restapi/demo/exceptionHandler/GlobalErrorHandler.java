package com.restapi.demo.exceptionHandler;

import com.restapi.demo.exception.CustomerNotFoundException;
import com.restapi.demo.exception.PostNotValidException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler{

   @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      //  return super.handleMethodArgumentNotValid(ex, headers, status, request);
        List<FieldError> errors = ex.getFieldErrors();

        List<String> err=new ArrayList<>();

        for(FieldError e:errors){
            err.add(e.getDefaultMessage());
           // err.add(errors.get(i).getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(err);

      //return new ResponseEntity(ex.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(CustomerNotFoundException.class)
    public final ResponseEntity<Object> handleCourseNotFoundException(CustomerNotFoundException ex, WebRequest request) throws Exception{
        return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(PostNotValidException.class)
    public final ResponseEntity<Object> handleInstructorNotFoundException(PostNotValidException ex, WebRequest request) throws Exception{
        return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
