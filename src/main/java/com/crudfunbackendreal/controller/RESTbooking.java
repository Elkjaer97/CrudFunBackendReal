package com.crudfunbackendreal.controller;


import com.crudfunbackendreal.model.Booking;
import com.crudfunbackendreal.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class RESTbooking {

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        bookingRepository.save(booking);

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Booking> displayBooking(){
        return bookingRepository.findAll();
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Booking> deleteBooking (@PathVariable int bookId) {
        bookingRepository.deleteById(bookId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int bookId, @RequestBody Booking updatedBooking){

        Optional<Booking> optionalBooking = bookingRepository.findById(bookId);

        Booking myBooking = optionalBooking.get();

        myBooking.setBasin(updatedBooking.getBasin());
        myBooking.setBane(updatedBooking.getBane());

        myBooking = bookingRepository.save(myBooking);

        return new ResponseEntity<>(myBooking, HttpStatus.OK);
    }


}
