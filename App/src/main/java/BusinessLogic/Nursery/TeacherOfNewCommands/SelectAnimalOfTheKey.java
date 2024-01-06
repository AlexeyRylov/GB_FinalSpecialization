package BusinessLogic.Nursery.TeacherOfNewCommands;

import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;

public class SelectAnimalOfTheKey {
    public static HumanFriend selectAnimal(String key, NurseryOne<HumanFriend> nurseryOne) {
        for (HumanFriend humanFriend :
                nurseryOne.getAllAnimals().values()) {
            if (humanFriend.getKey().strip().toLowerCase().equals(key.toLowerCase())) {
                return humanFriend;
            }
        }
        return null;
    }
}