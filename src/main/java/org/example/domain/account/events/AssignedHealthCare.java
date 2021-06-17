package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.HealthCareId;

public class AssignedHealthCare extends DomainEvent {

    private final HealthCareId healthCareId;

    public AssignedHealthCare(HealthCareId healthCareId) {
        super("sofka.account.assignedHealthCare");
        this.healthCareId = healthCareId;
    }

    public HealthCareId getHealthCareId() {
        return healthCareId;
    }
}
