package ru.dchupakhin.service;

import ru.dchupakhin.model.BillingRequest;
import ru.dchupakhin.model.BillingResponse;
import ru.dchupakhin.model.BillingSystem;

public class BillingService {

    public BillingResponse process(BillingRequest billing, BillingSystem system) {
        return system.getSender().send(billing);
    }
}
