package org.example.incrementor;

/**
 * Blocking synchronized (thread-safe) implementation of IIncrementor.
 * Increments number, sets number to zero after it reaches max value. Initially
 * number equals to zero, max value equals to Integer.MAX_VALUE
 */
public class SynchronizedIncrementer implements IIncrementer {
    private volatile int incrementValue = 0;
    private int maximumValue = Integer.MAX_VALUE;

    /**
     * @return current number. Initially returns zero
     */
    @Override
    public int getNumber() {
        return incrementValue;
    }

    /**
     * Increments current number. Method getNumber() returns incremented number
     * after each call of that method. Sets number to zero if max value reached.
     */
    @Override
    public synchronized void incrementNumber() {
        incrementValue = (incrementValue == maximumValue) ? 0 : (incrementValue + 1);
    }

    /**
     * @param maximumValue sets maximum value of incremented number. Set number
     *                     to zero if it is more than passed max value
     */
    @Override
    public synchronized void setMaximumValue(int maximumValue) {
        incrementValue = (incrementValue > maximumValue) ? 0 : incrementValue;
        this.maximumValue = maximumValue;
    }
}
