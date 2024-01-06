package BusinessLogic.Nursery.AddNewAnimal;

import BusinessLogic.Nursery.AddNewAnimal.CreateAnimals.CreateNewAnimal;
import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;

public class AddNewAnimal <T extends NurseryOne<HumanFriend>> {
    private HumanFriend animal;
    private T nursery;

    public AddNewAnimal(T nursery) throws Exception {
        this.nursery = nursery;
        CreateNewAnimal create = new CreateNewAnimal();
        this.animal = create.getHumanFriend();
        add();
    }

    public void add() throws RuntimeException {
        try {
            this.nursery.getAllAnimals().put(animal.getKey() ,animal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HumanFriend getAnimal() {
        return animal;
    }

    public void setAnimal(HumanFriend animal) {
        this.animal = animal;
    }
}