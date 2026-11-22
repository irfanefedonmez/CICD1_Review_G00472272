package ie.atu.sample.service;
import ie.atu.sample.client.RoomClient;
import ie.atu.sample.dto.BookingRequest;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.dto.BookingRoom;
import ie.atu.sample.model.Booking;
import ie.atu.sample.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomClient roomClient;

    public BookingService(BookingRepository bookingRepository,
                          RoomClient roomClient) {
        this.bookingRepository = bookingRepository;
        this.roomClient = roomClient;
    }

    public BookingResponse addBooking(BookingRequest request) {

        BookingRoom room = roomClient.getRoomById(request.roomId());

        if (request.attendeeCount() > room.getCapacity()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Too many attendees for this room"
            );
        }

        Booking booking = new Booking(
                request.organiserName(),
                request.attendeeCount(),
                request.roomId()
        );

        Booking savedBooking = bookingRepository.save(booking);

        return new BookingResponse(
                savedBooking.getId(),
                savedBooking.getOrganiserName(),
                savedBooking.getAttendeeCount(),
                savedBooking.getRoomId(),
                savedBooking.getStatus()
        );
    }

    public BookingResponse getBookingById(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Booking not found"
                ));

        return new BookingResponse(
                booking.getId(),
                booking.getOrganiserName(),
                booking.getAttendeeCount(),
                booking.getRoomId(),
                booking.getStatus()
        );
    }
}
