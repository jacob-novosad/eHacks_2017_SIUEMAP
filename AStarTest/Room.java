/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStarTest;

/**
 *
 * @author Jeremiah
 */
public class Room {

    private String roomNumber;
    private String building;
    private int floor;
    private int x;
    private int y;

    public Room(String roomNumber, String building, int x, int y) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.floor = (int) roomNumber.charAt(0);
        this.x = x;
        this.y = y;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

}
