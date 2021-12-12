package impl;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.AllBookings;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.model.Response;
import com.paypal.bfs.test.bookingserv.dao.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.BookingException;
import com.paypal.bfs.test.bookingserv.impl.BookingResourceImpl;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.aspectj.lang.annotation.Before;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
public class BookingResourceImplTest {

    @Mock
    BookingService bookingService;


    @InjectMocks
    BookingResourceImpl bookingResourceImp;

    @Before("")
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createBookingTest()
    {
        Mockito.when(bookingService.validateCreateBookingReq(Mockito.any())).thenReturn(true);
        Mockito.when(bookingService.createBooking(Mockito.any())).thenReturn(getBookingEntity(getBooking()));
        ResponseEntity<Response> bookingEntity=bookingResourceImp.create(getBooking());
        assertEquals(bookingEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(bookingEntity.getBody().getBookingId(), getBooking().getId());

    }

    @Test
    public void createBookingTestFalse()
    {
        Mockito.when(bookingService.validateCreateBookingReq(Mockito.any())).thenReturn(false);
        Mockito.when(bookingService.createBooking(Mockito.any())).thenReturn(getBookingEntity(getBooking()));
        BookingException exception = assertThrows(
                BookingException.class,
                () -> bookingResourceImp.create(getBooking()));


    }

    @Test
    public void getAllBookingTest() throws ParseException {
        ArrayList<Booking> list=new ArrayList<>();
        list.add(getBooking());
        Mockito.when(bookingService.getAllBookings()).thenReturn(list);
        ResponseEntity<AllBookings> responseEntity =bookingResourceImp.getAllBookings();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    public Booking getBooking()
    {
        Booking booking=new Booking();
        booking.setId(1);
        booking.setFirstName("Ankita");
        booking.setLastName("Inaniya");
        booking.setDob(new Date());
        booking.setCheckinDatetime(new Date());
        booking.setCheckoutDatetime(new Date());
        Address address=new Address();
        address.setLine1("hno. 170");
        address.setLine2("annapura");
        address.setCity("Harda");
        address.setState("mp");
        address.setZip("461331");
        booking.setAddress(address);
        booking.setDeposit(100.0);
        booking.setTotalprice(1000.00);

        return booking;
    }

    public BookingEntity getBookingEntity(Booking booking)
    {
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
        bookingEntity.setHash(Objects.hash(booking.getId(),booking.getFirstName(),booking.getLastName(),
                booking.getDob(),booking.getCheckinDatetime(),booking.getCheckoutDatetime(),booking.getTotalprice(),booking.getDeposit(),booking.getAddress().getLine1(),
                booking.getAddress().getLine2(),booking.getAddress().getCity(),booking.getAddress().getState(),booking.getAddress().getZip()));
        return bookingEntity;
    }
}
