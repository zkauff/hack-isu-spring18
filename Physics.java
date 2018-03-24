
public class Physics {

    public static double calculateAngle(int mouseX, int mouseY, int wizardX, int wizardY) {
	double angle = 0;
	float diffX = wizardX - mouseX;
	float diffY = mouseY - wizardY;
	if (diffY != 0) {
	    angle = (float) Math.toDegrees(Math.atan(diffX / diffY));
	}
	if (diffX > 0 && diffY > 0) {
	    // do nothing
	}
	if (diffX < 0 && diffY < 0) {
	    angle = 180 + angle;
	}
	if (diffX > 0 && diffY < 0) {
	    // angle is negative
	    angle = 180 + angle;
	}
	if (diffX < 0 && diffY > 0) {
	    // angle is negative
	    angle = 360 + angle;
	}
	return angle;
    }
    
    public static void update(double posX, double posY, double vX, double vY, int time) {
	final double g = 9.8;
	vY = vY - g * time;
	posX = posX + vX;
	posY = posY + vY;
    }
    
    public static boolean collision(double projX, double projY, double projRadius, double hitBoxTopLeftX, double hitBoxTopLeftY, double hitBoxBottomRightX, double hitBoxBottomRightY) {
	if(projX + projRadius > hitBoxTopLeftX && projX + projRadius < hitBoxBottomRightX) {
	    if(projY + projRadius > hitBoxTopLeftY && projY + projRadius < hitBoxBottomRightY) {
		return true;
	    } else {
		return false;
	    }
	} else {
	    return false;
	}
    }
}
