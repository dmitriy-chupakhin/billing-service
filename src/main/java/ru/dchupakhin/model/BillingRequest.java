package ru.dchupakhin.model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class BillingRequest {
    private Long sum;
    private LocalDateTime billingDate;
    private String userNumber;

    public BillingRequest(Long sum, LocalDateTime billingDate, String userNumber) {
        this.sum = sum;
        this.billingDate = billingDate;
        this.userNumber = userNumber;
    }

    public static BillingRequest mapFromRequest(HttpServletRequest request) {
        return new BillingRequest(
                Long.getLong(request.getParameter("sum")),
                LocalDateTime.parse(request.getParameter("billingDate")),
                request.getParameter("userNumber")
        );
    }

    public Long getSum() {
        return sum;
    }

    public LocalDateTime getBillingDate() {
        return billingDate;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
