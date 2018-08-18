package com.lendico.loan.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lendico.loan.dto.LoanRequestDTO;
import com.lendico.loan.dto.PaymentDetailDTO;
import com.lendico.loan.exception.ExceptionHandler;
import com.lendico.loan.response.Response;
import com.lendico.loan.service.RepaymentPlanServiceImpl;

/**
 *
 * @author caydogdu
 *
 *         This is a controller for rest services
 */
@Controller
public class LoanController {

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private RepaymentPlanServiceImpl repaymentPlanService;

    /**
     *
     * @param LoanRequestDTO to calculate repayment plan
     * @return List<PaymentDetail>
     */
    @RequestMapping(value = "/generate-plan", method = RequestMethod.POST)
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    public ResponseEntity<Response<List<PaymentDetailDTO>>> generatePlan(@RequestBody LoanRequestDTO loanRequest) {

        Response<List<PaymentDetailDTO>> planResponse = new Response<>();
        ResponseEntity<Response<List<PaymentDetailDTO>>> response = new ResponseEntity<>(planResponse, HttpStatus.OK);

        try {

            response.getBody().setSuccess(true);
            response.getBody().setResult(repaymentPlanService.calculateRepaymentPlan(loanRequest).getPlan());

        } catch (Exception e) {
            logger.error("error", e);
            response.getBody().setSuccess(false);
            response.getBody().setError(ExceptionHandler.errorResponse(e));
        }
        return response;
    }

}
