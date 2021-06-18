package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Age;

public class UpdateAge implements Command {

    private final AccountId accountId;
    private final Age age;

    public UpdateAge(AccountId accountId, Age age) {
        this.accountId = accountId;
        this.age = age;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Age getAge() {
        return age;
    }
}
