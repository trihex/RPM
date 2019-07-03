package com.trihex.rpm.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@Entity
public class User
{
   @Id
   @GeneratedValue
   private int id;
   private String username;
   private String password;
   private String email;
   private Timestamp registrationDate;

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public Timestamp getRegistrationDate()
   {
      return registrationDate;
   }

   public void setRegistrationDate(Timestamp registrationDate)
   {
      this.registrationDate = registrationDate;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
