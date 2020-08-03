package com.hv.ecommerce.users.models;

import com.hv.ecommerce.common.Utils;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "LogHistory")
@Table(name = "LogHistory")
public class LogHistory {
    public LogHistory() {
        this.dateModified = Utils.getCurrentTimestamp();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp dateModified;
    @Column(name = "updateBy", length = 1024)
    private String updateBy;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "strDateModified")
    private String dateModifiedInString;

    @Override
    public boolean equals(Object obj) {
        LogHistory doc = (LogHistory) obj;
        return (id == doc.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateModifiedInString() {
        return dateModifiedInString;
    }

    public void setDateModifiedInString(String dateModifiedInString) {
        this.dateModifiedInString = dateModifiedInString;
    }
}
