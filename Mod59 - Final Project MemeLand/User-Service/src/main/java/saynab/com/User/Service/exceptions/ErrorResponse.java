package saynab.com.User.Service.exceptions;

public record ErrorResponse(
        String error,
        String message) {
}
