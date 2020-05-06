package org.example.incrementer;

import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import org.example.incrementer.CASIncrementer;
import org.example.incrementer.IIncrementer;
import org.example.incrementer.SynchronizedIncrementer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
@AllArgsConstructor
public class IncrementerTest extends TestCase {
    private final Class<? extends IIncrementer> incClazz;

    @Test
    public void testGetNumber_afterInit_ShouldReturn0() throws IllegalAccessException, InstantiationException {
        IIncrementer incrementer = incClazz.newInstance();

        assertEquals(0, incrementer.getNumber());
    }

    @Test
    public void testIncrementNumber_afterSingleInc_shouldReturn1() throws IllegalAccessException, InstantiationException {
        IIncrementer incrementer = incClazz.newInstance();

        incrementer.incrementNumber();

        assertEquals(1, incrementer.getNumber());
    }

    @Test
    public void testIncrementNumber_MaxIs1AndDoubleIncCalled_shouldReturn0() throws IllegalAccessException, InstantiationException {
        IIncrementer incrementer = incClazz.newInstance();

        incrementer.setMaximumValue(1);
        incrementer.incrementNumber();
        incrementer.incrementNumber();

        assertEquals(0, incrementer.getNumber());
    }

    @Test
    public void testGetMaximumValue_MaxLessThanInc_shouldReturn0() throws IllegalAccessException, InstantiationException {
        IIncrementer incrementer = incClazz.newInstance();

        incrementer.incrementNumber();
        incrementer.incrementNumber();
        incrementer.setMaximumValue(1);

        assertEquals(0, incrementer.getNumber());
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        return Arrays.asList(new Object[][] {
                { CASIncrementer.class },
                { SynchronizedIncrementer.class }
        });
    }
}
