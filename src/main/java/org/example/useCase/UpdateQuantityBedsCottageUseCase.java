package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.UpdateQuantityBedsCottage;

public class UpdateQuantityBedsCottageUseCase extends UseCase<RequestCommand<UpdateQuantityBedsCottage>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateQuantityBedsCottage> updateQuantityBedsCottageRequestCommand) {
        var command = updateQuantityBedsCottageRequestCommand.getCommand();
        var entryCard = EntryCard.from(command.getEntryCardId(), retrieveEvents(command.getEntryCardId().value()));
        entryCard.updateQuantityBedsCottage(command.getEntryCardId(), command.getCottageId(), command.getQuantityBeds());

        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
