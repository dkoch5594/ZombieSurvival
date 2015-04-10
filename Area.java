import java.io.PrintStream;

public class Area
{
  private String name;
  protected String toNorth;
  protected String toEast;
  protected String toSouth;
  protected String toWest;
  protected String description;
  private Item item;
  
  public Area()
  {
    this.name = "an Area";
    this.toNorth = "something";
    this.toEast = "something";
    this.toSouth = "something";
    this.toWest = "something";
    this.description = "This is an Area.";
    this.item = new Item();
  }
  
  public Area(String newName, String toNorth, String toEast, String toSouth, String toWest, String newDescription)
  {
    this.name = newName;
    this.toNorth = toNorth;
    this.toEast = toEast;
    this.toSouth = toSouth;
    this.toWest = toWest;
    this.description = newDescription;
  }
  
  public String getItemName()
  {
    return this.item.getName();
  }
  
  public Item getItem()
  {
    return this.item;
  }
  
  public void setItem()
  {
    this.item = new Item();
  }
  
  public void setItem(String name, int max, int min)
  {
    this.item = new Weapon(name, max, min);
  }
  
  public void setItem(String name, int health)
  {
    this.item = new Food(name, health);
  }
  
  public void description()
  {
    System.out.println("You are in " + this.name + ".");
    System.out.println(this.description);
    if (!this.toNorth.equals("nothing")) {
      System.out.println("To the north is " + this.toNorth + ".");
    }
    if (!this.toEast.equals("nothing")) {
      System.out.println("To the east is " + this.toEast + ".");
    }
    if (!this.toSouth.equals("nothing")) {
      System.out.println("To the south is " + this.toSouth + ".");
    }
    if (!this.toWest.equals("nothing")) {
      System.out.println("To the west is " + this.toWest + ".");
    }
    System.out.println("\n");
  }
}
