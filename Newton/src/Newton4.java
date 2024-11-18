import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Create a program that estimates the square.
 *
 * @author Yihone Chu
 *
 */
public final class Newton4 {
    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
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

        boolean flag = false;

        while (!flag) {

            out.println("What do you want Epsilon to be? ");
            double epsilon = in.nextDouble();

            out.println("A number you would like to find the square root of ");
            int n = in.nextInteger();

            if (sqrt(n, epsilon) < 1) {
                flag = true;
            } else {
                out.println(sqrt(n, epsilon));
            }
        }

        in.close();
        out.close();
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            a number that determines how precise estimation is
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {

        double r = x;

        if (r == 0) {
            return 0;
        } else if (x < 0) {
            return -1;
        }

        while ((Math.abs(r * r - x)) / x > epsilon * epsilon) {
            r = (r + x / r) / 2;
        }
        return r;
    }
}
