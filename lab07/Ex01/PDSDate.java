package lab07.Ex01;

public class PDSDate {
    int month;
    int year;
    int day;
    String hour;

    public PDSDate(int day, int month , int year, String hour) {
        this.month = month;
        this.year = year;
        this.day = day;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Date [month=" + month + ", year=" + year + ", day=" + day + "] , hour=" + hour ;
    }
}
