package Controllers.Consoles;

import BusinessLogic.Nursery.AddNewAnimal.AddNewAnimal;
import BusinessLogic.Nursery.DeleteAnimal.DeleteAnimal;
import BusinessLogic.Nursery.ShowAllAnimals.ShowAllAnimalsOne;
import BusinessLogic.Nursery.ShowStudiedCommands.SearchAnimal.SearchAnimalOfName;
import BusinessLogic.Nursery.ShowStudiedCommands.SearchAnimal.ShowFinderAnimals;
import BusinessLogic.Nursery.TeacherOfNewCommands.TeacherOfAnimalCommands;
import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;
import View.Consoles.ConsolePrinterOne;
import View.UiConsole.UI;

import java.util.Scanner;

public class ConsoleControllerOne {
    private NurseryOne<HumanFriend> nurseryOne;

    public ConsoleControllerOne() {
        this.nurseryOne = new NurseryOne<>();
    }

    public void runApplication() {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputUser;
            boolean flag = true;
            while (flag) {
                ConsolePrinterOne.print(UI.firstMenu);
                inputUser = scanner.nextLine().strip();
                if (inputUser.equals("1")) {
                    if (nurseryOne.getAllAnimals() == null || nurseryOne.getAllAnimals().isEmpty()) {
                        ConsolePrinterOne.print("Ваш питомник пуст!");
                    } else {
                        new ShowAllAnimalsOne<>(nurseryOne.getAllAnimals());
                    }
                } else if (inputUser.equals("2")) {
                    new AddNewAnimal<>(this.nurseryOne);
                } else if (inputUser.equals("3")) {
                    ShowFinderAnimals.show(SearchAnimalOfName.searchOfName(this.nurseryOne));
                } else if (inputUser.equals("4")) {
                    new TeacherOfAnimalCommands(this.nurseryOne);
                } else if (inputUser.equals("5")) {
                    new DeleteAnimal(this.nurseryOne);
                } else if (inputUser.equals("6")) {
                    flag = false;
                    scanner.close();
                } else {
                    ConsolePrinterOne.print("Не известный выбор, всего предусмотрено 7 позиций развития событий.");
                }
            }
        } catch (RuntimeException exception) {
            exception.getMessage();
            exception.fillInStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}