package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.values.EntryCardId;

public class AssignAccount implements Command {

    private final EntryCardId entryCardId;
    private final AccountId accountId;

    public AssignAccount(EntryCardId entryCardId, AccountId accountId) {
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
