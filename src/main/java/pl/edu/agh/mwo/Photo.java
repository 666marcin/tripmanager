package pl.edu.agh.mwo;

public class Photo {
	private String comment;

	public Photo(String comment) {
		this.comment = comment;
	}
	
	public Photo() {
		this.comment = null;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
