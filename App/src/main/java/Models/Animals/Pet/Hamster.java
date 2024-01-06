package Models.Animals.Pet;

import Models.Abstract.Animals.Pet;
import Models.Animals.Type;
import View.Consoles.ConsolePrinterOne;

import java.util.Date;
import java.util.Map;

public class Hamster extends Pet {

    private int timeMaxRun;
    private int distanceRun;

    private Map<String, String> studiedСommands;

    public Hamster(String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy, int timeMaxRun, int distanceRun) {
        super(whoIsHePlayingWith, loves, favoriteFood, favoriteToy);
        this.timeMaxRun = timeMaxRun;
        this.distanceRun = distanceRun;
        this.studiedСommands = Map.of("Run", "Хомяк даёт жару в колесе!");

    }

    public Hamster(String key,String name, Date birthDay, int energy, int weight, Type type, String whoIsHePlayingWith, int loves, String favoriteFood, String favoriteToy, int timeMaxRun, int distanceRun) {
        super(key,name, birthDay, energy, weight, type, whoIsHePlayingWith, loves, favoriteFood, favoriteToy);
        this.timeMaxRun = timeMaxRun;
        this.distanceRun = distanceRun;
        this.studiedСommands = Map.of("Run", "Хомяк даёт жару в колесе!");
    }

    public Map<String, String> getStudiedСommands() {
        return studiedСommands;
    }

    public void setStudiedСommands(Map<String, String> studiedСommands) {
        this.studiedСommands = studiedСommands;
    }

    public int getENERGY_СONSUMPTION() {
        return 5;
    }

    public int getWEIGHT_LOSS() {
        return 5;
    }

    public int getTimeMaxRun() {
        return timeMaxRun;
    }

    public void setTimeMaxRun(int timeMaxRun) {
        this.timeMaxRun = timeMaxRun;
    }

    public int getDistanceRun() {
        return distanceRun;
    }

    public void setDistanceRun(int distanceRun) {
        this.distanceRun = distanceRun;
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
        } else if (getDistanceRun() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'distanceRun'", new Throwable());
        } else if (getTimeMaxRun() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'timeMaxRun'", new Throwable());
        }
        ConsolePrinterOne.print("Хомяк стоит и смотрит на тебя своими черными глазами");
        if (getWhoIsHePlayingWith() == "Valeriy") {
            setLoves(getLoves() + 8);
        } else {
            setLoves(getLoves() + 5);
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}","") + ", " +
                "timeMaxRun=" + timeMaxRun +
                ", distanceRun=" + distanceRun +
                ", studiedСommands=" + studiedСommands +
                '}';
    }
}