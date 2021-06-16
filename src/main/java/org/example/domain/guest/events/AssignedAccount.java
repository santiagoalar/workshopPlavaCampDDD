package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.AccountId;

public class AssignedAccount extends DomainEvent {

    private final AccountId accountId;

    public AssignedAccount(AccountId accountId) {
        super("sofka.guest.assignedAccount");
        this.accountId = accountId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

}
