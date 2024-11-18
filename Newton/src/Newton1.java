import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Estimates square root of a number user enters.
 *
 * @author Yihone Chu
 *
 */
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        final double epsilon = 0.0001;
        double r = x;

        while ((Math.abs((r * r) - x)) / x > epsilon * epsilon) {
            r = (r + (x / r)) / 2;
        }
        return r;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        String playAgain = "y";
        while (playAgain.equals("y")) {

            out.println(
                    "A positive number you would like to find the square root of ");
            int n = in.nextInteger();

            out.println(sqrt(n));
            out.print("Would you like to play again? ");
            playAgain = in.nextLine();
        }

        in.close();
        out.close();
    }

}
