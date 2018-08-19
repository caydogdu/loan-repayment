package com.lendico.loan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.lendico.loan.dto.LoanDetailDTO;
import com.lendico.loan.dto.LoanRequestDTO;
import com.lendico.loan.exception.ResponseException;
import com.lendico.loan.repayment.AnnuityLoan;
import com.lendico.loan.repayment.Loan;

public class AnnuityLoanTest {

    @Test
    public void calculateTest() throws Exception {

        LoanRequestDTO loanRequestDTO = new LoanRequestDTO();
        loanRequestDTO.setLoanAmount(new BigDecimal(5000));
        loanRequestDTO.setDuration(24);
        loanRequestDTO.setNominalRate(5);
        loanRequestDTO.setStartDate("01.01.2018");

        Loan loan = new AnnuityLoan(loanRequestDTO);
        LoanDetailDTO loanDetailDTO = loan.calculate();
        assertEquals(219, loanDetailDTO.getBorrowerPaymentAmount().intValue());

    }

    @Test
    public void calculateTestDurationIsZero() throws Exception {

        LoanRequestDTO loanRequestDTO = new LoanRequestDTO();
        loanRequestDTO.setLoanAmount(new BigDecimal(5000));
        loanRequestDTO.setDuration(0);
        loanRequestDTO.setNominalRate(5);
        loanRequestDTO.setStartDate("01.01.2018");

        Loan loan = new AnnuityLoan(loanRequestDTO);

        try {
            loan.calculate();
        } catch (ResponseException e) {
            assertEquals("ERR-03", e.getExceptionCode());
        }

    }

    @Test
    public void calculateTestWhenRateIsZero() throws Exception {

        LoanRequestDTO loanRequestDTO = new LoanRequestDTO();
        loanRequestDTO.setLoanAmount(new BigDecimal(5000));
        loanRequestDTO.setDuration(24);
        loanRequestDTO.setNominalRate(0);
        loanRequestDTO.setStartDate("01.01.2018");

        Loan loan = new AnnuityLoan(loanRequestDTO);

        try {
            loan.calculate();
        } catch (ResponseException e) {
            assertEquals("ERR-01", e.getExceptionCode());
        }

    }

}
