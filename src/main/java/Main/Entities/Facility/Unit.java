package Main.Entities.Facility;

/**
 * User: alexthornburg
 * Date: 2/6/14
 * Time: 1:22 PM
 */

import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;

import java.util.List;

public class Unit {

    private int capacity;

    private int roomNumber;

    private int id;

    private int facilityId;

    private List<UnitUsage> usage;

    private List<UnitUser> users;

    public Unit(){}

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public List<UnitUsage> getUsage(){
        return usage;
    }

    public void setUsage(List<UnitUsage> usage){
        this.usage = usage;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<UnitUser> getUsers(){
        return users;
    }

    public void setUsers(List<UnitUser> users){
        this.users = users;
    }

    public int getFacilityId(){
        return facilityId;
    }

    public void setFacilityId(int facilityId){
        this.facilityId = facilityId;
    }




}
