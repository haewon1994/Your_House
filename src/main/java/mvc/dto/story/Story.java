package mvc.dto.story;

import java.util.ArrayList;
import java.util.List;

import mvc.dto.reply.Reply;

public class Story {
	
	private int storyCode;
	private int userCode;
	private String storyImage;
	private String storyLiter;
	private String storyReg;
	
	private List<Reply> replyList = new ArrayList<Reply>();

	public Story() {}
	
	public Story(int storyCode, String storyLiter) {
		this.storyCode = storyCode;
		this.storyLiter = storyLiter;
	}

	public Story(int storyCode, int userCode, String storyImage, String storyLiter, String storyReg) {
	
		this.storyCode = storyCode;
		this.userCode = userCode;
		this.storyImage = storyImage;
		this.storyLiter = storyLiter;
		this.storyReg = storyReg;
	}

	public int getStoryCode() {
		return storyCode;
	}

	public void setStoryCode(int storyCode) {
		this.storyCode = storyCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getStoryImage() {
		return storyImage;
	}

	public void setStoryImage(String storyImage) {
		this.storyImage = storyImage;
	}

	public String getStoryLiter() {
		return storyLiter;
	}

	public void setStoryLiter(String storyLiter) {
		this.storyLiter = storyLiter;
	}

	public String getStoryReg() {
		return storyReg;
	}

	public void setStoryReg(String storyReg) {
		this.storyReg = storyReg;
	}




	public List<Reply> getReplyList() {
		return replyList;
	}




	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	
	
}
