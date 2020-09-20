package by.epam.dedik.day6.controller;

import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.controller.command.CommandHelper;

public class BookController {
    public void doSomething(BookRequest request, BookResponse response) {
        CommandHelper commandHelper = new CommandHelper();
        BookCommand command = commandHelper.getCommand(request.getParameter(Params.COMMAND));

        command.execute(request, response);
    }
}
