package com.lendico.loan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.lendico.loan.dto.LoanDetailDTO;
import com.lendico.loan.dto.LoanRequestDTO;
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

}
