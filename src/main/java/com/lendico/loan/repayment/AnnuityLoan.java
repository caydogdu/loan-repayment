package com.lendico.loan.repayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

import com.lendico.loan.dto.LoanDetailDTO;
import com.lendico.loan.dto.LoanRequestDTO;

public class AnnuityLoan implements Loan {

    private static final Logger LOGGER = Logger.getLogger(AnnuityLoan.class.getName());

    private LoanRequestDTO loanRequestDTO;

    public AnnuityLoan(LoanRequestDTO loanRequestDTO) {
        this.loanRequestDTO = loanRequestDTO;
    }

    @Override
    public LoanDetailDTO calculate() {
        // calculating borrower payment amount
        double rate = loanRequestDTO.getNominalRate() / (12 * 100);
        BigDecimal borrowerPaymentAmount = BigDecimal.valueOf(rate).multiply(loanRequestDTO.getLoanAmount()).divide(
                BigDecimal.valueOf((1 - Math.pow(1 + rate, -(loanRequestDTO.getDuration())))), 2, RoundingMode.HALF_UP);

        LoanDetailDTO loanDetailDTO =
                new LoanDetailDTO(loanRequestDTO.getLoanAmount(), loanRequestDTO.getNominalRate(), "");
        loanDetailDTO.setBorrowerPaymentAmount(borrowerPaymentAmount);
        loanDetailDTO.setDuration(loanRequestDTO.getDuration());
        loanDetailDTO.setStartDate(loanRequestDTO.getStartDate());
        LOGGER.info(loanDetailDTO.toString());

        return loanDetailDTO;
    }

}
