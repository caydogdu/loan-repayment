package com.lendico.loan.dto;

import java.math.BigDecimal;

public class PaymentDetailDTO {

    private String date;

    private BigDecimal borrowerPaymentAmount;

    private BigDecimal principal;

    private BigDecimal interest;

    private BigDecimal initialOutstandingPrincipal;

    private BigDecimal remainingOutstandingPrincipal;

    public PaymentDetailDTO(String date, BigDecimal borrowerPaymentAmount) {
        this.date = date;
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PaymentDetailDTO other = (PaymentDetailDTO) obj;
        if (date == null) {
            if (other.date != null) {
                return false;
            }
        } else if (!date.equals(other.date)) {
            return false;
        }
        return true;
    }

    public BigDecimal getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }

    @Override
    public String toString() {
        return "PaymentDetailDTO [date=" + date + ", borrowerPaymentAmount=" + borrowerPaymentAmount + ", principal="
                + principal + ", interest=" + interest + ", initialOutstandingPrincipal=" + initialOutstandingPrincipal
                + ", remainingOutstandingPrincipal=" + remainingOutstandingPrincipal + "]";
    }

}
