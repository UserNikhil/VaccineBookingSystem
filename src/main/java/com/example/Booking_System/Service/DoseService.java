package com.example.Booking_System.Service;

import com.example.Booking_System.Enum.DoseType;
import com.example.Booking_System.Exception.DoseAlreadyTaken;
import com.example.Booking_System.Exception.PersonNotFound;
import com.example.Booking_System.Model.Dose;
import com.example.Booking_System.Model.Person;
import com.example.Booking_System.Repository.DoseRepository;
import com.example.Booking_System.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;
    public Dose getDose(int personId, DoseType doseType) {

        Optional<Person> optionalPerson= personRepository.findById(personId);
        if(!optionalPerson.isPresent())
        {
            throw new PersonNotFound("Invalid PersonId");
        }

        Person person=optionalPerson.get();
        if(person.isDose1Taken())
        {
            throw new DoseAlreadyTaken("Dose 1 already taken");
        }

        Dose dose=new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(doseType);
        dose.setPerson(person);
        person.setDose1Taken(true);
        personRepository.save(person);
        return doseRepository.save(dose);
    }
}
