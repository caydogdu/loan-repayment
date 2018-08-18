package com.lendico.loan.repayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.lendico.loan.dto.LoanDetailDTO;
import com.lendico.loan.dto.PaymentDetailDTO;
import com.lendico.loan.dto.RepaymentPlanDTO;

public class AnnuityRepaymentPlan implements RepaymentPlan {

    private static final Logger LOGGER = Logger.getLogger(AnnuityRepaymentPlan.class.getName());

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Loan loan;

    public AnnuityRepaymentPlan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public RepaymentPlanDTO calculate() {

        LoanDetailDTO loanDetail = loan.calculate();

        RepaymentPlanDTO repaymentPlan = new RepaymentPlanDTO();
        List<PaymentDetailDTO> plan = new ArrayList<>();
        BigDecimal initialOutstandingPrincipal = loanDetail.getLoanAmount();

        for (int i = 0; i < loanDetail.getDuration(); i++) {

            PaymentDetailDTO paymentDetail = getMonthlyPaymentDetail(loanDetail, i + 1, initialOutstandingPrincipal);
            initialOutstandingPrincipal = paymentDetail.getRemainingOutstandingPrincipal();

            // for the last instalment payment remaining outstanding principal must be zero
            if (i + 1 == loanDetail.getDuration()
                    && paymentDetail.getRemainingOutstandingPrincipal().compareTo(BigDecimal.ZERO) != 0) {
                paymentDetail.setBorrowerPaymentAmount(
                        paymentDetail.getBorrowerPaymentAmount().add(paymentDetail.getRemainingOutstandingPrincipal()));
                paymentDetail.setPrincipal(
                        paymentDetail.getPrincipal().add(paymentDetail.getRemainingOutstandingPrincipal()));
                paymentDetail.setRemainingOutstandingPrincipal(BigDecimal.valueOf(0));
            }
            LOGGER.info(paymentDetail.toString());
            plan.add(paymentDetail);

        }

        repaymentPlan.setPlan(plan);

        return repaymentPlan;
    }

    private PaymentDetailDTO getMonthlyPaymentDetail(LoanDetailDTO loanDetail, int paymentNumber,
            BigDecimal initialOutstandingPrincipal) {
        // calculating interest amount for each month
        BigDecimal interest = BigDecimal.valueOf(loanDetail.getNominalRate() * 30).multiply(initialOutstandingPrincipal)
                .divide(BigDecimal.valueOf(360), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        PaymentDetailDTO paymentDetail = new PaymentDetailDTO(getPaymentDate(loanDetail.getStartDate(), paymentNumber),
                loanDetail.getBorrowerPaymentAmount());
        paymentDetail.setPrincipal(loanDetail.getBorrowerPaymentAmount().subtract(interest));
        paymentDetail.setInterest(interest);
        paymentDetail.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
        paymentDetail
                .setRemainingOutstandingPrincipal(initialOutstandingPrincipal.subtract(paymentDetail.getPrincipal()));
        return paymentDetail;
    }

    private String getPaymentDate(String startDate, int paymentNumber) {
        LocalDate date = LocalDate.parse(startDate, formatter);
        return date.plusMonths(paymentNumber - 1).format(formatter);
    }

}
