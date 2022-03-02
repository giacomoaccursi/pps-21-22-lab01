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
        assertEquals(1, circularList.next().orElseThrow());
        assertEquals(2, circularList.next().orElseThrow());
    }

    @Test
    void testPrevious(){
        assertEquals(Optional.empty(), circularList.next());
        circularList.add(1);
        circularList.add(2);
        assertEquals(1, circularList.next().orElseThrow());
        assertEquals(2, circularList.next().orElseThrow());
        assertEquals(1, circularList.next().orElseThrow());
    }

    
}
