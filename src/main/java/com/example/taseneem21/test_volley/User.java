package com.example.taseneem21.test_volley;

import android.provider.ContactsContract;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by dino on 23/11/14.
 */
public class User {

    String NAME = "name";
 String Password = "pass";
    String GroupId = "GroupID";

    String ADDRESS = "address";

     String BLOOD_TYPE = "Blood";

 String phone = "phone";

 String ADDITIONAL = "additional";

   String HealthCondition = "HealthCondition";

   String Email = "email";

     String USER_DONATION = "UserDonation";

    String birthdate = "birthDate";

   String TYPE = "type";

     float BLOOD_PER_DONATION_LITERS = 0.5f;

    float BLOOD_FOR_TICKET_LITERS = 2f;

    public String getUsername() {
        return NAME;
    }

    public void setUsername(String hospitalname) {
        this.NAME= hospitalname;
    }

    public String getEmail() {
        return Email;
    }

    public void setUserEmail(String Email) {
        this.Email = Email;
    }

    public String getUserPass() {
        return Password;
    }

    public void setUserPass(String Password) {
        this.Password = Password;
    }

    public String getUserBirthDate() {
        return birthdate;
    }

    public void setUserBlood(String Blood) {
        this.Password = Blood;
    }



    public String getUserBloood() {
        return BLOOD_TYPE;
    }

    public void setUserBirthday(String Birthday) {
        this.birthdate = Birthday;
    }

    public String getUserHealthCondition() {
        return HealthCondition;
    }

    public void setUserHealthCondition(String HealthCondition) {
        this.HealthCondition = HealthCondition;
    }

    public String getUserPhonen() {
        return phone;
    }

    public void setUserPhone(String phone) {
        this.phone =phone;
    }



    public String getUserGroupId() {
        return GroupId;
    }

    public void setUserGroupID(String phone) {
        this.GroupId =phone;
    }
}
