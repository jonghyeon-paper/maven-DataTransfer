package data.transfer.exception;

/**
 * 데이터 변형 예외 클래스
 * @author jonghyeon
 *
 */
public class DataTransferException extends Exception {
	
	private static final long serialVersionUID = 588842341407161946L;
	
	public DataTransferException() {
		super();
	}
	
	public DataTransferException(String message) {
		super(message);
	}
	
	public DataTransferException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
