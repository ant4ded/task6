package by.epam.dedik.day6.controller.command.impl;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.BookResponse;
import by.epam.dedik.day6.controller.Params;
import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.CustomBook;

import java.util.List;

public class FindByYearCommand implements BookCommand {
    @Override
    public void execute(BookRequest request, BookResponse response) {
        BookListDao dao = new BookListDaoImpl();
        int year = Integer.parseInt(request.getParameter(Params.YEAR));
        List<CustomBook> books = dao.findByYear(year);
        response.setBooks(books);
    }
}
