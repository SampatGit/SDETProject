package utils;

public class Body
{
    private String addressZipCode;

    private Role role;

    private String userStatus;

    private String gender;

    private String addressState;

    private String emailId;

    private String mobileNo;

    private String userId;

    private String password;

    private String name;

    private String addressLandMark;

    private String addressLane1;

    private String addressLane2;

    private String addressCity;

    public String getAddressZipCode ()
    {
        return addressZipCode;
    }

    public void setAddressZipCode (String addressZipCode)
    {
        this.addressZipCode = addressZipCode;
    }

    public Role getRole ()
    {
        return role;
    }

    public void setRole (Role role)
    {
        this.role = role;
    }

    public String getUserStatus ()
    {
        return userStatus;
    }

    public void setUserStatus (String userStatus)
    {
        this.userStatus = userStatus;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public String getAddressState ()
    {
        return addressState;
    }

    public void setAddressState (String addressState)
    {
        this.addressState = addressState;
    }

    public String getEmailId ()
    {
        return emailId;
    }

    public void setEmailId (String emailId)
    {
        this.emailId = emailId;
    }

    public String getMobileNo ()
    {
        return mobileNo;
    }

    public void setMobileNo (String mobileNo)
    {
        this.mobileNo = mobileNo;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAddressLandMark ()
    {
        return addressLandMark;
    }

    public void setAddressLandMark (String addressLandMark)
    {
        this.addressLandMark = addressLandMark;
    }

    public String getAddressLane1 ()
    {
        return addressLane1;
    }

    public void setAddressLane1 (String addressLane1)
    {
        this.addressLane1 = addressLane1;
    }

    public String getAddressLane2 ()
    {
        return addressLane2;
    }

    public void setAddressLane2 (String addressLane2)
    {
        this.addressLane2 = addressLane2;
    }

    public String getAddressCity ()
    {
        return addressCity;
    }

    public void setAddressCity (String addressCity)
    {
        this.addressCity = addressCity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [addressZipCode = "+addressZipCode+", role = "+role+", userStatus = "+userStatus+", gender = "+gender+", addressState = "+addressState+", emailId = "+emailId+", mobileNo = "+mobileNo+", userId = "+userId+", password = "+password+", name = "+name+", addressLandMark = "+addressLandMark+", addressLane1 = "+addressLane1+", addressLane2 = "+addressLane2+", addressCity = "+addressCity+"]";
    }
}