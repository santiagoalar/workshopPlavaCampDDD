package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.genericValues.Name;

public class UpdateName implements Command {

    private final AccountId accountId;
    private final Name name;

    public UpdateName(AccountId accountId, Name name) {
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
