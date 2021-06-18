package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.PhoneNumber;

public class UpdatePhoneNumber implements Command {

    private final AccountId accountId;
    private final PhoneNumber phoneNumber;

    public UpdatePhoneNumber(AccountId accountId, PhoneNumber phoneNumber) {
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
