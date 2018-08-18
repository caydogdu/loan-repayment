package com.lendico.loan.dto;

import java.util.List;

public class RepaymentPlanDTO {

    private LoanDetailDTO loanDetail;

    private List<PaymentDetailDTO> plan;

    public LoanDetailDTO getLoanDetail() {
        return loanDetail;
    }

    public List<PaymentDetailDTO> getPlan() {
        return plan;
    }

    public void setLoanDetail(LoanDetailDTO loanDetail) {
        this.loanDetail = loanDetail;
    }

    public void setPlan(List<PaymentDetailDTO> plan) {
        this.plan = plan;
    }

}
