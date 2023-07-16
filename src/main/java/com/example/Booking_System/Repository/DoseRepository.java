package com.example.Booking_System.Repository;

import com.example.Booking_System.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
