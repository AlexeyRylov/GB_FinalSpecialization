package BusinessLogic.Nursery.ShowAllAnimals;

import Models.Abstract.Animals.HumanFriend;
import View.Consoles.ConsolePrinterOne;


import java.util.HashMap;


public class ShowAllAnimalsOne<T extends HumanFriend> {
    private HashMap<String,T> allAnimals;

    public ShowAllAnimalsOne(HashMap<String, T> allAnimals) {
        this.allAnimals = allAnimals;
        showAll();
    }

    public void showAll() {
        ConsolePrinterOne.print("\n");
        for (String animal:
                this.allAnimals.keySet()) {
            ConsolePrinterOne.print(animal + " :");
            ConsolePrinterOne.print((allAnimals.get(animal).toString()));
        }
    }
}