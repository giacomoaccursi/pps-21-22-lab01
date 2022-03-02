import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;
    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
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
    void testNextEven(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        assertEquals(2, circularList.next(new evenStrategy()).orElseThrow());
        assertEquals(4, circularList.next(new evenStrategy()).orElseThrow());
        assertEquals(2, circularList.next(new evenStrategy()).orElseThrow());
    }

    @Test
    void testNextEvenWithoutAnyMatch(){
        circularList.add(1);
        circularList.add(3);
        circularList.add(5);
        assertEquals(Optional.empty(), circularList.next(new evenStrategy()));
    }

    
}
