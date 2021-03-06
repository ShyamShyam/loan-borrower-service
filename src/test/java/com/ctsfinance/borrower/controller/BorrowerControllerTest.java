package com.ctsfinance.borrower.controller;

import com.ctsfinance.borrower.mock.MockData;
import com.ctsfinance.borrower.repository.BorrowerRepository;
import com.ctsfinance.borrower.service.BorrowerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowerControllerTest {

    @Mock
    BorrowerController borrowerController;

    @Mock
    BorrowerRepository borrowerRepository;

    @Mock
    BorrowerService borrowerService;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    MockData mockData;

    String jsonString = "{\"userId\": 2, \"borrowerName\": \"Shyam\", \"loanAmount\": 12000, \"loanTerm\": \"not applicable\", \"loanType\": \"Bicycle\", \"propertyDocument\": \"12th marksheet\", \"addressLine1\": \"ITPL Kundalhalli\", \"addressLine2\": null, \"city\": \"Bangalore\", \"state\": \"KA\", \"zipCode\": 560044 }";

    @Test()
    public void testGetBorrowerDetails() throws Exception{

       Mockito.when(borrowerService.fetchBorrowerDetails("keyword")).thenReturn(mockData.getLoanDetails());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/borrower/search")
                .param("keyword", "S")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(jsonString, result.getResponse().getContentAsString(), false);

    }

    @Test()
    public void testSaveBorrowerDetails() throws Exception{

        Mockito.when(borrowerService.saveBorrowerDetails(mockData.getLoanDetail())).thenReturn(mockData.getLoanDetail());

        // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/borrower/save")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test()
    public void testUpdateBorrowerDetails() throws Exception{

        mockData.getLoanDetail().setLoanId(1l);

        Mockito.when(borrowerService.modifyBorrowerDetails(mockData.getLoanDetail(), mockData.getLoanDetail().getLoanId())).thenReturn(mockData.getLoanDetail());

        // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/borrower/update/1")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
}
