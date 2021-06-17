package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.Address;
import org.example.domain.account.values.HealthCareId;
import org.example.domain.account.values.OrganizationName;
import org.example.genericValues.Name;

public class HealthCareAdded extends DomainEvent {

    private final HealthCareId healthCareId;
    private final Name name;
    private final Address address;
    private final OrganizationName organizationName;

    public HealthCareAdded(HealthCareId healthCareId, Name name,
                           Address address,
                           OrganizationName organizationName) {
        super("plavaCamp.account.healthCareAdded");
        this.healthCareId = healthCareId;
        this.name = name;
        this.address = address;
        this.organizationName = organizationName;
    }

    public HealthCareId getHealthCareId() {
        return healthCareId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public OrganizationName getOrganizationName() {
        return organizationName;
    }
}
