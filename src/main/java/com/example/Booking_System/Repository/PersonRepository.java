package com.example.Booking_System.Repository;

import com.example.Booking_System.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
