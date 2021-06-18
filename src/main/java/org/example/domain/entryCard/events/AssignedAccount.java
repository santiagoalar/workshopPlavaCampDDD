package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.values.EntryCardId;

public class AssignedAccount extends DomainEvent {

    private final AccountId accountId;
    private final EntryCardId entryCardId;

    public AssignedAccount(EntryCardId entryCardId, AccountId accountId) {
        super("plavaCamp.entryCard.assignedAccount");
        this.entryCardId = entryCardId;
        this.accountId = accountId;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

}
