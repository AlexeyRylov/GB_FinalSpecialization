package Models.Animals.Pet;

import BusinessLogic.Pet.CommandForCatExtends;
import Models.Abstract.Animals.Pet;
import Models.Animals.Type;
import View.Consoles.ConsolePrinterOne;

import java.util.Date;
import java.util.Map;

public class Cat extends Pet {
    private String color;
    private Map<String, String> studiedСommands;

    public Cat(String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy, String color) {
        super(whoIsHePlayingWith, loves, favoriteFood, favoriteToy);
        this.color = color;
        this.studiedСommands = Map.of("Scratch", "котенок вас поцарапал");

    }

    public Cat(String key,String name, Date birthDay, int energy, int weight, Type type, String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy, String color) {
        super(key,name, birthDay, energy, weight, type, whoIsHePlayingWith, loves, favoriteFood, favoriteToy);
        this.color = color;
        this.studiedСommands = Map.of("Scratch", "котенок вас поцарапал");
    }

    public Map<String, String> getStudiedСommands() {
        return studiedСommands;
    }

    public void setStudiedСommands(Map<String, String> studiedСommands) {
        this.studiedСommands = studiedСommands;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void toPlay() throws RuntimeException {
        if (getLoves() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'loves'", new Throwable());
        } else if (getName().equalsIgnoreCase("")) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'name'", new Throwable());
        } else if (getEnergy() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'energy'", new Throwable());
        } else if (getWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'weight'", new Throwable());
        }
        ConsolePrinterOne.print("Вы довольный играете с котиком");
        if (getWhoIsHePlayingWith() == "Valeriy") {
            setLoves(getLoves() * 3);
        } else {
            setLoves(getLoves() * 2);
        }
        if (getLoves() >= 100) {
            new CommandForCatExtends<Cat>(this).scratch();
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}","") + ", " +
                "color='" + color + '\'' +
                ", studiedСommands=" + studiedСommands +
                '}';
    }
}