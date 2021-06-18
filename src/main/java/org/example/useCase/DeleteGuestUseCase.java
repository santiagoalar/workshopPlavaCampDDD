package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.account.Account;
import org.example.domain.account.commands.DeleteGuest;

public class DeleteGuestUseCase extends UseCase<RequestCommand<DeleteGuest>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<DeleteGuest> deleteGuestRequestCommand) {
        var command = deleteGuestRequestCommand.getCommand();
        var account = Account.from(command.getAccountId(), retrieveEvents());
        account.deleteGuest(command.getAccountId(), command.getGuestId());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
