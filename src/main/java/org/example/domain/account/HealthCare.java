package org.example.domain.account;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.account.values.Address;
import org.example.domain.account.values.HealthCareId;
import org.example.domain.account.values.OrganizationName;
import org.example.genericValues.Name;

public class HealthCare extends Entity<HealthCareId> {

    private Name name;
    private Address address;
    private OrganizationName organizationName;

    public HealthCare(HealthCareId entityId, Name name, Address address, OrganizationName organizationName) {
        super(entityId);
        this.name = name;
        this.address = address;
        this.organizationName = organizationName;
    }

    public void updateName(Name name){
        this.name = name;
    }

    private void updateAddress(Address address){
        this.address = address;
    }

    private void updateOrganizationName(OrganizationName organizationName){
        this.organizationName = organizationName;
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
