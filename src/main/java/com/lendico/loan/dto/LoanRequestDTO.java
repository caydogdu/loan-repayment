package com.lendico.loan.dto;

import java.math.BigDecimal;

public class LoanRequestDTO {

    private BigDecimal loanAmount;

    private double nominalRate;

    private int duration;

    private String startDate;

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
        return "LoanRequestDTO [loanAmount=" + loanAmount + ", nominalRate=" + nominalRate + ", duration=" + duration
                + ", startDate=" + startDate + "]";
    }

}
