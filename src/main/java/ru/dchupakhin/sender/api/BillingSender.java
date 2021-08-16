package ru.dchupakhin.sender.api;

import ru.dchupakhin.model.BillingRequest;
import ru.dchupakhin.model.BillingResponse;

public interface BillingSender {
    BillingResponse send(BillingRequest billing);
}
