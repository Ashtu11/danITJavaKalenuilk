package java_core_hw_6;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int birthYear, byte iq) {
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

    public void makeup() {
        System.out.println(getName() + " is putting on makeup. Feeling fabulous!");
    }
}
