package com.lendico.loan.service;

import org.springframework.stereotype.Service;

import com.lendico.loan.dto.LoanRequestDTO;
import com.lendico.loan.dto.RepaymentPlanDTO;
import com.lendico.loan.exception.ResponseException;
import com.lendico.loan.repayment.AnnuityLoan;
import com.lendico.loan.repayment.AnnuityRepaymentPlan;
import com.lendico.loan.repayment.Loan;
import com.lendico.loan.repayment.RepaymentPlan;

/**
 *
 * @author caydogdu
 *
 *         This is a service for repayment plan calculation
 */
@Service
public class RepaymentPlanServiceImpl implements RepaymentPlanService {

    @Override
    public RepaymentPlanDTO calculateRepaymentPlan(LoanRequestDTO loanRequestDTO) throws ResponseException {
        Loan loan = new AnnuityLoan(loanRequestDTO);
        RepaymentPlan repaymentPlan = new AnnuityRepaymentPlan(loan);
        return repaymentPlan.calculate();
    }

}
