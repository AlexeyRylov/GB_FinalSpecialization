package BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePackAnimals;

        import BusinessLogic.Nursery.Counter.Counter;
        import Models.Animals.PackAnimals.Camel;
        import Models.Animals.Type;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Scanner;

public class CreateNewCamel {

    private Camel animal;

    private int energy = 80;
    private int weight = 20;
    private int liftingWeight = 40;
    private int stockInTheHump = 300;
    private int amountOfSaliva = 66;

    public CreateNewCamel() {
        this.animal = createCamel();
    }

    public Camel getAnimal() {
        return animal;
    }

    private Camel createCamel() {
        String name;
        Date date2 = null;
        String weights;
        String liftingW;
        try (Counter counter = new Counter()) {
            boolean dateFalse = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите имя: ");
            name = scanner.nextLine();
            System.out.println("Введите дату рождения: dd-mm-yyyy ");
            String date = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                //Parsing the String
                date2 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                dateFalse = true;
            }
            System.out.println("введите вес");
            weights = scanner.next();
            try {
                weight = Integer.parseInt(weights);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
            System.out.println("введите тяговый вес");
            liftingW = scanner.next();
            try {
                liftingWeight = Integer.parseInt(liftingW);
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
            if (name == null || name.equals("") || weight <= 0 || liftingWeight <= 0 || dateFalse || stockInTheHump <= 0 || amountOfSaliva <= 0 || energy <= 0) {
                throw new Exception("неправильная инициализация верблюда");
            } else {
                counter.add();
                return new Camel("Camel" + Counter.getCountAnimals(), name, date2, energy, weight, Type.PackAnimal, liftingWeight, stockInTheHump, amountOfSaliva);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
