package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.AccountId;
import org.example.genericValues.Name;

public class UpdatedNameAccount extends DomainEvent {

    private final AccountId accountId;
    private final Name name;

    public UpdatedNameAccount(AccountId accountId, Name name) {
        super("sofka.guest.updatedNameAccount");
        this.accountId = accountId;
        this.name = name;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Name getName() {
        return name;
    }
}
