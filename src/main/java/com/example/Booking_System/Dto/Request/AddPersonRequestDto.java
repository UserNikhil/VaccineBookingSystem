package com.example.Booking_System.Dto.Request;

import com.example.Booking_System.Enum.Gender;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonRequestDto {

    String name;

    int age;

    String emailId;

    Gender gender;
}
