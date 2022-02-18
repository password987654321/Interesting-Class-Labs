public class Squares {
   public static void main (final String[] args) {
      final double ratio = Double.parseDouble(args[0]);
      final int level = Integer.parseInt(args[1]);
      final int patternNumber = Integer.parseInt(args[2]);
      final int WIDTH = 800;
      final int HEIGHT = 800;
      final int MAX_SCALE = 1;
      final int MIN_SCALE = -1;
      final double x = 0, y = 0;
      final double side = 1;
      final int currentLevel = 1;

      // Sets window size and ratio.
      StdDraw.setCanvasSize(WIDTH, HEIGHT);
      StdDraw.setScale(MIN_SCALE, MAX_SCALE);
      
      // Determines the pattern created in the window.
      if (patternNumber == 1) {
         squareRecurse1(ratio, level, x, y, currentLevel, side);
      }
      else if (patternNumber == 2) {
         squareRecurse2(ratio, level, x, y, currentLevel, side);
      }
      else if (patternNumber == 3) {
         squareRecurse3(ratio, level, x, y, currentLevel, side);
      }
      else if (patternNumber == 4) {
         squareRecurse4(ratio, level, x, y, currentLevel, side);
      }
   }

   // Draws all the squares the same way.
   public static void drawSquare (final double x, final double y, final double side) {
      StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      StdDraw.filledSquare(x, y, side / 2);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.square(x, y, side / 2);
   }

   // Creates pattern for pattern option 1.
   public static void squareRecurse1 (final double rat, final int lev, 
         final double x, final double y, final int n, final double side) {
      if (n > lev) {
         return;
      }
      // Big on top and smaller on bottom.
      squareRecurse1(rat, lev, (x - (side / 2)), (y - (side / 2)), n + 1, (side / rat));
      squareRecurse1(rat, lev, (x + (side / 2)), (y - (side / 2)), n + 1, (side / rat));
      squareRecurse1(rat, lev, (x - (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      squareRecurse1(rat, lev, (x + (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      drawSquare(x, y, side);
   }

   // Creates pattern for pattern option 2.
   public static void squareRecurse2 (final double rat, final int lev, 
         final double x, final double y, final int n, final double side) {
      if (n > lev) {
         return;
      }
      // Bottom-right on top and rest on bottom.
      squareRecurse2(rat, lev, (x - (side / 2)), (y - (side / 2)), n + 1, (side / rat));
      squareRecurse2(rat, lev, (x + (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      squareRecurse2(rat, lev, (x - (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      drawSquare(x, y, side);
      squareRecurse2(rat, lev, (x + (side / 2)), (y - (side / 2)), n + 1, (side / rat));
   }

   // Creates pattern for pattern option 3.
   public static void squareRecurse3 (final double rat, final int lev, 
         final double x, final double y, final int n, final double side) {
      if (n > lev) {
         return;
      }
      // Small on top and bigger on bottom.
      drawSquare(x, y, side);
      squareRecurse3(rat, lev, (x - (side / 2)), (y - (side / 2)), n + 1, (side / rat));
      squareRecurse3(rat, lev, (x + (side / 2)), (y - (side / 2)), n + 1, (side / rat));
      squareRecurse3(rat, lev, (x - (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      squareRecurse3(rat, lev, (x + (side / 2)), (y + (side / 2)), n + 1, (side / rat));
   }

   // Creates pattern for pattern option 4.
   public static void squareRecurse4 (final double rat, final int lev, 
         final double x, final double y, final int n, final double side) {
      if (n > lev) {
         return;
      }
      // Bottom two first and top last.
      squareRecurse4(rat, lev, (x + (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      squareRecurse4(rat, lev, (x - (side / 2)), (y + (side / 2)), n + 1, (side / rat));
      drawSquare(x, y, side);
      squareRecurse4(rat, lev, (x - (side / 2)), (y - (side / 2)), n + 1, (side / rat));
      squareRecurse4(rat, lev, (x + (side / 2)), (y - (side / 2)), n + 1, (side / rat));
   }
}
