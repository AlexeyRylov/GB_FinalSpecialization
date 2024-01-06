package BusinessLogic.PackAnimals;

import Models.Animals.PackAnimals.Camel;
import View.Consoles.ConsolePrinterOne;

public class CommandForCamelExtends<T extends Camel> {


    protected <T extends Camel> void workCamel(T animal) throws RuntimeException {
        animal.work();
    }

    public <T extends Camel> void spit(T animal) throws RuntimeException {
        if (animal.getEnergy() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда " + animal.getName(), new Throwable());
        } else if (animal.getStockInTheHump() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        } else if (animal.getLiftingWeight() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        } else if (animal.getAmountOfSaliva() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        }
        if (animal.getAmountOfSaliva() - animal.getSPITTING_VOLUME() >= 0) {
            ConsolePrinterOne.print("Верблюд плюнул вам на лицо");
        } else {
            ConsolePrinterOne.print("Верблюд упал потеряв сознание от обезвоживания, ему нужен покой");
        }
    }

    protected <T extends Camel> void chewThrons(T animal) throws RuntimeException {
        if (animal.getEnergy() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда " + animal.getName(), new Throwable());
        } else if (animal.getStockInTheHump() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        } else if (animal.getWeight() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        } else if (animal.getLiftingWeight() < 0) {
            throw new RuntimeException("Не правильная инициализация верблюда "  + animal.getName(), new Throwable());
        }
        animal.setStockInTheHump(animal.getStockInTheHump() + animal.getENERGY_СONSUMPTION() * 6);
        animal.setEnergy(animal.getEnergy() + animal.getENERGY_СONSUMPTION() * 4);
        ConsolePrinterOne.print("Верблюд пополнил свои запасы и энергию 'ци'");
    }
}