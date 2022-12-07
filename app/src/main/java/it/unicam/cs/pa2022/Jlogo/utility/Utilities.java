package it.unicam.cs.pa2022.Jlogo.utility;

/**
 * Utility class.
 */
public class Utilities {
    /**
     * Throws an exception if the given object is null.
     *
     * @param obj     the object to check
     * @param message the message to throw
     */
    public static void ThrowIfNull(Object obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
    }

}
