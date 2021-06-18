package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.AssignCottage;

public class AssignCottageUseCase extends UseCase<RequestCommand<AssignCottage>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignCottage> assignCottageRequestCommand) {
        var command = assignCottageRequestCommand.getCommand();
        var entryCard = EntryCard.from(command.getEntryCardId(), retrieveEvents(command.getEntryCardId().value()));

        entryCard.assignCottage(command.getEntryCardId(), command.getCottageId());
        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
