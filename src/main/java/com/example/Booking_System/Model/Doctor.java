package com.example.Booking_System.Model;


import com.example.Booking_System.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true)
    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
