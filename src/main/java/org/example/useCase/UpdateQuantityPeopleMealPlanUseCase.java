package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.UpdateQuantityPeopleMealPlan;

public class UpdateQuantityPeopleMealPlanUseCase extends UseCase<RequestCommand<UpdateQuantityPeopleMealPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateQuantityPeopleMealPlan> updateQuantityPeopleMealPlanRequestCommand) {
        var command = updateQuantityPeopleMealPlanRequestCommand.getCommand();
        var entryCard = EntryCard.from(command.getEntryCardId(), retrieveEvents(command.getEntryCardId().value()));
        entryCard.updateQuantityPeopleMealPlan(command.getEntryCardId(), command.getMealPlanId(), command.getQuantityPeople());

        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
