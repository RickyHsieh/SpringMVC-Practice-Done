package demo.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IndexDto {
	
	public static class WebBoardCastDto{
		
		private Integer id;
		
		private String title;
		
		private Date beginTime;
		
		private String content;

		
		
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
	
}
