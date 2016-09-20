public class Box {
  //variables
  private double width;
  private double height;
  private double length;
  
  //constructors
  public Box() {
  }
  public Box(double newWidth, double newHeight, double newLength, Box newNext) {
    width = newWidth;
    height = newHeight;
    length = newLength;
  }
  
  public double getVolume() {
    return(width * height * length);
  }
  
  public boolean isCube(){
    boolean isCube = false;
    if((width == height) && (height == length)) {
      isCube = true;
    }
    return isCube;
  }

}