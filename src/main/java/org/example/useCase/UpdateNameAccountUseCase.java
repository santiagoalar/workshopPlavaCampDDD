package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.account.Account;
import org.example.domain.account.commands.UpdateName;

public class UpdateNameAccountUseCase extends UseCase<RequestCommand<UpdateName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateName> updateNameRequestCommand) {

        var command = updateNameRequestCommand.getCommand();
        var account = Account.from(command.getAccountId(), retrieveEvents());
        account.updateName(command.getName());

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}
