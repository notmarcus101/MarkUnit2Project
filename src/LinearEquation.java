public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y2 - (x2 * slope()));
    }

    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String equation() {
        if (y1 == y2) {
            if (yIntercept() == 0) {
                return "y = 0";
            } else {
                return "y = " + yIntercept();
            }
        }
        if (yIntercept() > 0) {
            if (((double) (y2 - y1) / (x2 - x1)) == 1 || ((y2 - y1) / (x2 - x1)) == -1) {
                if (((double) (y2 - y1) / (x2 - x1)) == 1) {
                    return "y = x + " + yIntercept();
                } else {
                    return "y = -x + " + yIntercept();
                }
            } else {
                if (((double) (y2 - y1) / (x2 - x1)) > 0) {
                    if (((double) (y2 - y1) % (x2 - x1)) == 0) {
                        return "y = " + ((y2 - y1) / (x2 - x1)) + "x + " + yIntercept();
                    } else {
                        return "y = " + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x + " + yIntercept(); //included Math.abs() since double negative can also give positive results
                    }
                } else {
                    if ((double) (y2 - y1) % (x2 - x1) == 0) {
                        return "y = " + ((y2 - y1) / (x2 - x1)) + "x + " + yIntercept();
                    } else {
                        return "y = -" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x + " + yIntercept();
                    }
                }
            }
        } else {
            if (((double) (y2 - y1) / (x2 - x1)) == 1 || ((y2 - y1) / (x2 - x1)) == -1) {
                if (((double) (y2 - y1) / (x2 - x1)) == 1) {
                    return "y = x - " + Math.abs(yIntercept());
                } else {
                    return "y = -x - " + Math.abs(yIntercept());
                }
            } else {
                if (((double) (y2 - y1) / (x2 - x1)) > 0) {
                    if (((double) (y2 - y1) % (x2 - x1)) == 0) {
                        return "y = " + ((y2 - y1) / (x2 - x1)) + "x - " + Math.abs(yIntercept());
                    } else {
                        return "y = " + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x - " + Math.abs(yIntercept()); //included Math.abs() since double negative can also give positive results
                    }
                } else {
                    if (((double) (y2 - y1) % (x2 - x1)) == 0) {
                        return "y = " + ((y2 - y1) / (x2 - x1)) + "x - " + Math.abs(yIntercept());
                    } else {
                        return "y = -" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x - " + Math.abs(yIntercept());
                    }
                }
            }
        }
    }

    public String coordinateForX(double x) {
        return "The coordinate point for the x-value " + x + " is (" + x + ", " + roundedToHundredth((slope() * x + yIntercept())) + ")";
    }

    public void lineInfo() {
        System.out.println("The two points are (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ").");
        System.out.println("The equation of the line between the points is " + equation());
        System.out.println("The slope of this line is " + slope());
        System.out.println("The y-intercept of this line is " + yIntercept());
        System.out.println("The distance between these points is " + distance());
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}