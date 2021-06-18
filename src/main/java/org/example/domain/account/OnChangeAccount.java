package org.example.domain.account;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.account.events.*;

import java.util.HashSet;

public class OnChangeAccount extends EventChange {
    public OnChangeAccount(Account account) {

        //Here add all domain rules

        apply((CreatedAccount event)->{
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
            account.guests.add(new Guest(event.getGuestId(),
                    event.getName(),
                    event.getAge(),
                    event.getBloodType()));
        });

        apply((GuestDeleted event)->{
            account.guests.remove(event.getAccountId());
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
