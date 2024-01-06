package Models.Abstract.Animals;

import Models.Animals.Type;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class HumanFriend {
    protected static int countAnimals = 0;
    private String name;
    private Date birthDay;
    private int energy;
    private int weight;
    private Type type;
    private String key;
    private Map<String, String> studiedСommands;

    public HumanFriend() {
        countAnimals += 1;
        this.setStudiedСommands(new HashMap<>());
    }

    public HumanFriend(String key, String name, Date birthDay, int energy, int weight, Type type) {
        this.key = key;
        this.name = name;
        this.birthDay = birthDay;
        this.energy = energy;
        this.weight = weight;
        this.type = type;
        this.setStudiedСommands(new HashMap<>());
        countAnimals += 1;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }

    public static void setCountAnimals(int countAnimals) {
        HumanFriend.countAnimals = countAnimals;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<String, String> getStudiedСommands() {
        return studiedСommands;
    }

    public void setStudiedСommands(Map<String, String> studiedСommands) {
        this.studiedСommands = studiedСommands;
    }

    @Override
    public String toString() {
        return "HumanFriend{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", energy=" + energy +
                ", weight=" + weight +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HumanFriend that)) return false;
        return getEnergy() == that.getEnergy() && getWeight() == that.getWeight() && Objects.equals(getName(), that.getName()) && Objects.equals(getBirthDay(), that.getBirthDay()) && getType() == that.getType() && Objects.equals(getKey(), that.getKey()) && Objects.equals(getStudiedСommands(), that.getStudiedСommands());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthDay(), getEnergy(), getWeight(), getType(), getKey(), getStudiedСommands());
    }
}