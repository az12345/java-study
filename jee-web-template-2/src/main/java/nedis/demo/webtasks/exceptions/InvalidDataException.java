package nedis.demo.webtasks.exceptions;

/**
 * @author nedis
 * @version 1.0
 */
public class InvalidDataException extends Exception {
	private static final long serialVersionUID = 2025717014644106349L;

	public InvalidDataException(String message) {
		super(message);
	}

	public InvalidDataException(Throwable cause) {
		super(cause);
	}

	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
	}

}
