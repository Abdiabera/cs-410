package cs410;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class RectangleTest {
    @Test
    public void testOf() {
        Rectangle rect1 = Rectangle.of(0, 0, 7, 7);
//to check on rectangle
        assertEquals(0, rect1.getX1());
        assertEquals(0, rect1.getY1());
        assertEquals(7, rect1.getX2());
        assertEquals(7, rect1.getY2());
    }
    @Test
    public void testInvalidRectangle(){
        //through and check if its invalid

        assertThrows(IllegalArgumentException.class, () ->{

            Rectangle.of(7,0,0,7);
        });
    }
    @Test
    public void testArea() {
        Rectangle rec = Rectangle.of(0, 0, 4, 5);
        assertEquals(20, rec.area());
    }
    @Test
    public void testContains() {
        Rectangle rectan = Rectangle.of(0, 0, 7, 7);
        assertTrue(rectan.contains(5, 5));
        assertFalse(rectan.contains(20, 20));
    }

}
