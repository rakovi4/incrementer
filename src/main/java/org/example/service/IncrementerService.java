package org.example.service;

import org.example.incrementer.CASIncrementer;
import org.example.incrementer.IIncrementer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class IncrementerService {

    @Inject
    private IIncrementer incrementer;

    public int getNumber() {
        return incrementer.getNumber();
    }

    public void incrementNumber() {
        incrementer.incrementNumber();
    }

    public void setMaximumValue(int maximumValue) {
        incrementer.setMaximumValue(maximumValue);
    }
}