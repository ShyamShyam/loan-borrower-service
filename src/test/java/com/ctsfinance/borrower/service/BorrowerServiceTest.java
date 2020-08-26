package com.ctsfinance.borrower.service;

import com.ctsfinance.borrower.mock.MockData;
import com.ctsfinance.borrower.model.LoanDetails;
import com.ctsfinance.borrower.repository.BorrowerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowerServiceTest {

    @Mock
    BorrowerRepository borrowerRepository;

    @Mock
    BorrowerService borrowerService;

    @InjectMocks
    MockData mockData;

    @Test
    public void testFetchBorrowerDetails(){

        //Mockito.when(borrowerRepository.fetchAll("s")).thenReturn(Optional.of(mockData.getLoanDetails()));

        //LoanDetails response = borrowerService.fetchBorrowerDetails("S");

        //assertEquals(Optional.empty(), response);
    }

    @Test
    public void testSaveBorrowerDetails(){

        Mockito.when(borrowerRepository.save(mockData.getLoanDetail())).thenReturn(mockData.getLoanDetail());

        LoanDetails response = borrowerService.saveBorrowerDetails(mockData.getLoanDetail());

        assertNotNull(response);
    }

    @Test
    public void testModifyBorrowerDetails(){

        mockData.getLoanDetail().setLoanId(1l);

        Mockito.when(borrowerRepository.save(mockData.getLoanDetail())).thenReturn(mockData.getLoanDetail());

        LoanDetails response = borrowerService.modifyBorrowerDetails(mockData.getLoanDetail(),
                mockData.getLoanDetail().getLoanId());

        assertNotNull(response);
    }
}
