package BusinessLogic.Nursery.DeleteAnimal;

import Models.Abstract.Animals.HumanFriend;
import Models.Nursery.NurseryOne.NurseryOne;
import View.Consoles.ConsolePrinterOne;

public class DeleteAnimal {
    private NurseryOne<HumanFriend> humanFriendNurseryOne;

    public DeleteAnimal(NurseryOne<HumanFriend> humanFriendNurseryOne) {
        this.humanFriendNurseryOne = humanFriendNurseryOne;
        SelectAnimalOfKey selectAnimalOfKey = new SelectAnimalOfKey(this.humanFriendNurseryOne);
        selectAnimalOfKey.select();
        if (selectAnimalOfKey.getHumanFriend() != null) {
            delete(selectAnimalOfKey.getHumanFriend());
        } else {
            ConsolePrinterOne.print("Ничего не удалено!");
        }
    }

    public void delete(HumanFriend humanFriend) {
        this.humanFriendNurseryOne.getAllAnimals().remove(humanFriend);
    }
}