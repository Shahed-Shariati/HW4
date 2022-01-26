package utility;

public class Menu {
  private static String dotted = "---------------------------------------------------";
public static void loginMenu(){

    System.out.println("1:Login");
    System.out.println("2:Sing up");
    System.out.println("3:Exit");
    System.out.println(dotted);

}
public static void userMenu()
{
    System.out.println();
    System.out.println("1:Show ticket list");
    System.out.println("2:reserve ticket");
    System.out.println("3:search movie by date");
    System.out.println("4:search movie by name");
    System.out.println("5:Log out");
    System.out.println(dotted);
}
public static void cinemaMenu(){
    System.out.println();
    System.out.println("1:show movie list");
    System.out.println("2:Add movie to list");
    System.out.println("3:Add tiket");
    System.out.println("4:Delete ticket");
    System.out.println("5:Cinema profit");
    System.out.println("6:Log out");
    System.out.println(dotted);
}

public static void singUpMenu()
{
    System.out.println();
    System.out.println("1:Cinema");
    System.out.println("2:Customer");
    System.out.println(dotted);
}
public static void adminMenu()
{
    System.out.println();
    System.out.println("1: show cinema list");
    System.out.println("2: Authentication Cinem:");
    System.out.println("3: Log out:");

    System.out.println(dotted);

}
}
