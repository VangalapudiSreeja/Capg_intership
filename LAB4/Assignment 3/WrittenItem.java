package LAB4;

public abstract class WrittenItem extends Item {
	
private String author;
	
	private int pubYear;
	
	public WrittenItem()
	{
		
	}
	
	public WrittenItem(int id, String str, int n)
	{
		this.setIdNum(id);
		this.setTitle(str);
		this.setNumCopies(n);
	}
	
	public WrittenItem(int id, String str, int n, String author, int pubYear)
	{
		this.setIdNum(id);
		this.setTitle(str);
		this.setNumCopies(n);
		this.author = author;
		this.pubYear = pubYear;
	}

	void setAuthor(String str) {
		author = str;
	}

	String getAuthor() {
		return author;
	}

	public int getidNum() {
		return super.getIdNum();
	}

	public String getTitle() {
		return super.getTitle();
	}

	public int getNumCopies() {
		return super.getNumCopies();
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		WrittenItem otherWrittenItem = (WrittenItem) obj;
		return super.equals(otherWrittenItem) && author == otherWrittenItem.author;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	
	public void print() {
		super.print();
		System.out.println("Author is: "+author);
		System.out.println("Publishing Year : "+pubYear);
	}
	

}
