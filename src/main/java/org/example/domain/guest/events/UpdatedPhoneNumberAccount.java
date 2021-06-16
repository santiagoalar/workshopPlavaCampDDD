package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.AccountId;
import org.example.domain.guest.values.PhoneNumber;

public class UpdatedPhoneNumberAccount extends DomainEvent {
    private final AccountId accountId;
    private final PhoneNumber phoneNumber;

    public UpdatedPhoneNumberAccount(AccountId accountId, PhoneNumber phoneNumber) {
        super("sofka.guest.updatedPhoneNumberAccount");
        this.accountId = accountId;
        this.phoneNumber = phoneNumber;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
