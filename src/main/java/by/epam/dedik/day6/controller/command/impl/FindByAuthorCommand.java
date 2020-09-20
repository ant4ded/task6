package by.epam.dedik.day6.controller.command.impl;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.BookResponse;
import by.epam.dedik.day6.controller.Params;
import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.CustomBook;

import java.util.List;

public class FindByAuthorCommand implements BookCommand {
    @Override
    public void execute(BookRequest request, BookResponse response) {
        BookListDao dao = new BookListDaoImpl();
        String author = request.getParameter(Params.AUTHOR);
        List<CustomBook> books = dao.findByAuthor(author);
        response.setBooks(books);
    }
}
