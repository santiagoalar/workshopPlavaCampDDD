package org.example.domain.account;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;

public class Account extends AggregateEvent<AccountId> {
    public Account(AccountId accountId, Name name, Age age, Email email, PhoneNumber phoneNumber) {
        super(accountId);
        appendChange(new CreatedAccount(name, age, email, phoneNumber));
    }

    public void updateName(Name name){

    }

    public void updateAge(Age age){

    }

    public void updateEmail(Email email){

    }

    public void updatePhoneNumber(PhoneNumber phoneNumber){

    }

    public void assignBracelet(){

    }

    public void assignAccount(){

    }

    public void updateNameAccount(){

    }

    public void updateAddressAccount(){

    }

    public void updatePhoneNumberAccount(){

    }

    public void assignHealthCare(){

    }
}
