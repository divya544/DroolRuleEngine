package com.drool.controller;

import com.drool.model.FDRequest;
import com.drool.model.InterestDetail;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FixedDepositRateController {

    private final KieSession kieSession;

    public FixedDepositRateController(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    @RequestMapping(value = "/getFDInterestRate", method = RequestMethod.GET, produces = "application/json")
    public FDRequest getQuestions(@RequestParam(required = true) String bank, @RequestParam(required = true) Integer durationInYear) {
        FDRequest fdRequest = new FDRequest(bank,durationInYear);
        kieSession.insert(fdRequest);
        kieSession.fireAllRules();
        return fdRequest;
    }

    @RequestMapping(value = "/getNewAmount", method = RequestMethod.GET, produces = "application/json")
    public InterestDetail getNewAmount(@RequestParam(required = true) String bankName, @RequestParam(required = true) int amount) {
        InterestDetail interestDetail = new InterestDetail(bankName,amount);
        kieSession.insert(interestDetail);
        kieSession.fireAllRules();
        interestDetail.setNewAmount(((100- interestDetail.getInterestRate())* interestDetail.getAmount())/100);
        return interestDetail;
    }

}
