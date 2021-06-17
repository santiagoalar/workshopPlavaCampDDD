package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;

public class CreateAccount implements Command {

    private final AccountId accountId;
    private final Name name;
    private final Age age;
    private final Email email;
    private final PhoneNumber phoneNumber;

    public CreateAccount(AccountId accountId, Name name, Age age, Email email, PhoneNumber phoneNumber) {
        this.accountId = accountId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public Email getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
