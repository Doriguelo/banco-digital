package util;

public class AccountNumberGenerator {

    private static int sequence = 1000;

    public static int generateNumber() {
        return ++sequence;
    }
}
