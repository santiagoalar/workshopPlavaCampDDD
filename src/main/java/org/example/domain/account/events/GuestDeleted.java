package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.GuestId;

public class GuestDeleted extends DomainEvent {

    private final AccountId accountId;
    private final GuestId guestId;

    public GuestDeleted(AccountId accountId, GuestId guestId) {
        super("plavaCamp.account.guestDeleted");
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
