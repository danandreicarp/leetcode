import java.util.*;

/**
 * Definition for singly-linked list.*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder("[");
        buf.append(val);
        ListNode iter = next;
        while (iter != null) {
            buf.append(" -> ");
            buf.append(iter.val);
            iter = iter.next;
        }
        buf.append("]");

        return buf.toString();
    }
}

class Building implements Comparable<Building> {
    private Integer x;
    private Integer y;
    private Integer height;

    public Building(int[] building) {
        this.x = building[0];
        this.y = building[1];
        this.height = building[2];
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public List<Integer> getCoordinates() {
        List<Integer> list = new ArrayList<>(2);
        list.add(x);
        list.add(height);
        return list;
    }

    public List<Integer> getExitCoordinates() {
        List<Integer> list = new ArrayList<>(2);
        list.add(y);
        list.add(0);
        return list;
    }

    @Override
    public int compareTo(Building o) {
        return (-1) * this.height.compareTo(o.getHeight());
    }

    @Override
    public String toString() {
        return "(" + x + " to " + y + ": " + height + ")";
    }
}

public class Main {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        if (buildings == null || buildings.length == 0) {
            List<Integer> noBuilding = new ArrayList<>(2);
            noBuilding.add(0);
            noBuilding.add(0);
            return Collections.singletonList(noBuilding);
        }

        if (buildings.length == 1) {
            Building building = new Building(buildings[0]);
            List<List<Integer>> skyline = new ArrayList<>(2);
            skyline.add(building.getCoordinates());
            skyline.add(building.getExitCoordinates());
            return skyline;
        }

        List<List<Integer>> skyline = computeSkyline(buildings);
        return skyline;
    }

    private List<List<Integer>> computeSkyline(int[][] buildings) {
        Map<Integer, List<Building>> buildingStartMap = new HashMap<>();
        Map<Integer, List<Building>> buildingEndMap = new HashMap<>();

        Set<Integer> positions = new TreeSet<>();
        for (int[] building : buildings) {
            addBuildingToMaps(building, buildingStartMap, buildingEndMap);
            positions.add(building[0]);
            positions.add(building[1]);
        }

        List<List<Integer>> skyline = new ArrayList<>();
        PriorityQueue<Building> queue = new PriorityQueue<>();
        for (Integer position : positions) {
            handleStartingBuildings(buildingStartMap, skyline, queue, position);
            handleEndingBuildings(buildingEndMap, skyline, queue, position);
        }
        return skyline;
    }

    private void addBuildingToMaps(int[] buildingCoordinates,
                                   Map<Integer, List<Building>> startMap,
                                   Map<Integer, List<Building>> endMap) {

        Building building = new Building(buildingCoordinates);

        startMap.computeIfAbsent(building.getX(), key -> new ArrayList<>()).add(building);
        endMap.computeIfAbsent(building.getY(), key -> new ArrayList<>()).add(building);
    }

    private void handleStartingBuildings(Map<Integer, List<Building>> buildingStartMap,
                                         List<List<Integer>> skyline,
                                         PriorityQueue<Building> buildings,
                                         int position) {
        List<Building> buildingsStartingHere = buildingStartMap.get(position);
        if (buildingsStartingHere != null) {
            for (Building newBuilding : buildingsStartingHere) {
                if (newBuilding != null) {
                    buildings.add(newBuilding);
                }
            }

            Building highestBuilding = buildings.peek();
            if (skyline.isEmpty()) {
                skyline.add(highestBuilding.getCoordinates());
            } else {
                List<Integer> currentBuilding = skyline.get(skyline.size() - 1);
                if (currentBuilding.get(1) < highestBuilding.getHeight()) {
                    skyline.add(highestBuilding.getCoordinates());
                }
            }
        }
    }

    private void handleEndingBuildings(Map<Integer, List<Building>> buildingEndMap,
                                       List<List<Integer>> skyline,
                                       PriorityQueue<Building> buildings,
                                       int position) {
        List<Building> buildingsEndingHere = buildingEndMap.get(position);
        if (buildingsEndingHere != null) {
            for (Building endBuilding : buildingsEndingHere) {
                if (endBuilding != null) {
                    buildings.remove(endBuilding);
                }
            }

            if (!buildings.isEmpty()) {
                Building highestBuilding = buildings.peek();
                List<Integer> currentBuilding = skyline.get(skyline.size() - 1);
                if (currentBuilding.get(1) > highestBuilding.getHeight()) {
                    List<Integer> coordinates = highestBuilding.getCoordinates();
                    coordinates.set(0, position);
                    skyline.add(coordinates);
                }
            } else {
                List<Integer> exitCoordinates = new ArrayList<>(2);
                exitCoordinates.add(position);
                exitCoordinates.add(0);
                skyline.add(exitCoordinates);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        ListNode next12 = new ListNode(6);
        ListNode next11 = new ListNode(8, next12);
        ListNode head1 = new ListNode(0, next11);

        ListNode next22 = new ListNode(8);
        ListNode next21 = new ListNode(7, next22);
        ListNode head2 = new ListNode(6, next21);

        int[][] buildings = {
/*                {0,2,3},
                {2,5,3}*/
/*                {1,2,1},
                {1,2,2},
                {1,2,3}*/
                /*{0,8,3},
                {1,4,2},
                {2,5,3},
                {4,8,4}*/
                {1,2,1},
                {2147483646,2147483647,2147483647}
        };

        List<List<Integer>> result = main.getSkyline(buildings);
        System.out.println(result);

//        String res = out.stream()
//                .map(col -> col.stream().map(Object::toString).collect(Collectors.joining(',')))
//                .collect(Collectors.joining('\n'));
//        System.out.println(out);
    }
}
