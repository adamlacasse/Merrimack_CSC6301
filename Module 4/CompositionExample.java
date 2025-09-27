import java.util.ArrayList;
import java.util.List;

class Room {
    private String type;
    private double area;
    
    public Room(String type, double area) {
        this.type = type;
        this.area = area;
    }
    
    public String getType() {
        return type;
    }

    public double getArea() {
        return area;
    }
}

class House {
    private List<Room> rooms; // Composition - House creates and owns rooms
    
    public House(String address) {
        System.out.println("House at " + address + " is created.");
        this.rooms = new ArrayList<>();
        
        // House creates its own rooms - composition
        rooms.add(new Room("Living Room", 300.0));
        rooms.add(new Room("Bedroom", 200.0));
        rooms.add(new Room("Kitchen", 150.0));
    }
    
    public void addRoom(String type, double area) {
        rooms.add(new Room(type, area)); // Creating new Room objects
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        House myHouse = new House("123 Main St");
        
        // Rooms are created as part of the House
        // If House is destroyed, rooms are also destroyed
        // Rooms cannot exist without the House
        myHouse.addRoom("Bathroom", 100.0);
        for (Room room : myHouse.getRooms()) {
            System.out.println("Room Type: " + room.getType());
            System.out.println("Room Area: " + room.getArea() + " sq ft");
        }
    }
}
