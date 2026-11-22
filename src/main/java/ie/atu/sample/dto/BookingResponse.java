package ie.atu.sample.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long id;
    private String organiserName;
    private int attendeeCount;
    private Long roomId;
    private String status;
}
