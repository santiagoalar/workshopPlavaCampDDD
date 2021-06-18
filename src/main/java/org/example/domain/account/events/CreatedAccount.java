package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.Email;
import org.example.domain.account.values.PhoneNumber;
import org.example.genericValues.Name;

public class CreatedAccount extends DomainEvent {

    private final AccountId accountId;
    private final Name name;
    private final Age age;
    private final Email email;
    private final PhoneNumber phoneNumber;

    public CreatedAccount(AccountId accountId, Name name, Age age, Email email, PhoneNumber phoneNumber) {
        super("plavaCamp.account.createdAccount");
        this.accountId = accountId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public AccountId getAccountId() {
        return accountId;
    }
}
