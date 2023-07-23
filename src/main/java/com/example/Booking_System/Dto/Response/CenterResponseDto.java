package com.example.Booking_System.Dto.Response;


import com.example.Booking_System.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterResponseDto {
    String centerName;

    CenterType centerType;

    String address;

}
