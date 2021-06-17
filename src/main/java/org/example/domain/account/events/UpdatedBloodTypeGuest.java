package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.BloodType;
import org.example.domain.account.values.PhoneNumber;

public class UpdatedBloodTypeGuest extends DomainEvent {
    private final AccountId accountId;
    private final BloodType bloodType;

    public UpdatedBloodTypeGuest(AccountId accountId, BloodType bloodType) {
        super("sofka.account.updatedBloodTypeAccount");
        this.accountId = accountId;
        this.bloodType = bloodType;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
