package by.epam.dedik.day6.controller.command;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.BookResponse;

public interface BookCommand {
    void execute(BookRequest request, BookResponse response);
}
