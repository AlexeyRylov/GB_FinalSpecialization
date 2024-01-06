package BusinessLogic.Nursery.ShowStudiedCommands.SearchAnimal;

import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;
import View.Consoles.ConsolePrinterOne;
import View.UiConsole.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchAnimalOfName {
    public static ArrayList<HumanFriend> searchOfName(NurseryOne<HumanFriend> humanFriendNurseryOne) {
        Scanner scanner = new Scanner(System.in);
        ConsolePrinterOne.print(UI.enterNameAnimal);
        String inputName = scanner.nextLine();
        ArrayList<HumanFriend> humanFriends = new ArrayList<>();
        for (HumanFriend humanFriend:
                humanFriendNurseryOne.getAllAnimals().values()) {
            if (humanFriend.getName().equalsIgnoreCase(inputName.strip().toLowerCase())) {
                humanFriends.add(humanFriend);
            }
        }
        return humanFriends;
    }
}