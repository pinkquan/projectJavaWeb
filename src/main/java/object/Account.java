package object;

public class Account {
	
    private String id;
    private String first_name;
    private String date_of_birth;
    private String start_date;
    private String address;
    private String password;
    private String phone_number;
    private String email;
    private int status;
    private String role;

    public Account(
            String id,
            String first_name,
            String date_of_birth,
            String address,
            String phone_number,
            String email,
            String password) {
        this.first_name = first_name;
        this.id = id;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.status = 1;
        this.role = "User";
        
    }

    public Account() {
        this.first_name = "";
        this.status = 1;
        this.id = "";
        this.date_of_birth = "";
        this.address = "";
        this.phone_number = "";
        this.email = "";
        this.password = "";
        this.start_date = "";
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setStart_date(String start_date) {
    	this.start_date = start_date;
    }
    
    public String getStart_date() {
    	return start_date;
    }
    
    public String getRole() {
    	return role;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
    
    public void set_id(String id) {
        this.id = id;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setStatus(int status) {
    	this.status = status;
    }
    
    public int getStatus() {
    	return status;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String get_id() {
        return id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress() {
        return address;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Students{" +
                "student_id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' + ", password='" + password + '\'' + 
                ", status='" + status + '\'' +
        		", role='" + role + '\'' +'}';
    }
}

