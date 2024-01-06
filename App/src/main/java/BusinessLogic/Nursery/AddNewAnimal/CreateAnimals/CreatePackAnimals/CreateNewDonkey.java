package BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePackAnimals;

        import BusinessLogic.Nursery.Counter.Counter;
        import Models.Animals.PackAnimals.Donkey;
        import Models.Animals.Type;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Scanner;

public class CreateNewDonkey {

    private Donkey animal;

    private int energy = 40;
    private int weight = 12;
    private int liftingWeight = 10;
    private int stubbornness = 25;

    public CreateNewDonkey() {
        this.animal = createDonkey();
    }

    public Donkey getAnimal() {
        return animal;
    }

    private Donkey createDonkey() {
        String name;
        Date date2 = null;
        String weights;
        String liftingW;
        boolean dateFalse = false;
        try (Counter counter = new Counter()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите имя: ");
            name = scanner.nextLine();
            System.out.println("Введите дату рождения: dd-mm-yyyy ");
            String date = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date2 = null;
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
            if (name == null || name.equals("") || weight <= 0 || liftingWeight == 0 || energy <= 0 || dateFalse || stubbornness <= 0) {
                throw new Exception("неправильная инициализация ослика");
            } else {
                counter.add();
            }
            return new Donkey("Donkey" + Counter.getCountAnimals(), name, date2, energy, weight, Type.PackAnimal, liftingWeight, stubbornness);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
