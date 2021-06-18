package org.example.domain.entryCard;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.entryCard.events.CreatedEntryCard;

public class OnChangeEntryCard extends EventChange {

    public OnChangeEntryCard(EntryCard entryCard){
        apply((CreatedEntryCard event)->{
            entryCard.accountId = event.getAccountId();
        });

        ;
    }
}
