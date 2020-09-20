package by.epam.dedik.day6.service;

public class UniqueIdService {
    private static int NEXT_ID = 0;

    private UniqueIdService() {
    }

    public static int getId() {
        return ++NEXT_ID;
    }
}
