package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.AccountId;
import org.example.domain.guest.values.Address;

public class UpdatedAddressAccount extends DomainEvent {
    private final AccountId accountId;
    private final Address address;

    public UpdatedAddressAccount(AccountId accountId, Address address) {
        super("sofka.guest.updatedAddressAccount");
        this.accountId = accountId;
        this.address = address;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Address getAddress() {
        return address;
    }
}
