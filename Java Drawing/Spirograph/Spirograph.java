public class Spirograph {
   public static void main (final String[] args) {
      final double R = Integer.parseInt(args[0]);
      final double r = Integer.parseInt(args[1]);
      final double a = Integer.parseInt(args[2]);
      final int WIDTH = 610;
      final int HEIGHT = 609;
      final int SCALE_MIN = -400;
      final int SCALE_MAX = 400;
      final double INCREMENT = 0.01;
      double x, y;

      // Configures colors and size of frame.
      StdDraw.setCanvasSize(WIDTH, HEIGHT);
      StdDraw.setScale(SCALE_MIN, SCALE_MAX);
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

      // Places points to create image.
      for (double t = 0; t <= 100000; t += INCREMENT) {
         x = ((R + r) * Math.cos(t)) - ((r + a) * Math.cos(((R + r) / r) * t));
         y = ((R + r) * Math.sin(t)) - ((r + a) * Math.sin(((R + r) / r) * t));
         StdDraw.point(x, y);
      }
   }
}
