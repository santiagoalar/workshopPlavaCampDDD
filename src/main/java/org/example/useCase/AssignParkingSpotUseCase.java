package org.example.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.AssignParkingSpot;

public class AssignParkingSpotUseCase extends UseCase<RequestCommand<AssignParkingSpot>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignParkingSpot> assignParkingSpotRequestCommand) {

        var command = assignParkingSpotRequestCommand.getCommand();

        var entryCard = EntryCard.from(command.getEntryCardId(), retrieveEvents(command.getEntryCardId().value()));
        entryCard.assignParkingSpot(command.getEntryCardId(), command.getParkingSpotId());

        var entryCardParkingSpotSize = entryCard.getParkingSpotIds().size();

        if (entryCardParkingSpotSize > 3){
            throw new BusinessException(command.getEntryCardId().value(),"The maximum of parking spot for entryCard is 3");
        }

        emit().onResponse(new ResponseEvents(entryCard.getUncommittedChanges()));
    }
}
