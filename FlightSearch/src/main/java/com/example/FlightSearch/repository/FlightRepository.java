package com.example.FlightSearch.repository;

import com.example.FlightSearch.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAfter(String departureAirport,
                                                                                  String arrivalAirport,
                                                                                  LocalDateTime departureDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAfterAndReturnDateTimeBefore(
            String departureAirport, String arrivalAirport,
            LocalDateTime departureDateTime, LocalDateTime returnDateTime);
}
