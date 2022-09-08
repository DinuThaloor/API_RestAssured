package pojoClassForSerializationAndDeserialization;

public class Spouse 
{
String spouseName;
String spEmail;
String spAddress;
int spPhNo;
public Spouse(String spouseName, String spEmail, String spAddress, int spPhNo) {
	super();
	this.spouseName = spouseName;
	this.spEmail = spEmail;
	this.spAddress = spAddress;
	this.spPhNo = spPhNo;
}
public Spouse()
{
	
}
public String getSpouseName() {
	return spouseName;
}
public void setSpouseName(String spouseName) {
	this.spouseName = spouseName;
}
public String getSpEmail() {
	return spEmail;
}
public void setSpEmail(String spEmail) {
	this.spEmail = spEmail;
}
public String getSpAddress() {
	return spAddress;
}
public void setSpAddress(String spAddress) {
	this.spAddress = spAddress;
}
public int getSpPhNo() {
	return spPhNo;
}
public void setSpPhNo(int spPhNo) {
	this.spPhNo = spPhNo;
}
}
