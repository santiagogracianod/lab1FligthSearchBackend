package com.udea.flights.repository;
import com.udea.flights.model.Flight;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    //Traer solo por fechas
    List<Flight> findByDateBetween(LocalDate startDate, LocalDate endDate);
    //Traer solo por origen o por dentino
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin);
    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination);
    //Traer por escala
    List <Flight> findByDateBetweenAndScaleIs(LocalDate startDate, LocalDate endDate, Boolean scale);
    //Traer por aerolinea
    List <Flight> findByDateBetweenAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String airline);
    // Traer por origen y destino específicos
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination);
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndScaleIs(LocalDate startDate, LocalDate endDate, String origin, Boolean scale);
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String airline);
    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndScaleIs(LocalDate startDate, LocalDate endDate, String destination, Boolean scale);
    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination, String airline);
    List<Flight> findByDateBetweenAndScaleIsAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, Boolean scale, String airline);
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndScaleIs(LocalDate startDate, LocalDate endDate, String origin, String destination, Boolean scale);
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndAirlineContainsIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination, String airline);
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndScaleIsAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, Boolean scale, String airline);
    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndScaleIsAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination, Boolean scale, String airline);
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndScaleIsAndAirlineContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination, Boolean scale, String airline);
}
