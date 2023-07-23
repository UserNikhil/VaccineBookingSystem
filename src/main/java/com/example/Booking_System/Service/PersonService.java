package com.example.Booking_System.Service;


import com.example.Booking_System.Dto.Request.AddPersonRequestDto;
import com.example.Booking_System.Dto.Response.AddPersonResponseDto;
import com.example.Booking_System.Exception.PersonNotFoundException;
import com.example.Booking_System.Model.Person;
import com.example.Booking_System.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;
    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {
        Person person=new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmail(addPersonRequestDto.getEmailId());
        person.setGender(addPersonRequestDto.getGender());
        person.setDose1Taken(false);
        person.setDos2Taken(false);
        person.setCertificate(null);

        Person savedPerson=personRepository.save(person);

       AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
       addPersonResponseDto.setName(savedPerson.getName());
       addPersonResponseDto.setEmail(savedPerson.getEmail());
       addPersonResponseDto.setMessage("Congrats! you have been registered");
       return  addPersonResponseDto;
    }

    public String updateEmail(String oldEmail, String newEmail)
    {
        Person person=personRepository.findByEmail(oldEmail);
        if(person==null)
        {
            throw new PersonNotFoundException("Sorry Email doesn't exist");
        }
        person.setEmail(newEmail);
        personRepository.save(person);
        return "Congrats, updated successfully";
    }
}
