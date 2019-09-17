
public class Slot {
	private int slotNo;
	private String courseCode;
	
	public Slot() {
		// TODO Auto-generated constructor stub
		slotNo = 0;
		courseCode = null;
	}
	
	
	
	public Slot(int slotNo, String courseCode) {
		super();
		this.slotNo = slotNo;
		this.courseCode = courseCode;
	}



	public int getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
