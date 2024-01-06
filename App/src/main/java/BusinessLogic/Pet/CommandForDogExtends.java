package BusinessLogic.Pet;

import Models.Animals.Pet.Dog;
import View.Consoles.ConsolePrinterOne;

public class CommandForDogExtends<T extends Dog> {
    public T animal;

    public CommandForDogExtends(T animal) {
        this.animal = animal;
    }

    public <T> void bite() throws RuntimeException {
        if (animal.getLoves() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'loves'", new Throwable());
        } else if (animal.getName().equalsIgnoreCase("")) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'name'", new Throwable());
        } else if (animal.getEnergy() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'energy'", new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'weight'", new Throwable());
        } else if (animal.getIntelligence() <= 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'intelligence'", new Throwable());
        }
        ConsolePrinterOne.print("Собачка вас укусила.");
        animal.setLoves(animal.getLoves() / 2);
        animal.setIntelligence(animal.getIntelligence() - 1);
        animal.setEnergy(animal.getEnergy() - 3);
        if (animal.getIntelligence() < 0) animal.setIntelligence(2);
        if (animal.getEnergy() < 0) animal.setEnergy(1);
    }

    public <T> void executeTheCommand() throws RuntimeException {
        if (animal.getLoves() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'loves'", new Throwable());
        } else if (animal.getName().equalsIgnoreCase("")) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'name'", new Throwable());
        } else if (animal.getEnergy() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'energy'", new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'weight'", new Throwable());
        }
        ConsolePrinterOne.print("Собака отлично выполняет базовые команды: сидит, лежит и даже даёт лапу =)");
        animal.setIntelligence(animal.getIntelligence() + 5);
        animal.setLoves(animal.getLoves() * 2);
    }
}