package com.lendico.loan.service;

import com.lendico.loan.dto.LoanRequestDTO;
import com.lendico.loan.dto.RepaymentPlanDTO;
import com.lendico.loan.exception.ResponseException;

/**
 *
 * @author caydogdu
 *
 *         This is service interface for repayment plan calculation
 */
public interface RepaymentPlanService {

    public RepaymentPlanDTO calculateRepaymentPlan(LoanRequestDTO loanRequest) throws ResponseException;
}
