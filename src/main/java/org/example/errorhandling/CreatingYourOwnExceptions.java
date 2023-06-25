package org.example.errorhandling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class CreatingYourOwnExceptions {
    public static void main(String[] args) {

    }
}

class SimpleException extends Exception {
}

class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}

// SENDING TO ERROR STREAM
class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}

// LOGGING EXCEPTIONS
// Define a custom exception class named LoggingException that extends the standard Exception class.
class LoggingException extends Exception {

    // Create a static logger instance that is tied to the "LoggingException" logger.
    // This logger can be used to log messages, in this case, we will use it for logging stack traces.
    private static Logger logger = Logger.getLogger("LoggingException");

    // Define the constructor of LoggingException.
    public LoggingException() {
        // Create a StringWriter which will be used to convert the stack trace to a String.
        StringWriter trace = new StringWriter();

        // printStackTrace method prints the stack trace of this exception to the specified PrintWriter.
        // This is basically converting the stack trace to a String.
        printStackTrace(new PrintWriter(trace));

        // Use the logger to log the stack trace as a SEVERE log message.
        logger.severe(trace.toString());
    }
}

class LoggingExceptions {
    public static void main(String[] args) {

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            // Catch block catches the LoggingException and prints a message to the standard error stream.
            System.err.println("Caught " + e);
        }
    }
}

//it’s more common that you will be catching and logging
//        someone else’s exception, so you must generate the log message in the exception handler
class LoggingExceptions2 {
    private static Logger logger =
            Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}

//    The process of creating your own exceptions can be taken further. You can add extra
//    constructors and members:
class MyException2 extends Exception {
    private int x;

    public MyException2() {
    }

    public MyException2(String msg) {
        super(msg);
    }

    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }

    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
//            Prints the Throwable and the Throwable’s call stack trace
//            The call stack shows the
//            sequence of method calls that brought you to the point at which the exception was thrown.
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}