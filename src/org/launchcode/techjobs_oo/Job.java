package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location,
               PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    // custom equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // custom toString method

    @Override
    public String toString() {
        String name;
        String employer;
        String location;
        String positionType;
        String coreCompetency;

        // check if all fields are null
        if (getName() == null &&
                getEmployer() == null &&
                getLocation() == null &&
                getPositionType() == null &&
                getCoreCompetency() == null
        ) {
            return "\nThis job does not seem to exist.\n";
        }

        // check if individual fields are empty
        if (getName() == "" || getName() == null) {
            name = "Data not available";
        } else {
            name = getName();
        }
        if (getEmployer().getValue() == null) {
            employer = "Data not available";
        } else {
            employer = getEmployer().getValue();
        }
        if (getLocation().getValue() == null) {
            location = "Data not available";
        } else {
            location = getLocation().getValue();
        }
        if (getPositionType().getValue() == null) {
            positionType = "Data not available";
        } else {
            positionType = getPositionType().getValue();
        }
        if (getCoreCompetency().getValue() == null) {
            coreCompetency = "Data not available";
        } else {
            coreCompetency = getCoreCompetency().getValue();
        }

        return "\nID: " + getId() +
                "\nName: " + name +
                "\nEmployer: " + employer +
                "\nLocation: " + location +
                "\nPosition Type: " + positionType +
                "\nCore Competency: " + coreCompetency +
                "\n";
    }
}
