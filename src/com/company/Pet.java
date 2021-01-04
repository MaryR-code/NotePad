package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

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
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. name: %s; species: %s", str, name, species.toString().toLowerCase());
    }

    @Override
    public void askData() {
        name = InputUtils.askString("Enter name");
        OutputUtils.showHelp(3);
        var strType = InputUtils.askString("Enter species");
        species = SpeciesType.valueOf(strType);
    }

    @Override
    public void saveRecord(PrintWriter out) {
        super.saveRecord(out);
        out.println(name);
        out.println(species);
    }

    @Override
    public void loadRecord(Scanner in) {
        super.loadRecord(in);
        name = in.next();
        species = SpeciesType.valueOf(in.next());
    }
}
