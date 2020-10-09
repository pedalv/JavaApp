package no.agitec.fagaften.mellom.oppdrag.jsf.web;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
@Data
public class DayOfWeekResolverForm implements Serializable {
    private int year;
    private int month;
    private int dayOfMonth;

    private String dayOfWeek;
}
