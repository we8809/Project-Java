package academy.pocu.comp2500.lab8.app;

import academy.pocu.comp2500.lab8.Drainer;
import academy.pocu.comp2500.lab8.Planter;
import academy.pocu.comp2500.lab8.Schedule;
import academy.pocu.comp2500.lab8.Sprinkler;

public class Program {

    public static void main(String[] args) {
	    // write your code here

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
        test19();
        test20();
        test21();
        test22();
    }

    static public void test1() {
        /* test 1 */
        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(0, 4));
            sprinkler.addSchedule(new Schedule(1, 4));
            sprinkler.addSchedule(new Schedule(2, 3));
            sprinkler.addSchedule(new Schedule(6, 4));

            boolean[] expectedIsOn = new boolean[] {
                    false, true, true, true, true, false, true,
                    true, true, true, false, false, false
            };

            for (int i = 0; i < expectedIsOn.length; ++i) {
                assert (expectedIsOn[i] == sprinkler.isOn());
                System.out.println(String.format("Tick = [%d], isOn = [%s]", i, sprinkler.isOn()));
                sprinkler.onTick();
            }

            System.out.println("test1() complete");
        }
    }

    static public void test2() {
        /* test 2 */
        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(3, 20));
            Drainer drainer = new Drainer(50);

            Planter planter = new Planter(0);
            planter.installSmartDevice(sprinkler);
            planter.installSmartDevice(drainer);

            int[] expectedWaterAmount = new int[]{0, 0, 0, 13, 26, 39, 52, 58, 64, 70,
                    76, 82, 88, 94, 100, 106, 112, 118, 124, 130,
                    136, 142, 148, 139, 130, 121, 112, 103, 94, 85,
                    76, 67, 58, 49, 47, 45, 43, 41, 39, 37,
                    35, 33, 31, 29, 27, 25, 23, 21, 19, 17};

            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 2, 0, 1, 2, 3, 4, 5, 6,
                    7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                    17, 18, 19, 0, 1, 2, 3, 4, 5, 6,
                    7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                    17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
            int[] drainerTicksSinceLastUpdate = new int[]{0, 1, 2, 3, 4, 5, 6, 0, 1, 2,
                    3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                    13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                    23, 24, 25, 26, 0, 1, 2, 3, 4, 5,
                    6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

            for (int i = 0; i < expectedWaterAmount.length; ++i) {
                System.out.println(String.format("water = %d", planter.getWaterAmount()));
                //System.out.println(String.format("drainer sinceLastUpdate = %d", drainer.getTicksSinceLastUpdate()));
                assert (expectedWaterAmount[i] == planter.getWaterAmount()) : i;
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate()) : i;
                assert (drainerTicksSinceLastUpdate[i] == drainer.getTicksSinceLastUpdate()) : i;
                planter.tick();
            }

            System.out.println("test2() complete");
        }
    }

    static public void test3() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(1, 2));
        sprinkler.addSchedule(new Schedule(10, 2));
        sprinkler.addSchedule(new Schedule(5, 3));

        boolean[] expectedIsOn = new boolean[] {
                false, true, true, false, false,
                false, false, false, false, false,
                true, true, false, false, false
        };

        int[] sprinklerTicksSinceLastUpdate = new int[] {
                0, 0, 1, 0, 1,
                2, 3, 4, 5, 6,
                0, 1, 0, 1, 2
        };

        boolean b1 = false;
        boolean b2 = false;
        int tick1 = 0;
        int tick2 = 0;

        for (int i = 0; i < expectedIsOn.length; ++i) {
            b1 = expectedIsOn[i];
            b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            tick1 = sprinklerTicksSinceLastUpdate[i];
            tick2 = sprinkler.getTicksSinceLastUpdate();
            assert (tick1 == tick2) : i;

            sprinkler.onTick();
        }

        System.out.println("test3() complete");
    }

    static public void test4() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(4, 8));
        sprinkler.addSchedule(new Schedule(3, 4));

        boolean[] expectedIsOn = new boolean[] {
                false, false, true, true, true, true, true,
                false, false, false, false, false, false, false, false
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            //System.out.println(String.format("[%d], %s", i, sprinkler.isOn() ? "true" : "false"));
            assert (expectedIsOn[i] == sprinkler.isOn()) : i;
            sprinkler.onTick();
        }

        System.out.println("test4() complete");
    }

    static public void test5() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(1, 2));
        sprinkler.addSchedule(new Schedule(10, 2));
        sprinkler.addSchedule(new Schedule(5, 3));

        Planter planter = new Planter(0);

        planter.installSmartDevice(sprinkler);

        boolean[] expectedIsOn = new boolean[] {
                false, true, true, false, false,
                false, false, false, false, false,
                true, true, false, false, false
        };

        int[] expectedWater = new int[] {
                0, 13, 26, 24, 22,
                20, 18, 16, 14, 12,
                25, 38, 36, 34, 32
        };

        int[] expectedTick = new int[]{
                0, 0, 1, 0, 1,
                2, 3, 4, 5, 6,
                0, 1, 0, 1, 2
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }

        System.out.println("test5() complete");
    }

    static public void test6() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(4, 8));
        sprinkler.addSchedule(new Schedule(3, 4));

        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        boolean[] expectedIsOn = new boolean[]{
                false, false, true, true, true,
                true, true, false, false, false,
                false, false, false, false, false
        };

        int[] expectedWater = new int[]{
                0, 0, 13, 26, 39,
                52, 65, 63, 61, 59,
                57, 55, 53, 51, 49
        };

        int[] expectedTick = new int[]{
                0, 1, 0, 1, 2,
                3, 4, 0, 1, 2,
                3, 4, 5, 6, 7
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }

        System.out.println("test6() complete");
    }

    static public void test7() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(2, 5));

        Planter planter = new Planter(0);

        planter.installSmartDevice(sprinkler);

        boolean[] expectedIsOn = new boolean[] {
                false, false, true, true, true,
                true, true, false, false, false,
                false, false, false, false, false
        };

        int[] expectedWater = new int[] {
                0, 0, 13, 26, 39,
                52, 65, 63, 61, 59,
                57, 55, 53, 51, 49
        };

        int[] expectedTick = new int[]{
                0, 1, 0, 1, 2,
                3, 4, 0, 1, 2,
                3, 4, 5, 6, 7
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }

        System.out.println("test7() complete");
    }

    public static void test8() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(1, 1));
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(2, 5));

        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);

        boolean[] expectedIsOn = new boolean[]{
                false, true, false, false, false,
                false, false, false, false, false
        };

        int[] expectedWater = new int[]{
                0, 13, 11, 9, 7,
                5, 3, 1, 0, 0
        };

        int[] expectedTick = new int[]{
                0, 0, 0, 1, 2,
                3, 4, 5, 6, 7
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }

        System.out.println("test8() complete");
    }

    public static void test9(){
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(3, 20));

        Drainer drainer = new Drainer(0);

        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        planter.installSmartDevice(drainer);

        int[] expectedWater = new int[]{
                0, 0, 0, 6, 12,
                18, 24, 30, 36, 42,
                48, 54, 60, 66, 72,
                78, 84, 90, 96, 102,
                108, 114, 120, 111, 102,
                93, 84, 75, 66, 57
        };

        int[] sprinklerTicksSinceLastUpdate = new int[]{
                0, 1, 2, 0, 1,
                2, 3, 4, 5, 6,
                7, 8, 9, 10, 11,
                12, 13, 14, 15, 16,
                17, 18, 19, 0, 1,
                2, 3, 4, 5, 6
        };

        int[] drainerTicksSinceLastUpdate = new int[]{
                0, 0, 1, 2, 3,
                4, 5, 6, 7, 8,
                9, 10, 11, 12, 13,
                14, 15, 16, 17, 18,
                19, 20, 21, 22, 23,
                24, 25, 26, 27, 28
        };

        for (int i = 0; i < expectedWater.length; ++i) {
            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int st1 = sprinklerTicksSinceLastUpdate[i];
            int st2 = sprinkler.getTicksSinceLastUpdate();
            assert (st1 == st2) : i;

            int dt1 = drainerTicksSinceLastUpdate[i];
            int dt2 = drainer.getTicksSinceLastUpdate();
            assert (dt1 == dt2) : i;

            planter.tick();
        }

        System.out.println("test9() complete");
    }

    public static void test10() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(12, 6));
        sprinkler.addSchedule(new Schedule(19, 10));
        sprinkler.addSchedule(new Schedule(36, 10));
        sprinkler.addSchedule(new Schedule(51, 2));
        sprinkler.addSchedule(new Schedule(64, 7));
        sprinkler.addSchedule(new Schedule(86, 10));
        sprinkler.addSchedule(new Schedule(103, 2));

        Drainer drainer = new Drainer(76);

        Planter planter = new Planter(96);

        planter.installSmartDevice(sprinkler);
        planter.installSmartDevice(drainer);

        for (int i = 0; i < 106; ++i) {
            if (i > 60) {
                //System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
                //System.out.println(String.format("drainer is on? = [%s]", drainer.isOn()));
            }

            planter.tick();
        }

        System.out.println("test10() complete");
    }

    public static void test11() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(1, 9));
        sprinkler.addSchedule(new Schedule(21, 10));
        sprinkler.addSchedule(new Schedule(36, 9));
        sprinkler.addSchedule(new Schedule(49, 7));
        sprinkler.addSchedule(new Schedule(72, 7));
        sprinkler.addSchedule(new Schedule(95, 3));
        sprinkler.addSchedule(new Schedule(105, 3));

        Drainer drainer = new Drainer(110);

        Planter planter = new Planter(13);

        planter.installSmartDevice(sprinkler);

        for (int i = 0; i < 110; ++i) {
            //System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
            //System.out.println(String.format("drainer is on? = [%s]", drainer.isOn()));
            planter.tick();
        }

        planter.installSmartDevice(drainer);

        System.out.println("test11() complete");
    }

    public static void test12() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(0, 4));
        sprinkler.addSchedule(new Schedule(1, 4));
        boolean[] expectedIsOn = new boolean[]{
                false, true, true, true, true
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            assert (expectedIsOn[i] == sprinkler.isOn());
            sprinkler.onTick();
        }

        sprinkler.addSchedule(new Schedule(2, 6));
        sprinkler.addSchedule(new Schedule(6, 4));

        boolean[] expectedIsOn1 = new boolean[] {
                false, false,
                false, false, false, false, false, false
        };

        for (int i = 0; i < expectedIsOn1.length; ++i) {
            System.out.println(String.format("isOn = [%s]", sprinkler.isOn()));
            assert (expectedIsOn1[i] == sprinkler.isOn()) : i;
            sprinkler.onTick();
        }

        System.out.println("test12() complete");
    }

    public static void test13() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(11, 1));
        sprinkler.addSchedule(new Schedule(16, 9));
        sprinkler.addSchedule(new Schedule(36, 7));
        sprinkler.addSchedule(new Schedule(56, 9));
        sprinkler.addSchedule(new Schedule(75, 4));
        sprinkler.addSchedule(new Schedule(89, 8));
        sprinkler.addSchedule(new Schedule(101, 8));
        sprinkler.addSchedule(new Schedule(117, 10));
        sprinkler.addSchedule(new Schedule(138, 9));

        Drainer drainer = new Drainer(87);

        Planter planter = new Planter(91);

        planter.installSmartDevice(sprinkler);
        planter.installSmartDevice(drainer);

        for (int i = 0; i < 110; ++i) {
            //System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
            //System.out.println(String.format("drainer is on? = [%s]", drainer.isOn()));
            planter.tick();
        }

        System.out.println("test13() complete");
    }

    public static void test14() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(12, 7));
        sprinkler.addSchedule(new Schedule(28, 9));
        sprinkler.addSchedule(new Schedule(51, 3));
        sprinkler.addSchedule(new Schedule(60, 6));
        sprinkler.addSchedule(new Schedule(70, 2));
        sprinkler.addSchedule(new Schedule(84, 8));
        sprinkler.addSchedule(new Schedule(95, 7));
        sprinkler.addSchedule(new Schedule(114, 5));
        sprinkler.addSchedule(new Schedule(128, 10));
        sprinkler.addSchedule(new Schedule(149, 5));

        Drainer drainer = new Drainer(109);

        Planter planter = new Planter(94);

        planter.installSmartDevice(sprinkler);
        planter.installSmartDevice(drainer);

        for (int i = 0; i < 110; ++i) {
            //System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
            //System.out.println(String.format("drainer is on? = [%s]", drainer.isOn()));
            planter.tick();
        }

        System.out.println("test14() complete");
    }

    public static void test15() {
        Sprinkler sprinkler1 = new Sprinkler();
        Sprinkler sprinkler2 = new Sprinkler();

        sprinkler1.addSchedule(new Schedule(0, 4));
        sprinkler1.addSchedule(new Schedule(1, 4));
        sprinkler2.addSchedule(new Schedule(0, 4));
        sprinkler2.addSchedule(new Schedule(1, 4));

        Drainer drainer1 = new Drainer(50);
        Drainer drainer2 = new Drainer(50);

        Planter planter = new Planter(0);

        planter.installSmartDevice(sprinkler1);
        planter.installSmartDevice(sprinkler2);
        planter.installSmartDevice(drainer1);
        planter.installSmartDevice(drainer2);

        boolean[] expectedIsOn = new boolean[] {
                false, true, true, true, true, false, true,
                true, true, true, false, false, false
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
            planter.tick();
        }

        System.out.println("test15() complete");
    }

    public static void test16() {
        Sprinkler sprinkler = new Sprinkler();

        Planter planter = new Planter(0);

        sprinkler.addSchedule(new Schedule(0, 4));
        sprinkler.addSchedule(new Schedule(1, 4));
        sprinkler.addSchedule(new Schedule(2, 3));

        boolean[] expectedIsOn = new boolean[] {
                false, true, true, true, true
        };

        for (boolean b : expectedIsOn) {
            assert (b == sprinkler.isOn());
            sprinkler.onTick();
        }

        planter.installSmartDevice(sprinkler);

        boolean[] expectedIsOn1 = new boolean[] {
                false, false, false, false, false, false, false, false
        };

        for (boolean b : expectedIsOn1) {
            assert (b == sprinkler.isOn());
            planter.tick();
        }

        System.out.println("test16() complete");
    }

    public static void test17() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(0, 1));
        sprinkler.addSchedule(new Schedule(2, 1));
        sprinkler.addSchedule(new Schedule(1, 10));
        sprinkler.addSchedule(new Schedule(3, 1));
        sprinkler.addSchedule(new Schedule(6, 1));
        sprinkler.addSchedule(new Schedule(9, 1));

        boolean[] expectedIsOn = new boolean[] {
                false, false, true, false, false, false,
                false, false, false, false, false, false
        };

        for (boolean b : expectedIsOn) {
            assert (b == sprinkler.isOn());
            sprinkler.onTick();
        }
        System.out.println("test17() complete");
    }

    public static void test18() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(2, 1));
        sprinkler.addSchedule(new Schedule(4, 8));
        sprinkler.addSchedule(new Schedule(3, 4));

        boolean[] expectedIsOn = new boolean[] {
                false, false, true, false, true, true, true,
                true, true, true, true, true, false, false
        };

        for (boolean b : expectedIsOn) {
            //System.out.println(String.format("b = [%s]", sprinkler.isOn()));
            assert (b == sprinkler.isOn());
            sprinkler.onTick();
        }

        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);

        sprinkler.addSchedule(new Schedule(14, 4));

        for (int i = 0; i < 10; ++i) {
            //System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
            planter.tick();
        }

        System.out.println("test18() complete");
    }

    public static void test19() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(0, 4));
        sprinkler.addSchedule(new Schedule(1, 4));

        boolean[] expectedIsOn = new boolean[] {
                false, true, true, true, true
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            assert (expectedIsOn[i] == sprinkler.isOn());
            sprinkler.onTick();
        }

        sprinkler.addSchedule(new Schedule(2, 3));
        sprinkler.addSchedule(new Schedule(6, 4));

        boolean[] expectedIsOn1 = new boolean[] {
                false, true, true, true, true,
                false, false, false
        };

        for (int i = 0; i < expectedIsOn1.length; ++i) {
            assert (expectedIsOn1[i] == sprinkler.isOn()): i;
            sprinkler.onTick();
        }

        System.out.println("test19() complete");
    }

    public static void test20() {
        Sprinkler sprinkler = new Sprinkler();
        Planter planter = new Planter(0);

        sprinkler.addSchedule(new Schedule(0, 4));
        sprinkler.addSchedule(new Schedule(1, 4));
        sprinkler.addSchedule(new Schedule(2, 3));

        boolean[] expectedIsOn = new boolean[] {
                false, true, true, true, true
        };

        for (boolean b : expectedIsOn) {
            assert (b == sprinkler.isOn());
            sprinkler.onTick();
        }

        planter.installSmartDevice(sprinkler);

        expectedIsOn = new boolean[] {
                false, false, false, false, false,
                false, false, false
        };

        for (boolean b : expectedIsOn) {
            assert (b == sprinkler.isOn());
            planter.tick();
        }

        System.out.println("test20() complete");
    }

    public static void test21() {
        Sprinkler sprinkler = new Sprinkler();
        Planter planter = new Planter(0);

        sprinkler.addSchedule(new Schedule(0, 1));
        sprinkler.addSchedule(new Schedule(2, 1));
        sprinkler.addSchedule(new Schedule(1, 10));
        sprinkler.addSchedule(new Schedule(3, 1));
        sprinkler.addSchedule(new Schedule(6, 1));
        sprinkler.addSchedule(new Schedule(9, 1));

        boolean[] expectedIsOn = new boolean[] {
                false, false, true, false, false,
                false, false, false, false, false,
                false, false
        };

        for (boolean b : expectedIsOn) {
            assert (b == sprinkler.isOn());
            sprinkler.onTick();
        }

        System.out.println("test21() complete");
    }

    public static void test22() {
        Sprinkler sprinkler1 = new Sprinkler();
        Sprinkler sprinkler2 = new Sprinkler();

        sprinkler1.addSchedule(new Schedule(1, 3));
        //sprinkler2.addSchedule(new Schedule(1, 3));

        Planter planter = new Planter(0);
        Drainer drainer1 = new Drainer(10);
        Drainer drainer2 = new Drainer(10);

        planter.installSmartDevice(sprinkler1);
        planter.installSmartDevice(sprinkler2);
        planter.installSmartDevice(drainer1);
        planter.installSmartDevice(drainer2);

        int[] remainingWater = new int[] {
                0, 13,
        };

        for (int i = 0; i < 10; ++i) {
            System.out.println(String.format("Tick = [%d], remaining water = [%d]", i, planter.getWaterAmount()));
            planter.tick();
        }

        System.out.println("test22() complete");
    }
}
