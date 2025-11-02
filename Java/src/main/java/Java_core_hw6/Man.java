package Java_core_hw6;

public final class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Йо! " + getFamily().getPet().getNickname() + ", підемо гуляти!");
        } else {
            System.out.println("Привіт, улюбленцю!");
        }
    }

    public void repairCar() {
        System.out.println("Ремонтує авто...");
    }
}