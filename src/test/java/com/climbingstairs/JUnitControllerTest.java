package com.climbingstairs;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class JUnitControllerTest {

    @Autowired
    MockMvc mockMvc;



    @Test
    public void checkResultTest() throws IOException {

        HttpUriRequest request = new HttpGet( "http://localhost:8080/stride?flights=17,17&stepsPerStride=3" );

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );


        String message = EntityUtils.toString(httpResponse.getEntity());


        System.out.println(message);


        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));

        assertThat(
                message.contains("14"),
                equalTo(true));

    }




    @Test
    public void missingInputs() throws IOException {

        HttpUriRequest request = new HttpGet( "http://localhost:8080/stride?flights=17,17" );

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );


        String message = EntityUtils.toString(httpResponse.getEntity());


        System.out.println(message);


        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_BAD_REQUEST));

        assertThat(
                message.contains("Input parameters flights and/or steps per stride are missing"),
                equalTo(true));

    }

    @Test
    public void wrongInputs() throws IOException {

        HttpUriRequest request = new HttpGet( "http://localhost:8080/stride?flights=17,17&stepsPerStride=0" );

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );


        String message = EntityUtils.toString(httpResponse.getEntity());


        System.out.println(message);


        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_BAD_REQUEST));

        assertThat(
                message.contains("Input parameters flights and steps per stride must be greater than or equal to 1"),
                equalTo(true));



    }



}
