public class BoxLL {
  private Box theBox;
  public BoxLL next;
  
  //constructors
  public BoxLL() {
  }
  
  public BoxLL(Box newTheBox, BoxLL newNext) {
    theBox = newTheBox;
    next = newNext;
  }
  
  //accessors
  public Box getTheBox() {
    return theBox;
  }
  
  public BoxLL getNext() {
    return next;
  }
  
  //mutators
  
}