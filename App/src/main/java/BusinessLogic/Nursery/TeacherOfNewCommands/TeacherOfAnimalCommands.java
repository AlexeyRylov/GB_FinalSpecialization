package BusinessLogic.Nursery.TeacherOfNewCommands;

import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;
import View.Consoles.ConsolePrinterOne;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TeacherOfAnimalCommands {
    private NurseryOne<HumanFriend> nurseryOne;

    public TeacherOfAnimalCommands(NurseryOne<HumanFriend> nurseryOne) {
        this.nurseryOne = nurseryOne;
        study();
    }

    public void study() {
        Scanner scanner = new Scanner(System.in);
        ConsolePrinterOne.print("Введите уникальный ключ животного для его обучения");
        String uInput = scanner.nextLine().strip();
        HumanFriend humanFriend = SelectAnimalOfTheKey.selectAnimal(uInput, nurseryOne);
        if (humanFriend != null) {
            ConsolePrinterOne.print("Введите новую команду: ");
            String command = scanner.nextLine();
            ConsolePrinterOne.print("Укажите что должно делать животное (коротко): ");
            String action = scanner.nextLine();
            Map<String,String> temp =new HashMap<>();
            temp.putAll(humanFriend.getStudiedСommands());
            temp.put(command,action);
            humanFriend.setStudiedСommands(temp);
        } else {
            ConsolePrinterOne.print("Такого животного пока нет =(");
        }

    }
}