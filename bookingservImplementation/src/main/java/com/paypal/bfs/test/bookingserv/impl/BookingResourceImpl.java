package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.AllBookings;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.model.Response;
import com.paypal.bfs.test.bookingserv.dao.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.BookingException;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingService bookingService;

    @Override
    public ResponseEntity<Response> create(Booking booking) {
       if( bookingService.validateCreateBookingReq(booking)==true)
       {
           BookingEntity bookingRes=bookingService.createBooking(booking);
           Response res=new Response();
           res.setBookingId(bookingRes.getId());
           res.setStatus("0");
           res.setResponseMessage("Booking Created Successfully");
           return  ResponseEntity.ok(res);
       }else{
           throw new BookingException("1", "Mandatory params missing");
       }

    }

    @Override
    public ResponseEntity<AllBookings> getAllBookings() {
        List<Booking> list=bookingService.getAllBookings();
        AllBookings finalResult= new AllBookings();
        finalResult.setBookingList(list);
        return ResponseEntity.ok(finalResult);
    }

}
