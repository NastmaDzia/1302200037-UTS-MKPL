package lib;

public class DataEmployee {
    private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;

    public String getemployeeId(){
        return employeeId;
    }
    public void setemployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getfirstName(){
        return firstName;
    }
    public void setfirstName(String firstName){
        this.firstName = firstName;
    }

    public String getlastName(){
        return lastName;
    }
    public void setlastName(String lastName){
        this.lastName = lastName;
    }

    public String getidNumber(){
        return idNumber;
    }
    public void setidNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public String getaddress(){
        return address;
    }
    public void setaddress(String address){
        this.address = address;
    }

}

