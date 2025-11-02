package Java_core_hw6;

public final class Woman extends Human {

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Привіт, мій милий " + getFamily().getPet().getNickname() + "!");
        } else {
            System.out.println("Привіт, улюбленцю!");
        }
    }

    public void makeup() {
        System.out.println("Робить макіяж...");
    }
}
