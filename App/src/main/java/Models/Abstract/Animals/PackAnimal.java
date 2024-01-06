package Models.Abstract.Animals;

import Models.Animals.Type;

import java.util.Date;

public abstract class PackAnimal extends HumanFriend {
    private int liftingWeight;



    public PackAnimal(int liftingWeight) {
        this.liftingWeight = liftingWeight;
    }

    public PackAnimal(String key,String name, Date birthDay, int energy, int weight, Type type, int liftingWeight) {
        super(key,name, birthDay, energy, weight, type);
        this.liftingWeight = liftingWeight;
    }

    public int getLiftingWeight() {
        return liftingWeight;
    }

    public void setLiftingWeight(int liftingWeight) {
        this.liftingWeight = liftingWeight;
    }

    protected abstract void work();

    @Override
    public String toString() {
        return super.toString().replace("}","") + ", " +
                "liftingWeight=" + liftingWeight +
                '}';
    }
}