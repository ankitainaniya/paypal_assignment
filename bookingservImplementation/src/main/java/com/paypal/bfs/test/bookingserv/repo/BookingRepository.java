package com.paypal.bfs.test.bookingserv.repo;

import com.paypal.bfs.test.bookingserv.dao.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

    @Query(value="select b.hash from booking b where b.hash=(:hash)",nativeQuery = true)
     int getByHashId(@Param("hash") int hash);

}
