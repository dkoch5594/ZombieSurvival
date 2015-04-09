import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ZombieSurvival
{
  private String name;
  private int health;
  private int maxDamage;
  private int minDamage;
  private double escape;
  private static Area[][] map = new Area[5][3];
  private Item[] inventory = new Item[10];
  private boolean safe;
  
  public ZombieSurvival()
  {
    this.name = "John";
    this.health = 100;
    this.maxDamage = 5;
    this.minDamage = 3;
    this.escape = 0.5D;
  }
  
  public ZombieSurvival(String newName)
  {
    this.name = newName;
    this.health = 100;
    this.maxDamage = 3;
    this.minDamage = 1;
    this.escape = 0.5D;
  }
  
  public void battle()
  {
    Scanner input = new Scanner(System.in);
    
    int zombieHealth = 10;
    int zombieMaxDamage = 5;
    int zombieMinDamage = 3;
    

    System.out.println("A wild Zombie appears! You can 'attack' or 'run'\n");
    while ((this.health > 0) && (zombieHealth > 0))
    {
      String action = input.next();
      if (action.equalsIgnoreCase("run"))
      {
        if (Math.random() < 0.5D)
        {
          System.out.println("You manage to escape\n");
          break;
        }
        System.out.println("You couldn't shake the zombie!\n");
      }
      else if (action.equalsIgnoreCase("attack"))
      {
        int playerDamage = (int)(this.minDamage + Math.random() * (this.maxDamage - this.minDamage + 1));
        




        System.out.println("You hit the Zombie for " + playerDamage + " damage.");
        
        zombieHealth -= playerDamage;
        if (zombieHealth > 0)
        {
          System.out.println("The zombie now has " + zombieHealth + " health.");
        }
        else
        {
          System.out.println("You have killed the zombie.\n");
          
          break;
        }
      }
      if (zombieHealth > 0)
      {
        int zombieDamage = (int)(zombieMinDamage + Math.random() * (zombieMaxDamage - zombieMinDamage + 1));
        



        System.out.println("The Zombie hits you for " + zombieDamage + " damage.");
        
        this.health -= zombieDamage;
        if (this.health > 0) {
          System.out.println("You now have " + this.health + " health.\n");
        } else {
          System.out.println("You are dead.\n");
        }
      }
    }
  }
  
  public static void cartographer()
  {
    map[0][0] = new Area("your house", "nothing", "the street", "nothing", "nothing", "You wake up in a daze.\nYour house is a mess, must have been some party.\nYou cannot get to the rest of your house because of all the junk.\nThere is a baseball bat lying inside of your smashed TV.\nYou should go get some help cleaning this up.");
    





    map[0][1] = new Area("the street", "nothing", "a sushi restaurant", "the street", "your house", "You see a sign stapled to a telephone pole that reads\n'Zombie Apocalypse: Evacuate to Nearest Military Base'.\nThe nearest base is just up the road.\nYou decide to go ask your neighbor what happened while you were out.\nHis house is south of yours.");
    





    map[0][2] = new Area("a sushi restaurant", "nothing", "nothing", "nothing", "the street", "The smell of rotting fish is overpowering.\nThe walls are covered in Japanese decorations including a katana.");
    



    map[1][0] = new Area("your friend's house", "nothing", "the street", "nothing", "nothing", "You see your friend lying half eaten on the floor of his living room.\nHis pistol is lying on the floor just out of his reach.\nYou decide to get out of there and get to the base as quick as possible.");
    




    map[1][1] = new Area("the street", "the street", "a burger restaurant", "an intersection", "your friend's house", "There's nothing here.");
    


    map[1][2] = new Area("a fast food restaurant", "nothing", "nothing", "nothing", "the street", "The booths are broken.\nThe fryer is still on.\nThere's a fresh looking buger on the counter.\n(That's right... it looks good after 3 days.)");
    



    map[2][0] = new Area("an alley", "nothing", "the street", "the park", "nothing", "There is an overpowering smell of urine here.\nIt's a nice change of pace from the usual rotting flesh.\nThere's a dumpster, but you are too afraid to look inside.\nYou see a knife right under it though.");
    




    map[2][1] = new Area("an intersection", "the street", "an alley", "the street", "an alley", "In the middle of the intersection is a half-eaten horse corpse and a police bag with a shotgun in it.");
    



    map[2][2] = new Area("an alley", "nothing", "nothing", "nothing", "the street", "There isn't alot of room to move around.\nOver head you see forgotten laundry flapping in the breeze.\nIn the corner you see a keg, along with some party supplies.\nLooks like someone's plans got interrupted.");
    




    map[3][0] = new Area("the park", "an alley", "a street", "the park", "nothing", "It's quiet... too quiet.\nYou notice an apple hanging from a tree that's as red as the blood stains on the sidewalk.");
    



    map[3][1] = new Area("the street", "the street", "a pizza joint", "the street", "the park", "There's nothing here.\nBut shame onyou for walking in the street.");
    


    map[3][2] = new Area("a pizza joint", "nothing", "nothing", "nothing", "the street", "It's really dark.\nAs you walk in an arcade machine scares you by asking you to kill the zombie hordes.\nThere is a piece of pizza on the arcade machine.\nYou can't see anything else.");
    




    map[4][0] = new Area("the park", "the park", "a street", "nothing", "nothing", "You see a playground covered in half eat corpses.\nThere's a hot dog stand off to the side with one uneaten hotdog.");
    



    map[4][1] = new Area("the street", "the street", "the base", "nothing", "the park", "You can see the base from here, you're almost safe.");
    



    map[4][2] = new Area("the base", "nothing", "nothing", "nothing", "nothing", "A soldier sees you, opens the gate, and ushers you inside.\nYou are finally safe.");
  }
  
  public static void itemizer()
  {
    map[0][0].setItem("baseball bat", 5, 3);
    map[1][0].setItem("pistol", 8, 6);
    map[2][1].setItem("shotgun", 10, 8);
    map[2][0].setItem("knife", 6, 4);
    map[0][2].setItem("katana", 9, 7);
    map[3][0].setItem("apple", 1);
    map[4][0].setItem("hotdog", 10);
    map[2][2].setItem("keg", 100);
    map[1][2].setItem("burger", 15);
    map[3][2].setItem("pizza", 20);
  }
  
  public static void credits()
  {
    System.out.println("\n");
    System.out.println("Thank you for playing ZombieSurvival");
    System.out.println("Project Manager:\tDavid Koch");
    System.out.println("Storyline Developer:\tBao Nguyen");
    System.out.println("Item Designer:\t\tJohnny Merida");
    System.out.println("Gameplay Engineer:\tDavid Koch");
    System.out.println("Map Constructor:\tAjmal Ahmadi");
  }
  
  public static void instructions()
  {
    System.out.println("Welcome to ZombieSurvival");
    System.out.println("There are 4 keywords used in this game:");
    System.out.println("\tgo\tmove to new location");
    System.out.println("\tget\tretrieve an item from the current location");
    System.out.println("\tequip\tuse a new weapon from your inventory");
    System.out.println("\teat\teat a food item in your inventory");
    System.out.println("You need to equip a weapon to use it.");
    System.out.println("Commands should include a keyword and a modifier.");
    System.out.println("\tExample: go south");
    System.out.println("\tExample: get baseball bat");
    System.out.println("Type 'quit game' to quit the game");
    System.out.println("Good luck\n");
  }
  
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String action = new String();
    String modifier = new String();
    String myName = JOptionPane.showInputDialog(null, "Welcome to ZombieSurvival, a text-based zombie survival game played\nout of the command console. Please enter your name to begin.", "Welcome", 1);
    


    ZombieSurvival player = new ZombieSurvival(myName);
    int y = 0;
    int x = 0;
    int i = 0;
    
    cartographer();
    itemizer();
    instructions();
    map[y][x].description();
    while ((player.health > 0) && (!player.safe)) {
      try
      {
        StringBuilder command = new StringBuilder(input.nextLine());
        for (int n = 0; n < command.capacity(); n++) {
          if (command.charAt(n) == ' ')
          {
            action = command.substring(0, n);
            modifier = command.substring(n + 1, command.length());
            break;
          }
        }
        if (action.equalsIgnoreCase("go"))
        {
          if (modifier.equalsIgnoreCase("north"))
          {
            if (!map[y][x].toNorth.equalsIgnoreCase("nothing")) {
              y--;
            } else {
              System.out.println("You can't go that way.\n");
            }
          }
          else if (modifier.equalsIgnoreCase("east"))
          {
            if (!map[y][x].toEast.equalsIgnoreCase("nothing")) {
              x++;
            } else {
              System.out.println("You can't go that way.\n");
            }
          }
          else if (modifier.equalsIgnoreCase("south"))
          {
            if (!map[y][x].toSouth.equalsIgnoreCase("nothing")) {
              y++;
            } else {
              System.out.println("You can't go that way.\n");
            }
          }
          else if (modifier.equalsIgnoreCase("west"))
          {
            if (!map[y][x].toWest.equalsIgnoreCase("nothing")) {
              x--;
            } else {
              System.out.println("You can't go that way.\n");
            }
          }
          else {
            System.out.println("Invalid direction\n");
          }
          if (Math.random() > 0.5D) {
            player.battle();
          }
          map[y][x].description();
          if ((y == 4) && (x == 2)) {
            player.safe = true;
          }
        }
        else if (action.equalsIgnoreCase("get"))
        {
          if (modifier.equalsIgnoreCase(map[y][x].getItemName()))
          {
            boolean have = false;
            for (int n = 0; n < player.inventory.length; n++) {
              if ((player.inventory[n] != null) && 
                (modifier.equalsIgnoreCase(player.inventory[n].getName())))
              {
                System.out.println("You already have that item.\n");
                
                have = true;
                break;
              }
            }
            if (!have)
            {
              player.inventory[i] = map[y][x].getItem();
              System.out.println("You have gotten the " + player.inventory[i].getName() + ".\n");
              
              i++;
            }
          }
          else
          {
            System.out.println("That item does not exist\n");
          }
        }
        else if (action.equalsIgnoreCase("equip"))
        {
          for (int n = 0; n < player.inventory.length; n++) {
            if (player.inventory[n] != null) {
              if (player.inventory[n].getName().equalsIgnoreCase(modifier)) {
                if ((player.inventory[n] instanceof Weapon))
                {
                  player.maxDamage = player.inventory[n].getMaxDamage();
                  
                  player.minDamage = player.inventory[n].getMinDamage();
                  

                  System.out.println("You have equipped the " + player.inventory[n].getName());
                  
                  System.out.println("You can now do " + player.minDamage + " - " + player.maxDamage + " damage.\n");
                  

                  break;
                }
              }
            }
          }
        }
        else if (action.equalsIgnoreCase("eat"))
        {
          for (int n = 0; n < player.inventory.length; n++) {
            if (player.inventory[n] != null) {
              if (player.inventory[n].getName().equalsIgnoreCase(modifier)) {
                if ((player.inventory[n] instanceof Food))
                {
                  player.health += player.inventory[n].getHealthBoost();
                  

                  System.out.println("The " + player.inventory[n].getName() + " has healed you for " + player.inventory[n].getHealthBoost() + " points.");
                  



                  System.out.println("You now have " + player.health + " health.\n");
                  
                  break;
                }
              }
            }
          }
        }
        else if (action.equalsIgnoreCase("quit"))
        {
          if (modifier.equalsIgnoreCase("game")) {
            break;
          }
        }
        else
        {
          System.out.println("Invalid action\n");
          continue;
        }
      }
      catch (StringIndexOutOfBoundsException ex)
      {
        System.out.println("Commands must have two words\n");
      }
    }
    credits();
  }
}
