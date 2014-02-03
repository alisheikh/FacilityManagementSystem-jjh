package Main.Entities;

public class Facility {

	private int ID;

	private int BuildingNumber;

	private int RoomNumber;

	private int Capacity;

	public void Facility() {

	}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBuildingNumber() {
        return BuildingNumber;
    }


    public void setBuildingNumber(int buildingNumber) {
        BuildingNumber = buildingNumber;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
