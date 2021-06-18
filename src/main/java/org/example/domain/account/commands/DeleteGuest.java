package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.GuestId;

public class DeleteGuest implements Command {

    private final AccountId accountId;
    private final GuestId guestId;

    public DeleteGuest(AccountId accountId, GuestId guestId) {
        this.accountId = accountId;
        this.guestId = guestId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public GuestId getGuestId() {
        return guestId;
    }
}
