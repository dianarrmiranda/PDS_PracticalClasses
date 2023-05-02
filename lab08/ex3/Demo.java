import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

import startypes.*;

public class Demo {
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;
    
    public static void main(String[] args) {
        Sky sky = new Sky();

        // https://astrobackyard.com/wp-content/uploads/2020/03/types-of-stars.jpg
        HashMap <Character, StarType> starTypeMap = new HashMap<>();

        starTypeMap.put('O', new OStar());
        starTypeMap.put('B', new BStar());
        starTypeMap.put('A', new AStar());
        starTypeMap.put('F', new FStar());
        starTypeMap.put('G', new GStar());
        starTypeMap.put('K', new KStar());
        starTypeMap.put('M', new MStar());

		Runtime runtime = Runtime.getRuntime();
		long before = runtime.totalMemory() - runtime.freeMemory();
        Random random = new Random();
        char type;

        for (int i = 0; i < STARS_TO_DRAW; i++) {
            type = (char) starTypeMap.keySet().toArray()[random.nextInt(starTypeMap.size())];
            StarType s = starTypeMap.get(type);
            sky.placeStar(createStar(s));
        }
        sky.setSize(CANVAS_SIZE, CANVAS_SIZE);
        sky.setBackground(Color.BLACK);
        sky.setVisible(true);

        long after = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory: " + (after - before) / 1024 / 1024 + " MB");

    }

    private static StarFlyweight createStar(StarType type) {
        int x = random(0, CANVAS_SIZE);
        int y = random(0, CANVAS_SIZE);

        StarFlyweight star = new StarFlyweight(type, x, y);
        
        return star;
    }

	private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}