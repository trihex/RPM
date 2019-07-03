package com.trihex.rpm.outcome;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Outcome {
    @Id
    @GeneratedValue
    private int id;
    private String result;
    private String reason;
    @Column(name = "primary_role")
    private int primaryRole;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPrimaryRole() {
        return primaryRole;
    }

    public void setPrimaryRole(int primaryRole) {
        this.primaryRole = primaryRole;
    }
}
