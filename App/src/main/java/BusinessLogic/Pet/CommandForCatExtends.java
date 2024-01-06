package BusinessLogic.Pet;

import Models.Animals.Pet.Cat;

public class CommandForCatExtends <T extends Cat> {
    private T animal;

    public CommandForCatExtends(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void scratch() throws RuntimeException{
        if (animal.getLoves() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'loves'", new Throwable());
        } else if (animal.getName().equalsIgnoreCase("")) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'name'", new Throwable());
        } else if (animal.getEnergy() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'energy'", new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'weight'", new Throwable());
        }
        animal.setLoves(animal.getLoves()/2);
    }
}