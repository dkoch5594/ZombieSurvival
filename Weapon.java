class Weapon
  extends Item
{
  private int maxDamage;
  private int minDamage;
  
  public Weapon()
  {
    this.maxDamage = 7;
    this.minDamage = 5;
  }
  
  public Weapon(String name, int max, int min)
  {
    super(name);
    this.maxDamage = max;
    this.minDamage = min;
  }
  
  public int getMaxDamage()
  {
    return this.maxDamage;
  }
  
  public int getMinDamage()
  {
    return this.minDamage;
  }
}
