package org.example.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.commands.AddGuest;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.events.GuestAdded;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddGuestUseCaseTest {

    private AddGuestUseCase addGuestUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        addGuestUseCase = new AddGuestUseCase();
    }

    @Test
    void createGoodPath(){
        //Arrange
        var accountId = AccountId.of("F-5985");

        var command = new AddGuest(accountId,
                GuestId.of("123"),
                new Name("Tonio"),
                new Age("23"),
                new BloodType("0+"));

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedAccount(
                        accountId,
                        new Name("Ant"),
                        new Age("32"),
                        new Email("ant@mail.com"), new PhoneNumber("3125669856")
                )));

        addGuestUseCase.addRepository(repository);

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(accountId.value())
                .syncExecutor(addGuestUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        GuestAdded guestAdded = (GuestAdded) events.get(0);

        Assertions.assertEquals("123", guestAdded.getGuestId().value());
        Assertions.assertEquals("Tonio", guestAdded.getName().value());
        Assertions.assertEquals("23", guestAdded.getAge().value());
        Assertions.assertEquals("0+", guestAdded.getBloodType().value());
    }

    @Test
    void addGuestBadPath(){
        //Arrange
        var accountId = AccountId.of("F-5985");

        var command = new AddGuest(accountId,
                GuestId.of("123"),
                new Name("Tonio"),
                new Age("23"),
                new BloodType("0+"));

        when(repository.getEventsBy(anyString())).thenReturn(events(accountId));

        addGuestUseCase.addRepository(repository);

        //Act & Assert
        var response = Assertions.assertThrows(BusinessException.class,()->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(accountId.value())
                    .syncExecutor(addGuestUseCase, new RequestCommand<>(command)).orElseThrow();
        });

        Assertions.assertEquals("Maximum of guest by on account is 10", response.getMessage());
    }

    private List<DomainEvent> events(AccountId accountId) {
        return List.of(
                new CreatedAccount(
                        accountId,
                        new Name("Ant"),
                        new Age("32"),
                        new Email("ant@mail.com"),
                        new PhoneNumber("3125669856")),
                new GuestAdded( accountId, GuestId.of("0"), new Name("A"), new Age("10"), new BloodType("0+")),
                new GuestAdded( accountId, GuestId.of("1"), new Name("B"), new Age("25"), new BloodType("A+")),
                new GuestAdded( accountId, GuestId.of("2"), new Name("C"), new Age("36"), new BloodType("0+")),
                new GuestAdded( accountId, GuestId.of("3"), new Name("D"), new Age("23"), new BloodType("A+")),
                new GuestAdded( accountId, GuestId.of("4"), new Name("E"), new Age("19"), new BloodType("A+")),
                new GuestAdded( accountId, GuestId.of("5"), new Name("F"), new Age("27"), new BloodType("0-")),
                new GuestAdded( accountId, GuestId.of("6"), new Name("G"), new Age("23"), new BloodType("A+")),
                new GuestAdded( accountId, GuestId.of("7"), new Name("H"), new Age("29"), new BloodType("AB+")),
                new GuestAdded( accountId, GuestId.of("8"), new Name("I"), new Age("30"), new BloodType("0+")),
                new GuestAdded( accountId, GuestId.of("9"), new Name("J"), new Age("24"), new BloodType("0+")),
                new GuestAdded( accountId, GuestId.of("10"), new Name("K"), new Age("14"), new BloodType("0+"))
        );
    }
}