package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.AssignMealPlan;

public class AssignMealPlanUseCase extends UseCase<RequestCommand<AssignMealPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignMealPlan> assignMealPlanRequestCommand) {
        var command = assignMealPlanRequestCommand.getCommand();
        var entryCard = EntryCard.from(command.getEntryCardId(), retrieveEvents(command.getEntryCardId().value()));
        entryCard.assignMealPlan(command.getEntryCardId(), command.getMealPlanId(), command.getIsVegetarian(), command.getQuantityPeople());

        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
