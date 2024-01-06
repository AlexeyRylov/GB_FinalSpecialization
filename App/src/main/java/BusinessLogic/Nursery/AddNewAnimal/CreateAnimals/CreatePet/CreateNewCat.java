package BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePet;

import BusinessLogic.Nursery.Counter.Counter;
import Models.Abstract.Animals.HumanFriend;
import Models.Animals.Pet.Cat;
import Models.Animals.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreateNewCat {
    private HumanFriend animal;
    private int energy = 40;
    private int weight = 4;
    private int loves = 75;


    public CreateNewCat() {
        this.animal = createCat();
    }

    public HumanFriend getAnimal() {
        return animal;
    }

    private Cat createCat() {
        String name;
        Date date2;
        String weights;
        String favoriteFood;
        String favoriteToy;
        String color;
        String whoIsHePlayingWith;
        try (Counter counter = new Counter()) {
            boolean dataFalse = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите имя: ");
            name = scanner.nextLine();
            System.out.println("Введите дату рождения: dd-mm-yyyy ");
            String date = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date2 = null;
            try {
                //Parsing the String
                date2 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                dataFalse = true;
            }
            System.out.println("введите вес");
            weights = scanner.next();
            try {
                weight = Integer.parseInt(weights);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }

            System.out.println("введите цвет животного");
            color = scanner.next();

            System.out.println("введите любимое блюдо животного");
            favoriteFood = scanner.next();

            System.out.println("введите любимую игрушку животного");
            favoriteToy = scanner.next();


            System.out.println("Введите имя с кем любит играть кот? ");
            whoIsHePlayingWith = scanner.next();

            if (name == null || name.equals("") || dataFalse|| weight <= 0 || color == null || favoriteFood == null || favoriteFood.equals("") || favoriteToy == null|| favoriteToy.equals("")  || whoIsHePlayingWith == null) {
                throw new Exception("неправильная инициализация котика");
            } else {
                counter.add();
            }
            return new Cat("Cat" + Counter.getCountAnimals(), name, date2, energy, weight, Type.Pet, whoIsHePlayingWith, loves, favoriteFood, favoriteToy, color);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}