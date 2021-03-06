package com.tmc.exception;

public class TimesheetNotFoundException extends RuntimeException{
    public TimesheetNotFoundException() {
    }
    public TimesheetNotFoundException(String message) {
        super(message);
    }
    public TimesheetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public TimesheetNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        String message = "TimesheetNotFoundException: {Could not find timesheet: " + this.getMessage()  + "}";
        return message;
    }
}
