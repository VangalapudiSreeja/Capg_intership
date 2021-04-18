package LAB4;

public abstract class Item {
	private int idNum;
	private String title;
	private int numCopies;
	
	public Item() {
		idNum = 0;
		title = "";
		numCopies = 0;
	}
	
	public Item(int idNum, String title, int numCopies) {
		this.idNum = idNum;
		this.title = title;
		this.numCopies = numCopies;
	}
	
	public void checkIn(int numCopies) {
		this.numCopies += numCopies;
	}

	public void checkOut(int numCopies) {
		this.numCopies -= numCopies;
		
	}

	public void addItem(int idNum, String str, int n) {
		setIdNum(idNum);
		setTitle(str);
		setNumCopies(n);
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumCopies() {
		return numCopies;
	}

	public void setNumCopies(int numCopies) {
		this.numCopies = numCopies;
	}

	public String toString() {
		return "ID: " + idNum + " Title: " + title + " Number of Copies: " + numCopies;
	}

	public void print() {
		
		System.out.println("ID: " + idNum);
		System.out.println("Title:  " + title);
		System.out.println("Number of copies:  " + numCopies);
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Item otherItem = (Item) obj;
		return idNum == otherItem.idNum && title == otherItem.title && numCopies == otherItem.numCopies;
	}

	public void addItem() {
		numCopies++;
	}
}
