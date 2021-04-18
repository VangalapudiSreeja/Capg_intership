package LAB4;

public class Book extends WrittenItem {
	public Book() {
		super();
	}

	public Book(int id, String str, int n) {
		super(id, str, n);
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Book otherBook = (Book) obj;
		return super.equals(otherBook);
	}

	public String toString() {
		return super.toString();
	}

	public int getIdNum() {
		return super.getIdNum();
	}

	public String getTitle() {
		return super.getTitle();
	}

	public int getNumCopies() {
		return super.getNumCopies();
	}

	public String getAuthor() {
		return super.getAuthor();
	}

	public void print(){
		System.out.println("Display info about a book: ");
		super.print();
	}

	public void checkIn(int numCp) {
		super.checkIn(numCp);
	}

	public void checkOut(int numCp) {
		super.checkOut(numCp);
	}

	public void addItem() {
		super.addItem();
	}

}
