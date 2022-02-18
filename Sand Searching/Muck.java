import java.util.Scanner;
public class Muck {
   public static void main (final String[] args) {
      final Scanner stdin = new Scanner(System.in, "US-ASCII");
      final int[] input = new int[2];

      // Takes in input.
      for (int i = 0; i < input.length; i++) {
         input[i] = stdin.nextInt();
      }
      final char[][] plot = new char[input[0]][input[1]];
      final String[] stringIn = new String[input[0]];
      for (int i = 0; i < input[0]; i++) {
         stringIn[i] = stdin.next();
      }

      // Converts input array into 2D array.
      for (int i = 0; i < input[0]; i++) {
         for (int j = 0; j < input[1]; j++) {
            plot[i][j] = stringIn[i].charAt(j);
         }
      }
      stdin.close();

      // Scans 2D array for sand blocks and executes sandFill.
      int answer = 0;
      for (int i = 0; i < input[0]; i++) {
         for (int j = 0; j < input[1]; j++) {
            if (plot[i][j] == '.') {
               answer += 1;
               sandFill(i, j, input, plot);
            }
         }
      }
      System.out.println(answer);
   }

   
   public static void sandFill (final int n, 
         final int m, final int[] input, final char[][] plot) {
      
      // For the special case of a singular line of blocks.
      if ((input[0] == 1 || input[1] == 1) && plot[n][m] == '.') {
         
         // For the case of a singular block.
         if (input[0] == 1 && input[1] == 1) {
            plot[n][m] = 'S';
         }

         // For the left-most block of horizontal line.
         else if (m == 0 && input[1] > 1) {
            plot[n][m] = 'S';
            sandFill(n, m + 1, input, plot);
         }

         // For the right-most block of horizontal line.
         else if (input[1] > 1 && m == input[1] - 1) {
            plot[n][m] = 'S';
            sandFill(n, m - 1, input, plot);
         }

         // For non-corner blocks on a horizontal line.
         else if (input[1] > 1 && (m != 0 || m != input[1])) {
            plot[n][m] = 'S';
            sandFill(n, m - 1, input, plot);
            sandFill(n, m + 1, input, plot);
         }

         // For top block on vertical line.
         else if (n == 0 && input[0] > 1) {
            plot[n][m] = 'S';
            sandFill(n + 1, m, input, plot);
         }

         // For bottom block on vertical line.
         else if (input[0] > 1 && n == input[0] - 1) {
            plot[n][m] = 'S';
            sandFill(n - 1, m, input, plot);
         }

         // For sandwiched blocks on vertical line.
         else if (input[0] > 1 && (n != 0 || n != input[0] - 1)) {
            plot[n][m] = 'S';
            sandFill(n - 1, m, input, plot);
            sandFill(n + 1, m, input, plot);
         }
      }
      // For non-edge square blocks.
      else if (n != 0 && m != 0 && n != input[0] - 1 
            && m != input[1] - 1 && plot[n][m] == '.') {

         // Replaces '.' with 'S'.
         plot[n][m] = 'S';
         sandFill(n - 1, m, input, plot);
         sandFill(n + 1, m, input, plot);
         sandFill(n, m - 1, input, plot);
         sandFill(n, m + 1, input, plot);
         sandFill(n - 1, m - 1, input, plot);
         sandFill(n + 1, m - 1, input, plot);
         sandFill(n - 1, m + 1, input, plot);
         sandFill(n + 1, m + 1, input, plot);
      }

      // For sand block on top-left corner.
      else if (n == 0 && m == 0 && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n, m + 1, input, plot);
         sandFill(n + 1, m + 1, input, plot);
         sandFill(n + 1, m, input, plot);
      }

      // For sand block on top-right corner.
      else if (n == 0 && m == input[1] - 1 && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n, m - 1, input, plot);
         sandFill(n + 1, m - 1, input, plot);
         sandFill(n + 1, m, input, plot);
      }

      // For sand block on bottom-left corner.
      else if (n == input[0] - 1 && m == 0 && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n, m + 1, input, plot);
         sandFill(n - 1, m, input, plot);
         sandFill(n - 1, m+1, input, plot);
      }

      // For sand block on bottom-Right corner. 
      else if (n == input[0] - 1 && m == input[1] - 1 && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n, m - 1, input, plot);
         sandFill(n - 1, m, input, plot);
         sandFill(n - 1, m - 1, input, plot);
      }

      // For sand blocks on top edge but not on corner.
      else if (n == 0 && (m != 0 || m != input[1] - 1) && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n, m - 1, input, plot);
         sandFill(n, m + 1, input, plot);
         sandFill(n + 1, m - 1, input, plot);
         sandFill(n + 1, m + 1, input, plot);
         sandFill(n + 1, m, input, plot);
      }

      // For sand blocks on left edge but not on corner.
      else if (m == 0 && (n != 0 || n != input[0] - 1) && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n - 1, m, input, plot);
         sandFill(n + 1, m, input, plot);
         sandFill(n - 1, m + 1, input, plot);
         sandFill(n + 1, m + 1, input, plot);
         sandFill(n, m + 1, input, plot);
      }

      // For sand block on bottom edge but not on corner.
      else if (n == input[0] - 1 && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n, m - 1, input, plot);
         sandFill(n, m + 1, input, plot);
         sandFill(n - 1, m - 1, input, plot);
         sandFill(n - 1, m + 1, input, plot);
         sandFill(n - 1, m, input, plot);
      }

      // For sand block on right edge but not on corner.
      else if (m == input[1] - 1 && plot[n][m] == '.') {
         plot[n][m] = 'S';
         sandFill(n - 1, m, input, plot);
         sandFill(n + 1, m, input, plot);
         sandFill(n - 1, m - 1, input, plot);
         sandFill(n + 1, m - 1, input, plot);
         sandFill(n, m - 1, input, plot);
      }
   }
}
