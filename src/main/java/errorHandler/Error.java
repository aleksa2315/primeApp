package errorHandler;

public class Error {
    private int type;
    private String title;
    private String message;

    public Error(int type, String title, String message) {
        this.type = type;
        this.title = title;
        this.message = message;
    }
}
