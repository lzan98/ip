package yeowoo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import tasks.TaskList;

public class Parser {
    private TaskList taskList;
    public Parser(TaskList tList) {
        taskList = tList;
    };

    /**
     * Parses the input from user and checks if there are any invalid commands or format.
     *
     * @param str Input from User.
     * @return String of the original user input if no violations are found.
     * @throws MissingDescriptionException If a command is missing required information.
     * @throws YeowooException If the command or format is invalid.
     */
    public String parse(String str) throws MissingDescriptionException, YeowooException, InvalidTaskException {
        String[] strArr = str.split(" ");
        String firstWord = strArr[0];
        if ((firstWord.equals("deadline") || firstWord.equals("event") || firstWord.equals("todo"))) {
            if (strArr.length == 1) {
                throw new MissingDescriptionException();
            }
        } else if (firstWord.equals("unmark") || firstWord.equals("mark") || firstWord.equals("delete")) {
            if (strArr.length == 1) {
                throw new YeowooException();
            } else {
                try {
                    int index = Integer.parseInt(strArr[1]);
                    if (taskList.getTasks().size() < index) {
                        throw new InvalidTaskException();
                    }
                } catch (Exception e) {
                    throw new InvalidTaskException();
                }
            }
        } else if (firstWord.equals("schedule")) {
            try {
                LocalDate date = LocalDate.parse(strArr[1]);
            } catch (DateTimeParseException e) {
                throw new YeowooException();
            }
        } else if (firstWord.equals("list") || firstWord.equals("find") || firstWord.equals("bye")) {
            if (strArr.length > 1) {
                throw new YeowooException();
            }
        } else {
            throw new YeowooException();
        }
        return str;
    }
}
