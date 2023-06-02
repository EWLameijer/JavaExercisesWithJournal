package playersguide.dominionofkings;

import utils.AskFor;

import java.util.Scanner;

/*
Three kings, Melik, Casik, and Balik, are sitting around a table, debating who has the
greatest kingdom among them. Each king rules an assortment of provinces, duchies, and
estates. Collectively, they agree to a point system that helps them judge whose
kingdom is greatest: Every estate is worth 1 point, every duchy is worth 3 points, and
every province is worth 6 points. They just need a program that will allow them to
enter their current holdings and compute a point total.
Objectives:
Create a program that allows users to enter how many provinces, duchies, and
estates they have.
Add up the user’s total score, giving 1 point per estate, 3 per duchy, and 6
per province.
Display the point total to the user.
 */
public class TheDominionOfKings {
    public static void main(String[] args) {
        int provinces = AskFor.integer("Please enter the number of provinces you have: ");
        int duchies =  AskFor.integer("Please enter the number of duchies you have: ");
        int estates = AskFor.integer("Please enter the number of estates you have: ");
        int totalPoints = 6 * provinces + 3 * duchies + estates;
        System.out.println("You have " + totalPoints + " points in total.");
    }
}
