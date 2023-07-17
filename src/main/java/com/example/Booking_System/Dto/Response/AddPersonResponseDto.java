package com.example.Booking_System.Dto.Response;

import com.example.Booking_System.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonResponseDto {

    String name;

    String message;

    String Email;
}
