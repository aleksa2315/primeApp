package errorHandler;

public interface ErrorHandler {
    void generateError(ErrorType errorType);
    void generateError(ErrorType errorType, String data);
}
