package Model;

import java.sql.Time;

public class Video {

	private int id;
	private String videoname;
	private String content;
	private Time timepause;
	private Byte image;
	private String link;
	
	public Video() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Time getTimepause() {
		return timepause;
	}

	public void setTimepause(Time timepause) {
		this.timepause = timepause;
	}

	public Byte getImage() {
		return image;
	}

	public void setImage(Byte image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Video(int id, String videoname, String content, Time timepause, Byte image, String link) {
		super();
		this.id = id;
		this.videoname = videoname;
		this.content = content;
		this.timepause = timepause;
		this.image = image;
		this.link = link;
	}

}
