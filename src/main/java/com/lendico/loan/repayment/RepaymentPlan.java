package com.lendico.loan.repayment;

import com.lendico.loan.dto.RepaymentPlanDTO;
import com.lendico.loan.exception.ResponseException;

public interface RepaymentPlan {

    public RepaymentPlanDTO calculate() throws ResponseException;

}
