package com.lendico.loan.dto;

import java.math.BigDecimal;

public class LoanDetailDTO {

    private BigDecimal loanAmount;

    private double nominalRate;

    private int duration;

    private BigDecimal borrowerPaymentAmount;

    private String startDate;

    public LoanDetailDTO(BigDecimal loanAmount, double nominalRate, String startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.startDate = startDate;
    }

    public BigDecimal getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public int getDuration() {
        return duration;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public double getNominalRate() {
        return nominalRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setNominalRate(double nominalRate) {
        this.nominalRate = nominalRate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "LoanDetailDTO [loanAmount=" + loanAmount + ", nominalRate=" + nominalRate + ", duration=" + duration
                + ", borrowerPaymentAmount=" + borrowerPaymentAmount + ", startDate=" + startDate + "]";
    }

}
