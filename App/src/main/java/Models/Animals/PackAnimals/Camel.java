package Models.Animals.PackAnimals;

import BusinessLogic.PackAnimals.CommandForCamelExtends;
import Models.Abstract.Animals.PackAnimal;
import Models.Animals.Type;
import View.Consoles.ConsolePrinterOne;

import java.util.Date;
import java.util.Map;

public class Camel extends PackAnimal {
    private int stockInTheHump;
    private int amountOfSaliva;
    private Map<String, String> studiedСommands;
    private final int ENERGY_СONSUMPTION = 5;
    private final int SPITTING_VOLUME = 5;

    public Camel(int liftingWeight, int stockInTheHump, int amountOfSaliva) {
        super(liftingWeight);
        this.stockInTheHump = stockInTheHump;
        this.amountOfSaliva = amountOfSaliva;
        this.studiedСommands = Map.of("Chew Thorns", "Верблюд жует колючки =)", "spit", "Верблюд плюнул вам на лицо");
    }

    public Camel(String key,String name, Date birthDay, int energy, int weight, Type type, int liftingWeight, int stockInTheHump, int amountOfSaliva) {
        super(key,name, birthDay, energy, weight, type, liftingWeight);
        this.stockInTheHump = stockInTheHump;
        this.amountOfSaliva = amountOfSaliva;
        this.studiedСommands = Map.of("Chew Thorns", "Верблюд жует колючки =)", "spit", "Верблюд плюнул вам на лицо");

    }

    public Map<String, String> getStudiedСommands() {
        return studiedСommands;
    }

    public void setStudiedСommands(Map<String, String> studiedСommands) {
        this.studiedСommands = studiedСommands;
    }

    public int getENERGY_СONSUMPTION() {
        return ENERGY_СONSUMPTION;
    }

    public int getSPITTING_VOLUME() {
        return SPITTING_VOLUME;
    }

    public int getStockInTheHump() {
        return stockInTheHump;
    }

    public void setStockInTheHump(int stockInTheHump) {
        this.stockInTheHump = stockInTheHump;
    }

    public int getAmountOfSaliva() {
        return amountOfSaliva;
    }

    public void setAmountOfSaliva(int amountOfSaliva) {
        this.amountOfSaliva = amountOfSaliva;
    }

    public void chewThoms() {
        setAmountOfSaliva(getAmountOfSaliva() + SPITTING_VOLUME * 4);
        ConsolePrinterOne.print("Верблюд тебе благодарен!");
    }

    @Override
    public void work() throws RuntimeException {
        if (stockInTheHump < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'stockInTheHump'", new Throwable());
        } else if (amountOfSaliva < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'amountOfSaliva'", new Throwable());
        } else if (getEnergy() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'amountOfSaliva'", new Throwable());
        } else if (getLiftingWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'amountOfSaliva'", new Throwable());
        } else if (getWeight() < 0) {
            throw new RuntimeException("Не инициализирована или имеет не корректтное значение переменная 'amountOfSaliva'", new Throwable());
        } else if ((stockInTheHump - ENERGY_СONSUMPTION) <= 0) {
            ConsolePrinterOne.print("Верблюд на последнем издыхании, он чуствует что не переживет данную экскурсию без воды, еды или сна!");
            if ((amountOfSaliva - SPITTING_VOLUME) >= 0) {
                new CommandForCamelExtends<Camel>().spit(this);
                setAmountOfSaliva(getAmountOfSaliva() - SPITTING_VOLUME);
            } else {
                ConsolePrinterOne.print("Верблюд упал от истощения");
            }
        } else {
            ConsolePrinterOne.print("And again the camel took an excursion to the oasis!");
            setStockInTheHump(getStockInTheHump() - ENERGY_СONSUMPTION);
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}","") + ", " +
                "stockInTheHump=" + stockInTheHump +
                ", amountOfSaliva=" + amountOfSaliva +
                ", studiedСommands=" + studiedСommands +
                ", ENERGY_СONSUMPTION=" + ENERGY_СONSUMPTION +
                ", SPITTING_VOLUME=" + SPITTING_VOLUME +
                '}';
    }
}