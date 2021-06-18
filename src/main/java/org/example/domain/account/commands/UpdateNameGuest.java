package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.GuestId;
import org.example.genericValues.Name;

public class UpdateNameGuest implements Command {

    private final AccountId accountId;
    private final GuestId guestId;
    private final Name name;

    public UpdateNameGuest(AccountId accountId, GuestId guestId, Name name) {
        this.accountId = accountId;
        this.guestId = guestId;
        this.name = name;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public Name getName() {
        return name;
    }
}
