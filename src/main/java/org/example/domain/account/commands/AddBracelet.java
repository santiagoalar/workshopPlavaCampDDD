package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.BraceletId;

public class AddBracelet implements Command {

    private final BraceletId braceletId;
    private final AccountId accountId;

    public AddBracelet(BraceletId braceletId, AccountId accountId) {
        this.braceletId = braceletId;
        this.accountId = accountId;
    }

    public BraceletId getBraceletId() {
        return braceletId;
    }

    public AccountId getAccountId() {
        return accountId;
    }
}
