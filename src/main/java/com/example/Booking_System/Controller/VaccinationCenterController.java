package com.example.Booking_System.Controller;

import com.example.Booking_System.Dto.Request.CenterRequestDto;
import com.example.Booking_System.Dto.Response.CenterResponseDto;
import com.example.Booking_System.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService centerService;

    @PostMapping("/add")
    public CenterResponseDto addCenter(@RequestBody CenterRequestDto centerRequestDto){

        CenterResponseDto centerResponseDto = centerService.addCenter(centerRequestDto);
        return centerResponseDto;
    }

    // get all the doctors at centers of a particular centerType

    // get the center with highest number of doctors

    // get the center with highest number of doctors among a particular centerType

}
