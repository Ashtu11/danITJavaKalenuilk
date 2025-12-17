package java_core_hw_10;

public final class Man extends Human {
    public Man(String fname, String fsurname, String fatherBirth, byte fiq) { super(); }
    public Man(String name, String surname, int year) { super(name, surname, year); }
    public Man(String name, String surname, int birthYear, byte iq) { super(name, surname, birthYear, iq); }

    @Override
    public void greetPet() {
        if (getFamily() != null && !getFamily().getPets().isEmpty()) {
            getFamily().getPets().forEach(p -> System.out.println("Hey buddy, " + p.getNickname() + "!"));
        } else System.out.println("Hey, I don't have a pet yet!");
    }

    public void repairCar() {
        System.out.println(getName() + " is repairing his car");
    }
}