package ru.dchupakhin.model;

import ru.dchupakhin.sender.SzSender;
import ru.dchupakhin.sender.UralSender;
import ru.dchupakhin.sender.YugSender;
import ru.dchupakhin.sender.api.BillingSender;

public enum BillingSystem {
    // При появлении новой системы реализуем новый BillingSender и добавляем новый объект BillingSystem
    YUG(new YugSender()), URAL(new UralSender()), SZ(new SzSender());

    private final BillingSender sender;

    BillingSystem(BillingSender sender) {
        this.sender = sender;
    }

    public BillingSender getSender() {
        return sender;
    }
}
