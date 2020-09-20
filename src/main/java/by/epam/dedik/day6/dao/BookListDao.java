package by.epam.dedik.day6.dao;

import by.epam.dedik.day6.entity.CustomBook;
import by.epam.dedik.day6.service.SortType;

import java.util.List;

public interface BookListDao {
    void addBook(CustomBook book) throws DaoException;

    void removeBook(CustomBook book) throws DaoException;

    List<CustomBook> findByName(String name);

    List<CustomBook> findByAuthor(String author);

    List<CustomBook> findByYear(int year);

    List<CustomBook> findByNumberPages(int numberPages);

    List<CustomBook> sortByTag(SortType sortType);
}
