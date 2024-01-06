package BusinessLogic.Nursery.ChangeOfGender;

import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;
import View.Consoles.ConsolePrinterOne;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelectOfKey {
    private NurseryOne<HumanFriend> humanFriendNurseryOne;
    private final List<String> gender = Arrays.asList("horse","cat","dog","hamster","donkey","camel");

    public SelectOfKey(NurseryOne<HumanFriend> humanFriendNurseryOne) {
        this.humanFriendNurseryOne = humanFriendNurseryOne;
    }

    private void change() {
        Scanner scanner = new Scanner(System.in);
        ConsolePrinterOne.print("Введите ключ животного, у которого собираетесь изменить род");
        String input = scanner.nextLine();
        if (humanFriendNurseryOne.getAllAnimals().containsKey(input)) {

        }
    }
}