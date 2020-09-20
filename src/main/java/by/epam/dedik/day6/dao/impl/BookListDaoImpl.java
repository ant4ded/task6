package by.epam.dedik.day6.dao.impl;

import by.epam.dedik.day6.dao.BookListDao;
import by.epam.dedik.day6.dao.DaoException;
import by.epam.dedik.day6.entity.CustomBook;
import by.epam.dedik.day6.entity.Library;
import by.epam.dedik.day6.service.SortType;
import by.epam.dedik.day6.service.UniqueIdService;
import by.epam.dedik.day6.validator.BookValidator;

import java.util.List;
import java.util.stream.Collectors;

public class BookListDaoImpl implements BookListDao {
    private BookValidator bookValidator = new BookValidator();

    @Override
    public void addBook(CustomBook book) throws DaoException {
        if (bookValidator.isValidBook(book)) {
            if (book.getId() == 0) {
                book.setId(UniqueIdService.getId());
            }
            Library.getInstance().addBook(book);
        } else {
            throw new DaoException("Invalid book");
        }
    }

    @Override
    public void removeBook(CustomBook book) throws DaoException {
        if (bookValidator.isValidBook(book)) {
            Library.getInstance().removeBook(book);
        } else {
            throw new DaoException("Invalid book");
        }
    }

    @Override
    public List<CustomBook> findByName(String name) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getName().equals(name)).
                collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByAuthor(String author) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getAuthors().contains(author)).
                collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByYear(int year) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getYear() == year).
                collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByNumberPages(int numberPages) {
        return Library.getInstance().getBooks().stream().
                filter(book -> book.getNumberPages() == numberPages).
                collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortByTag(SortType sortType) {
        return Library.getInstance().getBooks().stream()
                .sorted(sortType.getComparator())
                .collect(Collectors.toList());
    }
}
