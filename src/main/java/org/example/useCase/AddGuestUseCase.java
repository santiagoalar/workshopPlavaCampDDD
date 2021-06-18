package org.example.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.account.Account;
import org.example.domain.account.commands.AddGuest;

public class AddGuestUseCase extends UseCase<RequestCommand<AddGuest>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddGuest> addGuestRequestCommand) {
        var command = addGuestRequestCommand.getCommand();
        var account = Account.from(command.getAccountId(), retrieveEvents(command.getGuestId().value()));
        account.addGuest(command.getAccountId(), command.getGuestId(), command.getName(), command.getAge(), command.getBloodType());

        if(account.guests().size() > 10){
            throw new BusinessException(command.getGuestId().value(),"Maximum of guest by on account is 10");
        }

        emit().onResponse(new ResponseEvents((account.getUncommittedChanges())));
    }
}
