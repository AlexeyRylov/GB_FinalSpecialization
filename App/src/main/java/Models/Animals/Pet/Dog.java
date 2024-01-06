package Models.Animals.Pet;

import Models.Abstract.Animals.Pet;
import Models.Animals.Type;
import View.Consoles.ConsolePrinterOne;

import java.util.Date;
import java.util.Map;

public class Dog extends Pet {
    private int intelligence;
    private Map<String, String> studiedСommands;

    public Dog(String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy, int intelligence) {
        super(whoIsHePlayingWith, loves, favoriteFood, favoriteToy);
        this.intelligence = intelligence;
        this.studiedСommands = Map.of("Execute the command", "собака выполняет команды", "Bite", "Собака вас укусила");

    }

    public Dog(String key,String name, Date birthDay, int energy, int weight, Type type, String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy, int intelligence) {
        super(key, name, birthDay, energy, weight, type, whoIsHePlayingWith, loves, favoriteFood, favoriteToy);
        this.intelligence = intelligence;
        this.studiedСommands = Map.of("Execute the command", "собака выполняет команды", "Bite", "Собака вас укусила");
    }

    public Map<String, String> getStudiedСommands() {
        return studiedСommands;
    }

    public void setStudiedСommands(Map<String, String> studiedСommands) {
        this.studiedСommands = studiedСommands;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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
        } else if (getIntelligence() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'intelligence'", new Throwable());
        }
        ConsolePrinterOne.print("Вы играете с этим счастливым щенком!");
        if (getWhoIsHePlayingWith() == "Valeriy") {
            setIntelligence(getIntelligence() * 3);
            setLoves(getLoves() * 3);
        } else {
            setIntelligence(getIntelligence() * 2);
            setLoves(getLoves() * 2);
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}","") + ", " +
                "intelligence=" + intelligence +
                ", studiedСommands=" + studiedСommands +
                '}';
    }
}