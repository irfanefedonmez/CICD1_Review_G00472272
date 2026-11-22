package ie.atu.sample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should be filled")
    @Size(min = 2, max = 60)
    private String organiserName;

    @Positive(message = "Number should be positive")
    private int attendeeCount;

    @NotNull
    private Long roomId;

    private String status = "ACTIVE";

    public Booking(String organiserName, int attendeeCount, Long roomId) {
        this.organiserName = organiserName;
        this.attendeeCount = attendeeCount;
        this.roomId = roomId;
        this.status = "ACTIVE";
    }

}
