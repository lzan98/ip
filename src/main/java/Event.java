import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    public Event(String description) throws DukeException {
        super(description);
        try {
            String[] strArr = description.split("/at ");
            String[] DateAndTime = strArr[1].split(" ");
            LocalDate date = LocalDate.parse(DateAndTime[0]);
            this.description = strArr[0] + "(" + "at: " + date.format(DateTimeFormatter.ofPattern("MMM d YYYY")) + ")";
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException();
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString();
    }

}
