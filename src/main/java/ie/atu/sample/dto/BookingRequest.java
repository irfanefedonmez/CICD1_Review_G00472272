package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public record BookingRequest(@NotBlank(message = "Name should be filled")
                            @Size(min = 2, max = 60)
                            String organiserName,

                            @NotNull(message = "Room ID is required")
                            Long roomId,

                            @Positive(message = "Number should be positive")
                            int attendeeCount
) {
}
