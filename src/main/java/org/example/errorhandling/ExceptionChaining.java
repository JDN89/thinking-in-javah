package org.example.errorhandling;

public class ExceptionChaining {
}
class ExceptionChainingExample {

    public static void main(String[] args) {
        try {
            higherLevelMethod();
        } catch (HighLevelException e) {
            e.printStackTrace();
        }
    }

    public static void higherLevelMethod() throws HighLevelException {
        try {
            lowerLevelMethod();
        } catch (LowerLevelException e) {
            // Catch the lower-level exception and throw a new high-level exception
            // with the lower-level exception attached as the cause.
            throw new HighLevelException("Something went wrong in the higher level method", e);
        }
    }

    public static void lowerLevelMethod() throws LowerLevelException {
        // Simulate a lower-level exception
        throw new LowerLevelException("Something went wrong in the lower level method");
    }

    // Custom lower-level exception
    public static class LowerLevelException extends Exception {
        public LowerLevelException(String message) {
            super(message);
        }
    }

    // Custom high-level exception
    public static class HighLevelException extends Exception {
        public HighLevelException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}