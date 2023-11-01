import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner s;
    private LinearEquation linearEquation;

    public LinearEquationLogic() {
        linearEquation = null;
        s = new Scanner(System.in);
    }

    public void start() {
        equationInfo();
    }

    private void coordinatePoints() {
        System.out.print("Enter the first coordinate pair here: ");
        String coord1 = s.nextLine();
        System.out.print("Enter the second coordinate pair here: ");
        String coord2 = s.nextLine();

        int idx1 = coord1.indexOf(",");
        int idx2 = coord2.indexOf(",");

        int x1 = Integer.parseInt(coord1.substring(1, idx1));
        int y1 = Integer.parseInt(coord1.substring(idx1 + 2, coord1.length() - 1));
        int x2 = Integer.parseInt(coord2.substring(1, idx2));
        int y2 = Integer.parseInt(coord2.substring(idx2 + 2, coord2.length() - 1));
        System.out.println();

        if (x1 != x2) {
            linearEquation = new LinearEquation(x1, y1, x2, y2);
            System.out.println("Info obtained!");
            System.out.println();
        } else {
            System.out.println("Wait, both of the x-values are the same! (x = " + x1 + "). Enter a new pair of coordinates!");
            coordinatePoints();
        }
    }

    private void equationInfo() {
        String yesOrNo = "";

        while (!yesOrNo.equals("n")) {
            coordinatePoints();
            linearEquation.lineInfo();
            System.out.println();
            System.out.print("Enter an x-value here: ");
            double xVal = s.nextDouble();
            s.nextLine();
            System.out.println();
            System.out.println(linearEquation.coordinateForX(xVal));
            System.out.println();
            System.out.print("Do you want to enter a new pair of coordinates? (y/n): ");
            yesOrNo = s.nextLine();
        }
        System.out.println("Thanks for using SlopeFinder9001! Goodbye!");
    }
}