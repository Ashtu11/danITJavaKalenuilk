package java_core_hw_9;

public final class Man extends Human {
    public Man(String name, String surname, String fatherBirth, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int birthYear, byte iq) {
        super(name, surname, birthYear, iq);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPets() != null && !getFamily().getPets().isEmpty()) {
            getFamily().getPets().forEach(pet ->
                    System.out.println("Hey buddy, " + pet.getNickname() + "! Let's go for a walk!")
            );
        } else {
            System.out.println("Hey, I don't have a pet yet!");
        }
    }
    public void repairCar(){
        System.out.println(getName()+ " is repairing his car");
    }
}