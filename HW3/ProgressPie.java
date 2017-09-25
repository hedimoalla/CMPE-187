/*
 * The Program named progress pie will determine if a point inside the progress bar is
 * red or blue and will do so depending on what percentage completed the user wants to
 * look at.
 */

public class ProgressPie 
{

    private final static String BLUE = "blue";
    private final static String RED = "red ";

    public static void main(String[] args) 
    {
        System.out.println("Input:(0, 55, 55)  Output: "+isBLUE(0, 55, 55) + " Expected: blue");
        System.out.println("Input:(12, 55, 55) Output: "+isBLUE(12, 55, 55) + " Expected: blue");
        System.out.println("Input:(13, 55, 55) Output: "+isBLUE(13, 55, 55) + " Expected: red");
        System.out.println("Input:(99, 99, 99) Output: "+isBLUE(99, 99, 99) + " Expected: blue");
        System.out.println("Input:(87, 20, 40) Output: "+isBLUE(87, 20, 40) + " Expected: red");
        System.out.println("Input:(70, 1, 1)   Output: "+isBLUE(70, 1, 1) + " Expected blue");
    }

    //Method will check if percentage and points given are blue or red
    private static String isBLUE(int percent, int pointX, int pointY) 
    {
    	//Checks if percentage is 0
        if(percent == 0) 
        {
            return BLUE;
        }

        int radius = 50;
        int centerX = 50;
        int centerY = 50;

        //Checks if point inside the circle
        boolean isInsideCircle = Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2) <= radius * radius;
        if(!isInsideCircle) 
        {
            return BLUE;
        }

        //1% of 360 is 3.6
        double startingAngle = 0;
        double endingAngle = 3.6 * percent;

        //Checks angle of percent in circle
        double pointAngle = getAngle(centerX, centerY, pointX, pointY);

        //Checks if point is inside or outside circle progress.
        if(startingAngle <= pointAngle && pointAngle <= endingAngle) 
        {
            return RED;
        } 
        else 
        {
            return BLUE;
        }
    }
    
    //Gets angle
    private static double getAngle(double centerX, double centerY, double pointX, double pointY) 
    {
        double angle = Math.toDegrees(Math.atan2(pointX - centerX, pointY - centerY));

        //Atan2 returns a value between 0 and 180 or -1 and -180, we need to map it to 0 and 360
        if(angle < 0) 
        {
            angle += 360;
        }
        return angle;
    }
}

