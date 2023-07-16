package com.example.Booking_System.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String certificateNo;

    String confirmationMsg;

    @OneToOne
    @JoinColumn
    Person person;
}
