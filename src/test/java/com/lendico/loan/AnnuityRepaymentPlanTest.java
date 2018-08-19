package com.lendico.loan;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.lendico.loan.dto.LoanRequestDTO;
import com.lendico.loan.dto.RepaymentPlanDTO;
import com.lendico.loan.exception.ResponseException;
import com.lendico.loan.repayment.AnnuityLoan;
import com.lendico.loan.repayment.AnnuityRepaymentPlan;
import com.lendico.loan.repayment.Loan;
import com.lendico.loan.repayment.RepaymentPlan;

public class AnnuityRepaymentPlanTest {

    @Test
    public void calculateTest() throws Exception {

        LoanRequestDTO loanRequestDTO = new LoanRequestDTO();
        loanRequestDTO.setLoanAmount(new BigDecimal(5000));
        loanRequestDTO.setDuration(24);
        loanRequestDTO.setNominalRate(5);
        loanRequestDTO.setStartDate("01.01.2018");

        Loan loan = new AnnuityLoan(loanRequestDTO);
        RepaymentPlan repaymentPlan = new AnnuityRepaymentPlan(loan);
        RepaymentPlanDTO planDTO = repaymentPlan.calculate();
        assertEquals(24, planDTO.getPlan().size());

    }

    @Test
    public void calculateTestWhenStartDateHasWrongFormat() throws Exception {

        LoanRequestDTO loanRequestDTO = new LoanRequestDTO();
        loanRequestDTO.setLoanAmount(new BigDecimal(5000));
        loanRequestDTO.setDuration(24);
        loanRequestDTO.setNominalRate(5);
        loanRequestDTO.setStartDate("xxx");

        Loan loan = new AnnuityLoan(loanRequestDTO);
        RepaymentPlan repaymentPlan = new AnnuityRepaymentPlan(loan);

        try {
            repaymentPlan.calculate();
        } catch (ResponseException e) {
            assertEquals("ERR-02", e.getExceptionCode());
        }

    }

}
