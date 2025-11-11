package Java_core_hw_5;

public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String dayOfWeekVal;

    DayOfWeek(String dayOfWeekVal) {
        this.dayOfWeekVal = dayOfWeekVal;

    }
    public String getDayOfWeekVal(){
        return dayOfWeekVal;
    }

}
