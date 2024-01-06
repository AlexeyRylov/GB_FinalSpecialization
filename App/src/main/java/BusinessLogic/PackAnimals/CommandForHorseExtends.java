package BusinessLogic.PackAnimals;

import Models.Animals.PackAnimals.Horse;
import View.Consoles.ConsolePrinterOne;

public class CommandForHorseExtends <T extends Horse> {
    private T animal;

    public CommandForHorseExtends(T animal) {
        this.animal = animal;
    }

    public CommandForHorseExtends() {
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void bite() throws RuntimeException{
        if (animal.getBiteForce() < 0) {
            throw new RuntimeException("Ошибка параметра biteForce лошади "  + animal.getName(), new Throwable());
        } else if (animal.getEnergy() < 0) {
            throw new RuntimeException("Ошибка параметра 'energy' лошади "  + animal.getName(), new Throwable());
        } else if (animal.getLiftingWeight() < 0) {
            throw new RuntimeException("Ошибка параметра 'liftingWeight' лошади "  + animal.getName(), new Throwable());
        } else if (animal.getImpactForce() < 0) {
            throw new RuntimeException("Ошибка параметра 'impactForce' лошади"  + animal.getName(), new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Ошибка параметра 'weight' лошади"  + animal.getName(), new Throwable());
        } else if (animal.getBiteForce() - animal.getENERGY_СONSUMPTION() >= 0) {
            ConsolePrinterOne.print("Лошадь вас укусила");
            animal.setBiteForce(animal.getBiteForce() - animal.getENERGY_СONSUMPTION());
        } else {
            ConsolePrinterOne.print("У лошади нет сил даже на укус =(");
        }
    }
}