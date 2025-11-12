package Java_core_hw_5;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, byte iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Hello, my lovely " + getFamily().getPet().getNickname() + "!");
        } else {
            System.out.println("Oh, I wish I had a cute pet!");
        }
    }

    public void makeup() {
        System.out.println(getName() + " is putting on makeup. Feeling fabulous!");
    }
}
