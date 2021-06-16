package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.HealthCareId;

public class AssignedHealthCare extends DomainEvent {

    private final HealthCareId healthCareId;

    public AssignedHealthCare(HealthCareId healthCareId) {
        super("sofka.guest.assignedHealthCare");
        this.healthCareId = healthCareId;
    }

    public HealthCareId getHealthCareId() {
        return healthCareId;
    }
}
