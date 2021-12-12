package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.BookingException;
import com.paypal.bfs.test.bookingserv.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookingService {

  @Autowired
  BookingRepository bookingRepository;

  public boolean validateCreateBookingReq(Booking booking)
  {
    if(booking.getId()==null|| booking.getFirstName()==null || booking.getFirstName().isEmpty() || booking.getLastName()==null || booking.getLastName().isEmpty()
    || booking.getDob()==null|| booking.getCheckinDatetime()==null||booking.getCheckoutDatetime()==null || booking.getDeposit()==null||booking.getTotalprice()==null||
            booking.getAddress()==null|| booking.getAddress().getLine1()==null||booking.getAddress().getLine1().isEmpty()
            ||booking.getAddress().getCity()==null||booking.getAddress().getCity().isEmpty()
            ||booking.getAddress().getState()==null||booking.getAddress().getState().isEmpty()
   || booking.getAddress().getZip()==null||booking.getAddress().getZip().isEmpty()
    )
    {
      return false;
    }
    return true;
  }
  public BookingEntity createBooking(Booking booking)
  {
    boolean existingHash=false;
    int hash =Objects.hash(booking.getId(),booking.getFirstName(),booking.getLastName(),
          booking.getDob(),booking.getCheckinDatetime(),booking.getCheckoutDatetime(),booking.getTotalprice(),booking.getDeposit(),booking.getAddress().getLine1(),
          booking.getAddress().getLine2(),booking.getAddress().getCity(),booking.getAddress().getState(),booking.getAddress().getZip());

    try {
      existingHash= bookingRepository.getByHashId(hash)==hash;
    }catch (Exception e)
    {

    }

    if(existingHash==true)
    {
      throw new BookingException("1", "Booking Already exist");
    }
    BookingEntity bookingEntity=new BookingEntity();
    bookingEntity.setId(booking.getId());
    bookingEntity.setFirst_name(booking.getFirstName());
    bookingEntity.setLast_name(booking.getLastName());
    bookingEntity.setDob(booking.getDob());
    bookingEntity.setCheckinDatetime(booking.getCheckinDatetime());
    bookingEntity.setCheckoutDatetime(booking.getCheckoutDatetime());
    bookingEntity.setTotalprice(booking.getTotalprice());
    bookingEntity.setDeposit(booking.getDeposit());
    bookingEntity.setAddrLine1(booking.getAddress().getLine1());
    bookingEntity.setAddrLine2(booking.getAddress().getLine2());
    bookingEntity.setState(booking.getAddress().getState());
    bookingEntity.setCity(booking.getAddress().getCity());
    bookingEntity.setZip(booking.getAddress().getZip());
    bookingEntity.setHash(hash);

    return bookingRepository.save(bookingEntity);


  }

  public List<Booking> getAllBookings()
  {
    List<BookingEntity> resultList=bookingRepository.findAll();
    List<Booking> finalResult = new ArrayList<>();
    if(resultList!=null && resultList.isEmpty()==false)
    {
      for(BookingEntity bookingEntity: resultList)
      {
        Booking booking=new Booking();
        Address address=new Address();
        booking.setId(bookingEntity.getId());
        booking.setFirstName(bookingEntity.getFirst_name());
        booking.setLastName(bookingEntity.getLast_name());
        booking.setDob(bookingEntity.getDob());
        booking.setCheckinDatetime(bookingEntity.getCheckinDatetime());
        booking.setCheckoutDatetime(bookingEntity.getCheckoutDatetime());
        booking.setTotalprice(bookingEntity.getTotalprice());
        booking.setDeposit(bookingEntity.getDeposit());
        address.setLine1(bookingEntity.getAddrLine1());
        address.setLine2(bookingEntity.getAddrLine2());
        address.setState(bookingEntity.getState());
        address.setCity(bookingEntity.getCity());
        address.setZip(bookingEntity.getZip());
        booking.setAddress(address);
        finalResult.add(booking);
      }
    }else{
       throw new BookingException("1", "No booking available, please create new bookings");
    }
     return finalResult;
  }


}
