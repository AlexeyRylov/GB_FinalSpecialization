package BusinessLogic.Nursery.DeleteAnimal;

import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;
import View.Consoles.ConsolePrinterOne;

import java.util.Scanner;

public class SelectAnimalOfKey {
    private NurseryOne<HumanFriend> humanFriendNurseryOne;
    private HumanFriend humanFriend;

    public SelectAnimalOfKey(NurseryOne<HumanFriend> humanFriendNurseryOne) {
        this.humanFriendNurseryOne = humanFriendNurseryOne;
    }

    public void select() {
        Scanner scanner = new Scanner(System.in);
        ConsolePrinterOne.print("Введите ключ животного для удаления: ");
        String input = scanner.nextLine();
        if (humanFriendNurseryOne.getAllAnimals().containsKey(input.strip())) {
            this.humanFriend = humanFriendNurseryOne.getAllAnimals().get(input);
        } else {
            ConsolePrinterOne.print("Животное не найдено.");
        }
    }

    public NurseryOne<HumanFriend> getHumanFriendNurseryOne() {
        return humanFriendNurseryOne;
    }

    public HumanFriend getHumanFriend() {
        return humanFriend;
    }

}