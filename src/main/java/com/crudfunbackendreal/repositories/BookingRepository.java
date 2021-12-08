package com.crudfunbackendreal.repositories;

import com.crudfunbackendreal.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
