package com.cib.user.dto;

public class CustomerDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String emailId;
    private Integer phoneNumber;
    private Integer identityNumber;
    private String address;
    private String password;
    private boolean active;
    
    public CustomerDto(Long userId, String firstName, String lastName, String userName, String emailId, int phoneNumber,
            int identityNumber, String address, String password, boolean active) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.identityNumber = identityNumber;
        this.address = address;
        this.password = password;
        this.active = active;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Integer getIdentityNumber() {
        return identityNumber;
    }
    public void setIdentityNumber(Integer identityNumber) {
        this.identityNumber = identityNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    } 


 
}

