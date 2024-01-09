package com.example.FlightSearch.service;
import com.example.FlightSearch.entity.Flight;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface FlightService {
    public List<Flight> searchFlights(String departureAirport, String arrivalAirport,
                                      LocalDateTime departureDateTime, LocalDateTime returnDateTime);

    public Flight getFlightById(Long flightId);

    public List<Flight> getAllFlights();

    public Flight addFlight(Flight newFlight);

    public Flight updateFlight(Long flightId, Flight updatedFlight) ;

    public boolean deleteFlight(Long flightId);
}


