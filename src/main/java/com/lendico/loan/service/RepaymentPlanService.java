package com.lendico.loan.service;

import com.lendico.loan.dto.LoanRequestDTO;
import com.lendico.loan.dto.RepaymentPlanDTO;

/**
 *
 * @author caydogdu
 *
 *         This is service interface for repayment plan calculation
 */
public interface RepaymentPlanService {

    public RepaymentPlanDTO calculateRepaymentPlan(LoanRequestDTO loanRequest);
}
