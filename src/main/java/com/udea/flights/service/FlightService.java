package com.udea.flights.service;
import com.udea.flights.model.Flight;
import com.udea.flights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination, Boolean scale, String airline) {
        // Generar una clave de combinación de parámetros para usar en el switch
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (scale != null ? "1" : "0") +
                (airline != null ? "1" : "0");

        switch (key) {
            case "1000":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCase(startDate, endDate, origin);
            case "0100":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCase(startDate, endDate, destination);
            case "0010":
                return flightRepository.findByDateBetweenAndScaleIs(startDate, endDate, scale);
            case "0001":
                return flightRepository.findByDateBetweenAndAirlineContainingIgnoreCase(startDate, endDate, airline);
            case "1100":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(startDate, endDate, origin, destination);
            case "1010":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndScaleIs(startDate, endDate, origin, scale);
            case "1001":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndAirlineContainingIgnoreCase(startDate, endDate, origin, airline);
            case "0110":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndScaleIs(startDate, endDate, destination, scale);
            case "0101":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndAirlineContainingIgnoreCase(startDate, endDate, destination, airline);
            case "0011":
                return flightRepository.findByDateBetweenAndScaleIsAndAirlineContainingIgnoreCase(startDate, endDate, scale, airline);
            case "1110":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndScaleIs(startDate, endDate, origin, destination, scale);
            case "1101":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndAirlineContainsIgnoreCase(startDate, endDate, origin, destination, airline);
            case "1011":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndScaleIsAndAirlineContainingIgnoreCase(startDate, endDate, origin, scale, airline);
            case "0111":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndScaleIsAndAirlineContainingIgnoreCase(startDate, endDate, destination, scale, airline);
            case "1111":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndScaleIsAndAirlineContainingIgnoreCase(startDate, endDate, origin, destination, scale, airline);
            case "0000":
            default:
                return flightRepository.findByDateBetween(startDate, endDate);
        }
    }
}
