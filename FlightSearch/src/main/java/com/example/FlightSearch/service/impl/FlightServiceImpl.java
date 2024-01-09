package com.example.FlightSearch.service.impl;

import com.example.FlightSearch.entity.Flight;
import com.example.FlightSearch.repository.FlightRepository;
import com.example.FlightSearch.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(String departureAirport, String arrivalAirport,
                                      LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        if (returnDateTime != null) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAfterAndReturnDateTimeBefore(
                    departureAirport, arrivalAirport, departureDateTime, returnDateTime);
        } else {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAfter(
                    departureAirport, arrivalAirport, departureDateTime);
        }
    }

    public Flight getFlightById(Long flightId) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        return optionalFlight.orElse(null);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight addFlight(Flight newFlight) {
        return flightRepository.save(newFlight);
    }

    public Flight updateFlight(Long flightId, Flight updatedFlight) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            Flight existingFlight = optionalFlight.get();
            existingFlight.setDepartureAirport(updatedFlight.getDepartureAirport());
            existingFlight.setArrivalAirport(updatedFlight.getArrivalAirport());
            existingFlight.setDepartureDateTime(updatedFlight.getDepartureDateTime());
            existingFlight.setReturnDateTime(updatedFlight.getReturnDateTime());
            existingFlight.setPrice(updatedFlight.getPrice());

            return flightRepository.save(existingFlight);
        } else {
            return null;
        }
    }

    public boolean deleteFlight(Long flightId) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            flightRepository.deleteById(flightId);
            return true;
        } else {
            return false;
        }
    }
}
