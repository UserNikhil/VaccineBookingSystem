package com.example.Booking_System.Model;


import com.example.Booking_System.Enum.CentreType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    CentreType centreType;

    String centreName;

    String address;

}
