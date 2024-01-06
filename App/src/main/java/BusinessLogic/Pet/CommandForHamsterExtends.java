package BusinessLogic.Pet;

import Models.Animals.Pet.Hamster;
import View.Consoles.ConsolePrinterOne;

public class CommandForHamsterExtends<T extends Hamster> {

    public <T extends Hamster> void run(T animal) throws RuntimeException {
        if (animal.getLoves() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'loves'", new Throwable());
        } else if (animal.getName().equalsIgnoreCase("")) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'name'", new Throwable());
        } else if (animal.getEnergy() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'energy'", new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'weight'", new Throwable());
        } else if (animal.getDistanceRun() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'distanceRun'", new Throwable());
        } else if (animal.getTimeMaxRun() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'timeMaxRun'", new Throwable());
        } else if ((animal.getEnergy() - animal.getENERGY_СONSUMPTION()) <= 0) {
            ConsolePrinterOne.print("Этот щекастый зожник на последнем издыхании, он чуствует что не переживет данный спринт без воды, еды или сна!");
        } else {
            animal.setEnergy(animal.getEnergy() - animal.getENERGY_СONSUMPTION());
            if (animal.getEnergy() < 1) animal.setEnergy(5);
            ConsolePrinterOne.print("Торнадо бежит в своём колесе!");
        }
    }
}