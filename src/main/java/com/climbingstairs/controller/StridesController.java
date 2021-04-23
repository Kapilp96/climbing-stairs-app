package com.climbingstairs.controller;

import com.climbingstairs.exception.MissingInputs;
import com.climbingstairs.exception.WrongInputs;
import com.climbingstairs.exception.ZeroRecordsException;
import com.climbingstairs.models.Strides;
import com.climbingstairs.models.StridesRecord;
import com.climbingstairs.repository.StridesRepository;
import com.climbingstairs.service.StridesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class StridesController  {

    @Autowired
    StridesRepository stridesRepository;

    @Autowired
    StridesService stridesService;

/* Two methods here - First one is to handle the GET request made to calculate and retrieve the number of strides required
Second one is to handle the GET request to retrieve the records or previous data about the requests made to calculate strides
 */


    @GetMapping("/stride")

    public ResponseEntity<Strides> calculateStrides(@RequestParam(value="flights") String[] flights, @RequestParam(value="stepsPerStride", defaultValue = "-1") int stepsPerStride )  {

        if(flights == null || stepsPerStride==-1)
            throw new MissingInputs("Input parameters flights and/or steps per stride are missing");
        if(flights.length < 1 || stepsPerStride==0)
            throw new WrongInputs("Input parameters flights and steps per stride must be greater than or equal to 1");
        if(flights.length > 30 || stepsPerStride>4)
            throw new WrongInputs("Input parameters flights should not exceed 30 values and steps per stride should not exceed 4");


       int stridesRequired = stridesService.returnStridesRequired(flights,stepsPerStride);


        StridesRecord sr= new StridesRecord(HttpStatus.OK.toString(),Arrays.toString(flights), stepsPerStride, stridesRequired);
        // System.out.println(sr);

        stridesRepository.save(sr);


        return ResponseEntity.ok().body(new Strides(HttpStatus.OK.toString(),stridesRequired));


    }

    @GetMapping("/stride/request")
    public ResponseEntity<List> getStridesRecord(@RequestParam(value="threshold") int threshold, @RequestParam("limit") int limit ) {

            List<StridesRecord> records = stridesRepository.getRecords(threshold, limit);
            System.out.println(records);

            if(records.isEmpty()) throw new ZeroRecordsException("No saved records found");

            return ResponseEntity.ok().body(records);



    }
}
