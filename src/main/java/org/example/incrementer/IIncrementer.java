package org.example.incrementor;

/**
 * Incrementer interface. Increments number, sets number to zero
 * after it reaches max value. Initially number equals to zero, max
 * value equals to Integer.MAX_VALUE
 */
public interface IIncrementer {

    /**
     * Возвращает текущее число. В самом начале это ноль.
     */
    int getNumber();

    /**
     * Увеличивает текущее число на один. После каждого вызова этого
     * метода getNumber() будет возвращать число на один больше.
     */
    void incrementNumber();

    /**
     * Устанавливает максимальное значение текущего числа.
     * Когда при вызове incrementNumber() текущее число достигает
     * этого значения, оно обнуляется, т.е. getNumber() начинает
     * снова возвращать ноль, и снова один после следующего
     * вызова incrementNumber() и так далее.
     * По умолчанию максимум -- максимальное значение int.
     * Если при смене максимального значения число резко начинает
     * превышать максимальное значение, то число надо обнулить.
     * Нельзя позволять установить тут число меньше нуля.
     */
    void setMaximumValue(int maximumValue);

}
