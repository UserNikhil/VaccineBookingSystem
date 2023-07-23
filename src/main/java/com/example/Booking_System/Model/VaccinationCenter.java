package com.example.Booking_System.Model;


import com.example.Booking_System.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

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

    CenterType CenterType;

    String CenterName;

    String address;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    List<Doctor> doctors= new ArrayList<>();
}
