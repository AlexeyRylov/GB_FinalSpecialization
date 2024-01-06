package BusinessLogic.PackAnimals;

import Models.Animals.PackAnimals.Donkey;
import View.Consoles.ConsolePrinterOne;

public class CommandForDonkeyExtends<T extends Donkey> {
    private T animal;
    private final int ratio1Stubbornness = 2;
    private final int ratio2Energy = 2;

    public CommandForDonkeyExtends(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public int getRatio1Stubbornness() {
        return ratio1Stubbornness;
    }

    public int getRatio2Energy() {
        return ratio2Energy;
    }

    public <T> void walk() throws RuntimeException {
        if (this.animal.getStubbornness() < 0) {
            throw new RuntimeException("Не правильная инициализация ослика "  + animal.getName()  );
        } else if (this.animal.getEnergy() < 0) {
            throw new RuntimeException("Не правильная инициализация ослика "  + animal.getName());
        } else if (this.animal.getLiftingWeight() < 0) {
            throw new RuntimeException("Не правильная инициализация ослика "  + animal.getName());
        } else if (this.animal.getWeight() <= 0) {
            throw new RuntimeException("Не правильная инициализация ослика "  + animal.getName());
        } else if (this.animal.getStubbornness() > 100) {
            ConsolePrinterOne.print("Ослик уже настолько упрям что не пошел гулять!");
        } else {
            ConsolePrinterOne.print("Счастливый ослик пошел погулять!");
            this.animal.setStubbornness(this.animal.getStubbornness() - this.animal.getENERGY_СONSUMPTION() * getRatio1Stubbornness());
            this.animal.setEnergy(this.animal.getEnergy() + this.animal.getENERGY_СONSUMPTION() * getRatio2Energy());
            this.animal.setLiftingWeight(this.animal.getLiftingWeight() + this.animal.getENERGY_СONSUMPTION());
            if (this.animal.getStubbornness() < 0) this.animal.setStubbornness(0);
        }
    }
}