package by.epam.dedik.day6.validator;

import by.epam.dedik.day6.entity.CustomBook;

import java.time.LocalDate;

public class BookValidator {
    private static final int FIRST_BOOK = -600;

    public boolean isValidBook(CustomBook book) {
        return book.getName() != null && book.getAuthors() != null &&
                book.getYear() > FIRST_BOOK && book.getYear() < LocalDate.now().getYear() &&
                book.getNumberPages() != 0;
    }
}
