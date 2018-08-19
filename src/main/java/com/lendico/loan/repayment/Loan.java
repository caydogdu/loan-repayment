package com.lendico.loan.repayment;

import com.lendico.loan.dto.LoanDetailDTO;
import com.lendico.loan.exception.ResponseException;

public interface Loan {

    public LoanDetailDTO calculate() throws ResponseException;

}
