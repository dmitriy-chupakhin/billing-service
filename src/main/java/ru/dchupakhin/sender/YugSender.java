package ru.dchupakhin.sender;

import ru.dchupakhin.model.BillingRequest;
import ru.dchupakhin.model.BillingResponse;
import ru.dchupakhin.sender.api.BillingSender;

public class YugSender implements BillingSender {
    @Override
    public BillingResponse send(BillingRequest billing) {
        return null;
    }
}
