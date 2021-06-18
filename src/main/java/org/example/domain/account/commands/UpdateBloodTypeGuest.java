package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.BloodType;
import org.example.domain.account.values.GuestId;

public class UpdateBloodTypeGuest implements Command {

    private final AccountId accountId;
    private final GuestId guestId;
    private final BloodType bloodType;

    public UpdateBloodTypeGuest(AccountId accountId, GuestId guestId, BloodType bloodType) {
        this.accountId = accountId;
        this.guestId = guestId;
        this.bloodType = bloodType;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
