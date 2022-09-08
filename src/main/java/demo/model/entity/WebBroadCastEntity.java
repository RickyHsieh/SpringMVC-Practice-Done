package demo.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEB_BROADCAST")
public class WebBroadCastEntity {

	@Id
	private Integer id;

	private String title;

	private String content;

	private String link;

	private Date beginTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getFmtBeginTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = null;
		if (this.beginTime != null) {
			time = sdf.format(beginTime);
		} else {
			time = "";
		}
		return time;
	}

}
