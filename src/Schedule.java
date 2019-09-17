import java.util.ArrayList;

public class Schedule {
	Slot[] slotsList;
	public static final int TOTAL_SLOTS = 36;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
		slotsList = new Slot[TOTAL_SLOTS];
	}

	public Schedule(Slot[] slotsList) {
		super();
		this.slotsList = slotsList;
	}

	public Slot[] getSlotsList() {
		return slotsList;
	}

	public void setSlotsList(Slot[] slotsList) {
		this.slotsList = slotsList;
	}
	
	

}
