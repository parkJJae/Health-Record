package example.healthrecord.exception;

public class DuplecateEmailException extends RuntimeException{
        public DuplecateEmailException(String message) {
            super(message);
        }
}
