package BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreatePackAnimals;

        import BusinessLogic.Nursery.Counter.Counter;
        import Models.Animals.PackAnimals.Horse;
        import Models.Animals.Type;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Scanner;

public class CreateNewHorse {
    private Horse animal;

    private int energy = 60;
    private int weight = 20;
    private int liftingWeight = 40;
    private int impactForce = 120;
    private int biteForce = 40;

    public CreateNewHorse() throws Exception, RuntimeException {
        this.animal = createHorse();
    }

    public Horse getAnimal() {
        return animal;
    }

    private Horse createHorse() throws Exception, RuntimeException{
        String name;
        Date date2 = null;
        String weights;
        String liftingW;
        boolean datesFalse = false;
        try (Counter counter = new Counter()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите имя: ");
            name = scanner.nextLine();
            System.out.println("Введите дату рождения: dd-mm-yyyy ");
            String date = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date2 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                datesFalse = true;
            }
            System.out.println("введите вес");
            weights = scanner.next();
            try {
                weight = Integer.parseInt(weights);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            System.out.println("введите тяговый вес");
            liftingW = scanner.next();
            try {
                liftingWeight = Integer.parseInt(liftingW);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            if (name == null || name.equals("") || weight <= 0 || liftingWeight <= 0 || datesFalse || energy <=0 || biteForce <= 0 || impactForce <= 0) {
                throw new Exception("неправильная инициализация лошади");
            } else {
                counter.add();
            }
            return new Horse("Horse" + Counter.getCountAnimals(), name, date2, energy, weight, Type.PackAnimal, liftingWeight, impactForce, biteForce);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}