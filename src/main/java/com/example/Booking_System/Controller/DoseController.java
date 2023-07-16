package com.example.Booking_System.Controller;

import com.example.Booking_System.Enum.DoseType;
import com.example.Booking_System.Model.Dose;
import com.example.Booking_System.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/dose1-taken")
    public ResponseEntity getDose(@RequestParam("id") int personId, @RequestParam("doseType")DoseType doseType)
    {
        try {
            Dose doseTaken = doseService.getDose(personId, doseType);
            return new ResponseEntity<>(doseTaken, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
