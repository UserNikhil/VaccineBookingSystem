package com.example.Booking_System.Dto.Request;

import com.example.Booking_System.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDose1RequestDto {
    int personId;

    DoseType doseType;
}
