package com.climbingstairs.service;

import org.springframework.stereotype.Service;

@Service
public class StridesServiceImpl implements StridesService {

        //function to calculate the strides required
    public int returnStridesRequired(String[] flights, int stepsPerStride)
    {
        int rem=0, stridesRequired=0;

        for(int i=0;i<flights.length;i++){

            rem = Integer.parseInt(flights[i])%stepsPerStride;

            if(rem==0)
            {
                stridesRequired += Integer.parseInt(flights[i])/stepsPerStride;

            }
            else
            {
                stridesRequired += (Integer.parseInt(flights[i])-rem)/stepsPerStride + 1;

            }
            if(i+1 < flights.length)
            {
                stridesRequired += 2;

            }

        }
        return stridesRequired;
    }
}
