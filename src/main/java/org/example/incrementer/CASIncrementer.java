package org.example.incrementer;

import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Non-blocking compare-and-swap based (thread-safe) IIncrementer implementation.
 * Increments number, sets number to zero after it reaches max value. Initially
 * number equals to zero, max value equals to Integer.MAX_VALUE
 */
@ApplicationScoped
@Default
public class CASIncrementer implements IIncrementer {

    AtomicReference<IncAndMaxPair> incAndMaxPair =
            new AtomicReference<>(new IncAndMaxPair(0, Integer.MAX_VALUE));

    /**
     * @return current number. Initially returns zero
     */
    @Override
    public int getNumber() {
        return incAndMaxPair.get().incrementValue;
    }

    /**
     * Increments current number. Method getNumber() returns incremented number
     * after each call of that method. Sets number to zero if max value reached.
     */
    @Override
    public void incrementNumber() {
        IncAndMaxPair value;
        IncAndMaxPair next;

        do {
            value = incAndMaxPair.get();
            int incVal = (value.incrementValue == value.maximumValue)
                    ? 0 : value.incrementValue + 1;
            next = new IncAndMaxPair(incVal, value.maximumValue);
        } while ( ! incAndMaxPair.compareAndSet(value, next));
    }

    /**
     * @param maximumValue sets maximum value of incremented number. Set number
     *                     to zero if it is more than passed max value
     */
    @Override
    public void setMaximumValue(int maximumValue) {
        IncAndMaxPair value;
        IncAndMaxPair next;

        do {
            value = incAndMaxPair.get();
            int incVal = (value.incrementValue > maximumValue)
                    ? 0 : value.incrementValue;
            next = new IncAndMaxPair(incVal, maximumValue);
        } while ( ! incAndMaxPair.compareAndSet(value, next));
    }

    /**
     * Nested class for atomic change of number and max value
     */
    @AllArgsConstructor
    private class IncAndMaxPair {
        private final int incrementValue;
        private final int maximumValue;
    }

}