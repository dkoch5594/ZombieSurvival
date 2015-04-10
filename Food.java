class Food
  extends Item
{
  private int healthBoost;
  
  public Food()
  {
    this.healthBoost = 0;
  }
  
  public Food(String name, int health)
  {
    super(name);
    this.healthBoost = health;
  }
  
  public int getHealthBoost()
  {
    return this.healthBoost;
  }
}
