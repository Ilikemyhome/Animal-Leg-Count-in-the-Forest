import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountLegsTest {

    @Test
    void countFourLegs() {
        String[] test1 = new String[]{"frog", "horse", "spider", "ant"}; // 1
        String[] test2 = new String[]{"frog", "horse", "spider", "ant","lion", "monkey", "deer", "snake", "elephant"};
        //4
        String[] test3 = new String[]{"horse", "spider", "ant","lion","lion"}; //3
        String[] extra = new String[]{"lion","lion","lion","lion","lion","lion"}; // 6

        String[] test4 = new String[]{"FROG","CAT","DOG"}; //2
        String[] test5 = new String[]{"spider", "ant","monkey","frog"}; // 0
        String[] test6 = new String[]{"FrOg","CaT","hOrSE","DoG","osTrich","ElePhaNt"}; //4


        assertEquals(1, CountLegs.countFourLegs(test1));
        assertEquals(4, CountLegs.countFourLegs(test2));
        assertEquals(3, CountLegs.countFourLegs(test3));
        assertEquals(6, CountLegs.countFourLegs(extra));
        assertEquals(2, CountLegs.countFourLegs(test4));
        assertEquals(0, CountLegs.countFourLegs(test5));
        assertEquals(4, CountLegs.countFourLegs(test6));
    }
}