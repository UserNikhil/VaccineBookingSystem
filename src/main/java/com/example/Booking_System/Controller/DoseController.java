package com.example.Booking_System.Controller;

import com.example.Booking_System.Dto.Request.BookDose1RequestDto;
import com.example.Booking_System.Enum.DoseType;
import com.example.Booking_System.Model.Dose;
import com.example.Booking_System.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;
//
//    @PostMapping("/dose1-taken")
//    public ResponseEntity getDose(@RequestParam("id") int personId, @RequestParam("doseType")DoseType doseType)
//    {
//        try {
//            Dose doseTaken = doseService.getDose(personId, doseType);
//            return new ResponseEntity<>(doseTaken, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/dose1-taken")
    public ResponseEntity getDose(@RequestBody BookDose1RequestDto bookDose1RequestDto)
    {
        try {
            Dose doseTaken = doseService.getDose(bookDose1RequestDto);
            return new ResponseEntity<>(doseTaken, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
