package object;

import java.util.Objects;

public class UserObject {
	private String userId;
    private String userName;
    private String userPass;
    private String userFullname;
    private String userBirthday;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userCreatedDate;
    private int userPermission;
    private int userStatus;
	public UserObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserObject [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userFullname="
				+ userFullname + ", userBirthday=" + userBirthday + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userAddress=" + userAddress + ", userCreatedDate=" + userCreatedDate
				+ ", userPermission=" + userPermission + ", userStatus=" + userStatus + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(userAddress, userBirthday, userCreatedDate, userEmail, userFullname, userId, userName,
				userPass, userPermission, userPhone, userStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserObject other = (UserObject) obj;
		return Objects.equals(userAddress, other.userAddress) && Objects.equals(userBirthday, other.userBirthday)
				&& Objects.equals(userCreatedDate, other.userCreatedDate) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userFullname, other.userFullname) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userPass, other.userPass)
				&& userPermission == other.userPermission && Objects.equals(userPhone, other.userPhone)
				&& userStatus == other.userStatus;
	}

	public UserObject(String userId, String userName, String userPass, String userFullname, String userBirthday,
			String userEmail, String userPhone, String userAddress, String userCreatedDate, int userPermission,
			int userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userFullname = userFullname;
		this.userBirthday = userBirthday;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userCreatedDate = userCreatedDate;
		this.userPermission = userPermission;
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserFullname() {
		return userFullname;
	}
	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCreatedDate() {
		return userCreatedDate;
	}
	public void setUserCreatedDate(String userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}
	public int getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(int userPermission) {
		this.userPermission = userPermission;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
    
}
