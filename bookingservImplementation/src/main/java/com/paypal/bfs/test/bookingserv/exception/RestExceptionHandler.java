package com.paypal.bfs.test.bookingserv.exception;


import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.model.ErrorRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity <ErrorRes>BookingException(BookingException exception, WebRequest request)
    {
        ErrorRes errRes=new ErrorRes();
        errRes.setResponseMessage(exception.getErrorMsg());
        errRes.setStatus(exception.getStatus());
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errRes);



    }
}
