package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Email;

public class UpdateEmail implements Command {

    private final AccountId accountId;
    private final Email email;

    public UpdateEmail(AccountId accountId, Email email) {
        this.accountId = accountId;
        this.email = email;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Email getEmail() {
        return email;
    }
}
