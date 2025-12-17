package Java_core_hw_5;

public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, byte iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Hey buddy, " + getFamily().getPet().getNickname() + "! Let's go for a walk!");
        } else {
            System.out.println("Hey, I don't have a pet yet!");
        }
    }

    public void repairCar() {
        System.out.println(getName() + " is repairing his car. Vroom-vroom!");
    }
}
