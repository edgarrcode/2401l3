public class BoxLL {
  private Box theBook;
  private BoxLL next;
  
  //constructors
  public BoxLL() {
  }
  
  public BoxLL(Box newTheBox, BoxLL newNext) {
    theBook = newTheBook;
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