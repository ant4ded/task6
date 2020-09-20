package by.epam.dedik.day6.controller.command.impl;

import by.epam.dedik.day6.controller.BookRequest;
import by.epam.dedik.day6.controller.BookResponse;
import by.epam.dedik.day6.controller.Params;
import by.epam.dedik.day6.controller.command.BookCommand;
import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.dao.impl.BookListDaoImpl;
import by.epam.dedik.day6.entity.CustomBook;
import by.epam.dedik.day6.service.SortType;

import java.util.List;

public class SortByTagCommand implements BookCommand {
    @Override
    public void execute(BookRequest request, BookResponse response) {
        BookListDao dao = new BookListDaoImpl();
        SortType sortType = SortType.valueOf(request.getParameter(Params.SORT_TYPE));
        List<CustomBook> books = dao.sortByTag(sortType);
        response.setBooks(books);
    }
}
