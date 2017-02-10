package base.model;

public class Book {
	
	public String paperNickName;
	public String paperOrigin;
	public String paperWebFilePath;
	public String paperExteriorURL;
	public String paperRemark;
	public String uploadDate;
	public String paperUserEmail;
	
	public String getPaperWebFilePath() {
		return paperWebFilePath;
	}

	public void setPaperWebFilePath(String paperWebFilePath) {
		this.paperWebFilePath = paperWebFilePath;
	}
	public String getPaperUserEmail() {
		return paperUserEmail;
	}

	public void setPaperUserEmail(String paperUserEmail) {
		this.paperUserEmail = paperUserEmail;
	}

	public String getPaperNickName() {
		return paperNickName;
	}

	public void setPaperNickName(String paperNickName) {
		this.paperNickName = paperNickName;
	}

	public String getPaperOrigin() {
		return paperOrigin;
	}

	public void setPaperOrigin(String paperOrigin) {
		this.paperOrigin = paperOrigin;
	}

	public String getPaperExteriorURL() {
		return paperExteriorURL;
	}

	public void setPaperExteriorURL(String paperExteriorURL) {
		this.paperExteriorURL = paperExteriorURL;
	}

	public String getPaperRemark() {
		return paperRemark;
	}

	public void setPaperRemark(String paperRemark) {
		this.paperRemark = paperRemark;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

}