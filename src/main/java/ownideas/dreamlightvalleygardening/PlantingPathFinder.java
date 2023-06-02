package ownideas.dreamlightvalleygardening;

import java.util.*;

/* Description
    In the game "Dreamlight Valley" you have your own garden, which is arranged in a grid. But due to other objects
    that are in your way, a field is seldom a perfect rectangle. Auto-seeding (planting a seed, then moving 1 step north,
    east, south, or west, then seeding again, is an option, but it seems to generally
    fail to find the best path through your field, it often sows only half or less of the available places. I
    wondered if one could do this better.
 */
public class PlantingPathFinder {

    record Coordinate(int x, int y) {
    }

    static Set<Coordinate> garden = parse("""
            XXXX
              XX
              XXX
             XXXX
             XXXX
            XXXX
            XXXXX
            """);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(garden.toArray()));
        List<Coordinate> bestFoundSoFar = List.of();
        for (Coordinate startingPoint : garden) {
            List<Coordinate> longestPath = getLongestPath(startingPoint, Set.of());
            if (longestPath.size() > bestFoundSoFar.size()) bestFoundSoFar = longestPath;
        }
        System.out.println("The best path found has length " + bestFoundSoFar.size());
        System.out.println("It runs like " + bestFoundSoFar);
    }

    /* Pseudocode
    getLongestPath returns the longest path starting from the given starting coordinate
    It always at least returns the starting coordinate (if no paths from it can be found, at least the starting coordinate represents the end of the path)
    IF however there are unexplored coordinates adjacent to the starting coordinate (NOT in visited so far)
        find out the longest path from that adjacent coordinate (adding the starting coordinate to "visited")
    return the starting coordinate PLUS the longest path attained from that search.
     */
    private static List<Coordinate> getLongestPath(Coordinate startCoordinate, Set<Coordinate> visited) {
        List<Coordinate> currentlyLongestPath = new ArrayList<>();
        Set<Coordinate> visitedIncludingCurrent = new HashSet<>(visited);
        visitedIncludingCurrent.add(startCoordinate);
        for (Coordinate coordinate : garden) {
            if (Math.abs(coordinate.x - startCoordinate.x) + Math.abs(coordinate.y - startCoordinate.y) == 1 && !visited.contains(coordinate)) {
                List<Coordinate> longestPathFromHere = getLongestPath(coordinate, visitedIncludingCurrent);
                if (longestPathFromHere.size() > currentlyLongestPath.size())
                    currentlyLongestPath = longestPathFromHere;
            }
        }
        currentlyLongestPath.add(0, startCoordinate);
        return currentlyLongestPath;
    }

    private static Set<Coordinate> parse(String input) {
        Set<Coordinate> garden = new HashSet<>();
        var lines = input.split("\n");
        for (int y = 0; y < lines.length; y++) {
            String currentRow = lines[y];
            for (int x = 0; x < currentRow.length(); x++) {
                if (currentRow.charAt(x) != ' ') garden.add(new Coordinate(x, y));
            }
        }
        return garden;
    }
}
