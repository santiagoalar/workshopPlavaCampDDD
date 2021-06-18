package org.example.domain.account.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;

public class AddHealthCare implements Command {

    private final AccountId accountId;
    private final HealthCareId healthCareId;
    private final Name name;
    private final Age age;
    private final BloodType bloodType;

    public AddHealthCare(AccountId accountId, HealthCareId healthCareId, Name name, Age age, BloodType bloodType) {
        this.accountId = accountId;
        this.healthCareId = healthCareId;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public HealthCareId getHealthCareId() {
        return healthCareId;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
