public class Item
{
  private String name;
  
  public Item()
  {
    this.name = "item";
  }
  
  public Item(String newName)
  {
    this.name = newName;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getMaxDamage()
  {
    return 0;
  }
  
  public int getMinDamage()
  {
    return 0;
  }
  
  public int getHealthBoost()
  {
    return 0;
  }
}
