package ie.atu.sample.controller;

import ie.atu.sample.dto.BookingRequest;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse addBooking(
            @Valid @RequestBody BookingRequest request) {

        return bookingService.addBooking(request);
    }

    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {

        return bookingService.getBookingById(id);
    }
}
