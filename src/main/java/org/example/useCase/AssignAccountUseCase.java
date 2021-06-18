package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.AssignAccount;

public class AssignAccountUseCase extends UseCase<RequestCommand<AssignAccount>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignAccount> assignAccountRequestCommand) {
        var command = assignAccountRequestCommand.getCommand();
        var entryCard = EntryCard.from(command.getEntryCardId(), retrieveEvents(command.getEntryCardId().value()));
        entryCard.assignAccount(command.getEntryCardId(), command.getAccountId());

        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
