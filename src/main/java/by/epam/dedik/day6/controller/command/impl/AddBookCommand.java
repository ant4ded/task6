package by.epam.dedik.day6.controller.command.impl;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.BookResponse;
import by.epam.dedik.day6.controller.Params;
import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.dao.DaoException;
import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.CustomBook;
import by.epam.dedik.day6.service.BookConverterService;

public class AddBookCommand implements BookCommand {
    public static final String SUCCESS = "Adding was successful";

    @Override
    public void execute(BookRequest request, BookResponse response) {
        BookListDao dao = new BookListDaoImpl();
        CustomBook book = BookConverterService.toBook(request.getParameter(Params.BOOK));
        try {
            dao.addBook(book);
            response.setMessage(SUCCESS);
        } catch (DaoException e) {
            response.setMessage(e.getMessage());
        }
    }
}
