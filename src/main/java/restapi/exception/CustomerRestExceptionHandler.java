package restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomerRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public final  ResponseEntity<CustomerErrorResponse> handlerException(CustomerNotFoundException cnf) {
        CustomerErrorResponse errorDetails = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), cnf.getMessage(),new Date());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomerErrorResponse> handleAllExceptions(Exception ex) {
        CustomerErrorResponse errorDetails = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


       /*
        CustomerErrorResponse response = new CustomerErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(cnf.getMessage());
        response.setTimeStap(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        @ExceptionHandler
        public ResponseEntity<CustomerErrorResponse> handlerException(Exception cnf) {
        CustomerErrorResponse response = new CustomerErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(cnf.getMessage());
        response.setTimeStap(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
       }
      */
}
