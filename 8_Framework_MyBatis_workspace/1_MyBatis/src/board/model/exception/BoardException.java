package board.model.exception;

public class BoardException extends Exception {
	private static final long serialVersionUID = 8233070174932226621L;

	public BoardException() {
	}
	
	public BoardException(String msg) {
		super(msg);
	}
}
