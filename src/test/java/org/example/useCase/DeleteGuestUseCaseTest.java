package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.commands.DeleteGuest;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.events.GuestAdded;
import org.example.domain.account.events.GuestDeleted;
import org.example.domain.account.factory.GuestFactory;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteGuestUseCaseTest {

    private  DeleteGuestUseCase deleteGuestUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        deleteGuestUseCase = new DeleteGuestUseCase();
    }

    @Test
    void createGoodPath(){

        //Arrange
        var accountId = AccountId.of("A-95685");
        var guestId = GuestId.of("G-2641256");
        var command = new DeleteGuest(accountId, guestId);

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedAccount(
                        accountId,
                        new Name("Alberto"),
                        new Age("32"),
                        new Email("ant@mail.com"),
                        new PhoneNumber("3125669856")
                ), new GuestAdded(accountId,
                        guestId,
                        new Name("Mariana"), new Age("23"), new BloodType("0+"))
        ));

        deleteGuestUseCase.addRepository(repository);

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(accountId.value())
                .syncExecutor(deleteGuestUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        GuestDeleted guestDeleted= (GuestDeleted) events.get(0);
        Assertions.assertEquals("G-2641256", guestDeleted.getGuestId().value());
    }



    private List<DomainEvent> eventStored(AccountId accountId) {

        var factory = GuestFactory.builder();
        factory.newGuest(GuestId.of("G-36598"),
                new Name("Carlos"),
                new Age("30"),
                new BloodType("A+"));

        factory.newGuest(GuestId.of("G-36599"),
                new Name("Mariana"),
                new Age("25"),
                new BloodType("0+"));

        var gues1 = new GuestAdded(accountId,
                GuestId.of("G-36599"),
                new Name("Mariana"), new Age("23"), new BloodType("0+"));

        return List.of(new CreatedAccount(
                accountId,
                new Name("Carlos"),
                new Age("30"),
                new Email("carlos@mail.com"),
                new PhoneNumber("3203659925")),
                new GuestAdded(accountId,
                GuestId.of("G-36599"),
                new Name("Mariana"), new Age("23"), new BloodType("0+"))
        );
        /*var factory = ProductosFactory.builder();
        factory.nuevoProducto(ProductoId.of("P-001"), new Precio(12000.0), new Cantidad(2));
        factory.nuevoProducto(ProductoId.of("P-002"), new Precio(13000.0), new Cantidad(1));

        return List.of(
                new FacturaCreada(facturaId),
                new TiendaAsignada(TiendaId.of("T-aaa"), new Descuento(50.0)),
                new ClienteAsignado(Cedula.of("1234"),new Nombre("LEO"), new Direccion("siempre viva")),
                new ProductosAsignados(facturaId, factory)
        );*/
    }


}