package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.CreateEntryCard;

public class CreateEntryCardUseCase extends UseCase<RequestCommand<CreateEntryCard>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateEntryCard> createEntryCardRequestCommand) {
        var command = createEntryCardRequestCommand.getCommand();
        EntryCard entryCard = new EntryCard(command.getEntryCardId(), command.getAccountId());

        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
