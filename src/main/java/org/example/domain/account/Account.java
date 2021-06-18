package org.example.domain.account;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.events.*;
import org.example.domain.account.factory.GuestFactory;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Account extends AggregateEvent<AccountId> {

    protected Name name;
    protected Age age;
    protected Email email;
    protected PhoneNumber phoneNumber;
    //protected BraceletId braceletId;
    protected Set<Guest> guests;
    protected Set<HealthCare> healthCares;
    protected Set<Bracelet> bracelets;

    //public Account(AccountId accountId) {
    public Account(AccountId accountId, Name name, Age age, Email email, PhoneNumber phoneNumber) {
        super(accountId);
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        appendChange(new CreatedAccount(accountId, name, age, email, phoneNumber));
        //appendChange(new CreatedAccount(accountId));
    }

    private Account(AccountId accountId){
        super(accountId);
        subscribe(new OnChangeAccount(this));
    }

    //Permite obtener un agregado que ya está persistido
    public static Account from(AccountId accountId, List<DomainEvent> events){
        var account = new Account(accountId);
        events.forEach(account::applyEvent);
        return account;
    }

    public void updateName(Name name){
        appendChange(new UpdatedName(name)).apply();
    }

    public void updateAge(Age age){
        appendChange(new UpdatedAge(age)).apply();
    }

    public void updateEmail(Email email){
        appendChange(new UpdatedEmail(email)).apply();
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber){
        appendChange(new UpdatedPhoneNumber(phoneNumber)).apply();
    }

    public void addBracelet(BraceletId braceletId, Color color, Size size){
        appendChange(new BraceletAdded(braceletId, color, size)).apply();
    }

    public void addGuest(AccountId accountId, GuestId guestId, Name name, Age age, BloodType bloodType){
    //public void addGuest(AccountId accountId, GuestFactory guestFactory){
        appendChange(new GuestAdded(accountId, guestId, name, age, bloodType));
        //appendChange(new GuestsAdded(accountId, guestFactory));
    }

    public void updateNameGuest(GuestId guestId, Name name){
        appendChange(new UpdatedNameGuest(guestId, name)).apply();
    }

    public void updateAgeGuest(GuestId guestId, Age age){
        appendChange(new UpdatedAgeGuest(guestId, age)).apply();
    }

    public void updateBloodTypeGuest(GuestId guestId, BloodType bloodType){
        appendChange(new UpdatedBloodTypeGuest(guestId, bloodType)).apply();
    }

    public void deleteGuest(AccountId accountId, GuestId guestId){
        appendChange(new GuestDeleted(accountId, guestId)).apply();
    }

    public void addHealthCare(HealthCareId healthCareId,
                              Name name,
                              Address address,
                              OrganizationName organizationName){
        appendChange(new HealthCareAdded(healthCareId, name, address, organizationName)).apply();
    }

    public Optional<Guest> getGuestById(GuestId guestId){
        return guests()
                .stream()
                .filter(guest -> guest.identity().equals(guestId))
                .findFirst();
    }

    public Optional<HealthCare> getHealthCareById(HealthCareId healthCareId){
        return healthCares()
                .stream()
                .filter(healthCare -> healthCare.identity().equals(healthCareId))
                .findFirst();
    }

    public Optional<Bracelet> getBraceletById(BraceletId braceletId){
        return bracelets()
                .stream()
                .filter(bracelet -> bracelet.identity().equals(braceletId))
                .findFirst();
    }

    public Name name() {
        return name;
    }

    public Age age() {
        return age;
    }

    public Email email() {
        return email;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public Set<Guest> guests() {
        return guests;
    }

    public Set<HealthCare> healthCares() {
        return healthCares;
    }

    public Set<Bracelet> bracelets() {
        return bracelets;
    }
}
