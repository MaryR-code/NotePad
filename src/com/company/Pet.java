package com.company;

public class Pet extends Record {

    private String name;
    private SpeciesType species;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpeciesType getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesType speciesType) {
        this.species = speciesType;
    }

    @Override
    public void askData() {
        name = InputUtils.askString("Enter name");
        species = InputUtils.askSpecies("Enter species");
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. name: %s, species: %s", str, name, species.toString().toLowerCase());
    }
}
