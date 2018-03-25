package wizards.main;

public class Physics {

    public static double calculateAngle(int mouseX, int mouseY, int wizardX, int wizardY) {
	double angle = 0;
	float diffX = mouseX - wizardX;
	float diffY = mouseY - wizardY;
	if (diffY != 0) {
	    angle = (float) Math.atan2(diffY, diffX);
	}
	
	return angle;
    }


    public static boolean collision(double projX, double projY, double projRadius, double hitBoxTopLeftX,
	    double hitBoxTopLeftY, double hitBoxBottomRightX, double hitBoxBottomRightY) {
	if (projX + projRadius > hitBoxTopLeftX && projX + projRadius < hitBoxBottomRightX) {
	    if (projY + projRadius > hitBoxTopLeftY && projY + projRadius < hitBoxBottomRightY) {
		return true;
	    } else {
		return false;
	    }
	} else {
	    return false;
	}
    }
}
