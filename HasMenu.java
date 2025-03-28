//HasMenu.java

import java.util.*;

public interface HasMenu{
    public static final Scanner input = new Scanner(System.in); // because every class is using a scanner so define it here
    public String menu();
    public void start();
}