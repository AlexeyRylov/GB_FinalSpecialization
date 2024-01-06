package BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePet;

import BusinessLogic.Nursery.Counter.Counter;
import Models.Abstract.Animals.HumanFriend;
import Models.Animals.Pet.Hamster;
import Models.Animals.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreateNewHamster {
    private HumanFriend animal;
    private int energy = 99;
    private int weight = 1;
    private int loves = 45;
    private int timeMaxRun = 10;
    private int dictanceRun = 20;

    public CreateNewHamster() {
        this.animal = createHamster();
    }

    public HumanFriend getAnimal() {
        return animal;
    }

    private Hamster createHamster() {
        try (Counter counter = new Counter()) {
            boolean dateFalse = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите дату рождения: dd-mm-yyyy ");
            String date = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date2 = null;
            try {
                //Parsing the String
                date2 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                dateFalse = true;
            }
            System.out.println("введите вес");
            String weights = scanner.next();
            try {
                weight = Integer.parseInt(weights);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
            System.out.println("введите цвет животного");
            String color = scanner.next();

            System.out.println("введите любимое блюдо животного");
            String favoriteFood = scanner.next();

            System.out.println("введите любимую игрушку животного");
            String favoriteToy = scanner.next();


            System.out.println("Введите имя с кем любит играть кот? ");
            String whoIsHePlayingWith = scanner.next();

            System.out.println("Введите насколько вы сильно любите это животное? 0-100");
            String love = scanner.next();
            try {
                loves = Integer.parseInt(love);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
            System.out.println("Введите максимальное время пробежки это животное? ");
            String timeMaxRuns = scanner.next();
            try {
                timeMaxRun = Integer.parseInt(timeMaxRuns);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
            System.out.println("Введите расстояние которое пробегает это животное? ");
            String distanceRuns = scanner.next();
            try {
                dictanceRun = Integer.parseInt(distanceRuns);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
            if (name == null || name.equals("") || dateFalse || weight <= 0 || color == null || color.equals("") || favoriteFood.equals("") || favoriteFood.equals("") || whoIsHePlayingWith.equals("") || loves <= 0 || timeMaxRun <= 0 || dictanceRun <= 0 || energy <= 0) {
                throw new Exception("Неправильная инициализация хомяка!");
            } else {
                counter.add();
            }
            return new Hamster("Hamster" + Counter.getCountAnimals(), name, date2, energy, weight, Type.Pet, whoIsHePlayingWith, loves, favoriteFood, favoriteToy, timeMaxRun, dictanceRun);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}