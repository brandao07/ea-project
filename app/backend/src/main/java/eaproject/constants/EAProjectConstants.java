package eaproject.constants;

public final class EAProjectConstants {

    // Prevent instantiation
    private EAProjectConstants() {
        throw new UnsupportedOperationException("This is a constants class and cannot be instantiated!");
    }

    // <editor-fold desc="Role">
    public static final String ROLE_DEFAULT = "Default";
    public static final String ROLE_ADMIN = "Administrator";
    public static final String ROLE_PARTICIPANT = "Participant";
    public static final String ROLE_JUDGE = "Judge";
    // </editor-fold>
}
