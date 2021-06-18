package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.GuestId;

public class UpdateAgeGuest implements Command {

    private final AccountId accountId;
    private final GuestId guestId;
    private final Age age;

    public UpdateAgeGuest(AccountId accountId, GuestId guestId, Age age) {
        this.accountId = accountId;
        this.guestId = guestId;
        this.age = age;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public Age getAge() {
        return age;
    }
}
