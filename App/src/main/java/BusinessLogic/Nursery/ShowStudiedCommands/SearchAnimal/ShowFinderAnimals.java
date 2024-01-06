package BusinessLogic.Nursery.ShowStudiedCommands.SearchAnimal;

import Models.Abstract.Animals.HumanFriend;
import View.Consoles.ConsolePrinterOne;

import java.util.ArrayList;

public class ShowFinderAnimals {
    public static void show(ArrayList<HumanFriend> humanFriends) {
        if (humanFriends.size() == 0) {
            ConsolePrinterOne.print("Нет совпадений");
        } else {
            for (HumanFriend animal:
                    humanFriends) {
                ConsolePrinterOne.print(animal.getKey() + " :");
                ConsolePrinterOne.print((animal.getStudiedСommands().toString()));
            }
        }
    }
}