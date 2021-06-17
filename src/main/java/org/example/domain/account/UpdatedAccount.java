package org.example.domain.account;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.account.events.*;
import org.example.domain.account.values.Bracelet;
import org.example.domain.account.values.Guest;
import org.example.domain.account.values.HealthCare;

import java.util.HashSet;

public class UpdatedAccount extends EventChange {
    public UpdatedAccount(Account account) {

        //Here add all domain rules

        apply((CreatedAccount event)->{
            account.name = event.getName();
            account.age = event.getAge();
            account.email = event.getEmail();
            account.phoneNumber = event.getPhoneNumber();
            account.guests = new HashSet<>();
            account.bracelets = new HashSet<>();
            account.healthCares = new HashSet<>();
        });

        apply((UpdatedName event)->{
            account.name = event.getName();
        });

        apply((UpdatedAge event)->{
            account.age = event.getAge();
        });

        apply((UpdatedEmail event)->{
            account.email = event.getEmail();
        });

        apply((UpdatedPhoneNumber event)->{
            account.phoneNumber = event.getPhoneNumber();
        });

        apply((UpdatedNameGuest event)->{
            var guest = account.getGuestById(event.getGuestId())
                    .orElseThrow(()-> new IllegalArgumentException("Guest was not founded"));
            guest.updateName(guest.name());
        });

        apply((UpdatedAgeGuest event)->{
            var guest = account.getGuestById(event.getGuestId()).orElseThrow();
            guest.updateAge(guest.age());
        });

        apply((UpdatedBloodTypeGuest event)->{
            var guest = account.getGuestById(event.getGuestId()).orElseThrow();
            guest.updateBloodyType(guest.bloodType());
        });

        apply((GuestAdded event)->{
            var guestsSize = account.guests.size();
            if(guestsSize>8){
                throw new IllegalArgumentException("Guests cannot be grater then 8 for one account");
            }
            account.guests.add(new Guest(event.getGuestId(),
                    event.getName(),
                    event.getAge(),
                    event.getBloodType()));
        });

        apply((BraceletAdded event)->{
            //no rules
            account.bracelets.add(new Bracelet(event.getBraceletId(),
                    event.getColor(),
                    event.getSize()));
        });

        apply((HealthCareAdded event)->{
            //No rules
            account.healthCares.add(new HealthCare(event.getHealthCareId(),
                    event.getName(),
                    event.getAddress(),
                    event.getOrganizationName()));
        });

    }


}
