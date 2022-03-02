import lab01.tdd.*;
import lab01.tdd.SelectStrategy.SelectStrategyFactory.SelectStrategyFactory;
import lab01.tdd.SelectStrategy.SelectStrategyFactory.SelectStrategyFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;
    SelectStrategyFactory selectStrategyFactory;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        selectStrategyFactory = new SelectStrategyFactoryImpl();
    }

    @Test
    void testListIsEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAdd(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSize(){
        circularList.add(1);
        assertEquals(1, circularList.size());
    }

    @Test
    void testNext(){
        assertEquals(Optional.empty(), circularList.next());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(1, circularList.next().orElseThrow());
        assertEquals(2, circularList.next().orElseThrow());
        assertEquals(3, circularList.next().orElseThrow());
        assertEquals(1, circularList.next().orElseThrow());
    }

    @Test
    void testPrevious(){
        assertEquals(Optional.empty(), circularList.previous());
        circularList.add(1);
        assertEquals(1, circularList.previous().orElseThrow());
        circularList.add(2);
        circularList.add(3);
        assertEquals(3, circularList.previous().orElseThrow());
        assertEquals(2, circularList.previous().orElseThrow());
        assertEquals(1, circularList.previous().orElseThrow());
        assertEquals(3, circularList.previous().orElseThrow());

    }

    @Test
    void testReset(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(1, circularList.next().orElseThrow());
        circularList.reset();
        assertEquals(3, circularList.previous().orElseThrow());
    }

    @Test
    void testNextEvenStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        assertEquals(2, circularList.next(selectStrategyFactory.createEvenStrategy()).orElseThrow());
        assertEquals(4, circularList.next(selectStrategyFactory.createEvenStrategy()).orElseThrow());
        assertEquals(2, circularList.next(selectStrategyFactory.createEvenStrategy()).orElseThrow());
    }

    @Test
    void testMultipleOfStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.next();
        assertEquals(2, circularList.next(selectStrategyFactory.createMultipleOfStrategy(2)).orElseThrow());
        assertEquals(4, circularList.next(selectStrategyFactory.createMultipleOfStrategy(2)).orElseThrow());
    }

    @Test
    void testEqualsStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.next();
        assertEquals(2, circularList.next(selectStrategyFactory.createEqualsStrategy(2)).orElseThrow());
        assertEquals(4, circularList.next(selectStrategyFactory.createEqualsStrategy(4)).orElseThrow());
    }

    @Test
    void testStrategyWithoutAnyMatch(){
        circularList.add(1);
        circularList.add(3);
        circularList.add(5);
        assertEquals(Optional.empty(), circularList.next(selectStrategyFactory.createEvenStrategy()));
        assertEquals(Optional.empty(), circularList.next(selectStrategyFactory.createMultipleOfStrategy(2)));
        assertEquals(Optional.empty(), circularList.next(selectStrategyFactory.createEqualsStrategy(2)));
    }
}
