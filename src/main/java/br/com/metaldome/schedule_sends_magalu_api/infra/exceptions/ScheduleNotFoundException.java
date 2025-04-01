package br.com.metaldome.schedule_sends_magalu_api.infra.exceptions;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException(String message) {super(message);}
}

