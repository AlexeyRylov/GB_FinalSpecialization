package BusinessLogic.Nursery.AddNewAnimal.CreateAnimals;

import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePackAnimals.CreateNewCamel;
import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePackAnimals.CreateNewDonkey;
import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePackAnimals.CreateNewHorse;
import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePet.CreateNewCat;
import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePet.CreateNewDog;
import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePet.CreateNewHamster;
import Models.Abstract.Animals.HumanFriend;
import View.Consoles.ConsolePrinterOne;

import java.util.Scanner;

public class CreateNewAnimal {
    private HumanFriend humanFriend;

    public CreateNewAnimal() throws Exception {
        createNewAnimal();
    }

    public HumanFriend getHumanFriend() {
        return humanFriend;
    }

    public void createNewAnimal() throws Exception{
        Scanner scanner = new Scanner(System.in);
        ConsolePrinterOne.print("Укажите род животного: (camel,cat ...)");
        String genus = scanner.nextLine();
        while (true) {
            if (genus.toLowerCase().contains("horse")) {
                humanFriend = new CreateNewHorse().getAnimal();
                break;
            } else if (genus.toLowerCase().contains("donkey")) {
                humanFriend = new CreateNewDonkey().getAnimal();
                break;
            } else if (genus.toLowerCase().contains("camel")) {
                humanFriend = new CreateNewCamel().getAnimal();
                break;
            } else if (genus.toLowerCase().contains("cat")) {
                humanFriend = new CreateNewCat().getAnimal();
                break;
            } else if (genus.toLowerCase().contains("dog")) {
                humanFriend = new CreateNewDog().getAnimal();
                break;
            } else if (genus.toLowerCase().contains("hamster")) {
                humanFriend = new CreateNewHamster().getAnimal();
                break;
            } else {
                ConsolePrinterOne.print("Животное такого рода нам пока не известно");
            }
        }
    }
}