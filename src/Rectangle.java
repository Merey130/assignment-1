public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen=1;

    public Rectangle ( ){
        this.width= 1.0;
        this.height= 1.0;
        this.id= idGen++;

    }
    public Rectangle (double width , double height) {
        this ();
        setWidth(width);
        setHeight(height);

    }
 public double getWidth () {
     return width;
 }
  public void setWidth (double width) {
        if (width > 0) {
            this.width=width;
        }
        else {
            throw new IllegalArgumentException ("invalid");
        }
  }
  public double getHeight () {
        return height;
  }
  public void setHeight (double height) {
        if (height>0) {
            this.height=height;
        }
        else {
            throw new IllegalArgumentException( "invalid");
        }
  }
  public int getId() {
      return id;
  }
    public double area (){
        return height*width;
    }
    public double perimeter () {
        return 2*height+ 2*width;
    }
    @Override
    public String toString() {
        return "Rectangle{id=" + id + ", width=" + width + ", height=" + height + "}";
    }

}
