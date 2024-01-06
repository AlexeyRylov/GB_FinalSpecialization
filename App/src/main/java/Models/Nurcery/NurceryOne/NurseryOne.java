package Models.Nursery.NurseryOne;

import Models.Abstract.Animals.HumanFriend;

import java.util.HashMap;

public class NurseryOne<T extends HumanFriend> {
    private HashMap<String, T> allAnimals;


    public NurseryOne() {
        this.allAnimals = new HashMap<>();
    }

    public HashMap<String, T> getAllAnimals() {
        return allAnimals;
    }

}