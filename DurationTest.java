package cs410;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DurationTest {
    @org.junit.jupiter.api.Test
    public void testTsecond() {
        Duration dura = Duration.of(1, 15, 00);// 1 hour and 15 minutes

        assertEquals("1:15:00", dura.toString());
    }
    @org.junit.jupiter.api.Test
    public void testof() {
        Duration dura = Duration.of(3, 30, 45); // 3 hr , 30 minutes, 45 sec
        assertEquals("3:30:45", dura.toString());
    }
    @org.junit.jupiter.api.Test
    public void testAdd(){

        Duration dura1 = Duration.of(3,30,45);// 3hr 30 min and 45sec
        Duration dura2 = Duration.of(1,45,00); // 1hr, 15 min, 00sec
        Duration  res = dura1.add(dura2);

        assertEquals("5:15:45", res.toString());
    }
    @org.junit.jupiter.api.Test
    public void testTostring(){
        Duration dura = Duration.of(3,30,45); //3hr, 3o minutes and 45sec
        assertEquals("3:30:45", dura.toString());
    }

}