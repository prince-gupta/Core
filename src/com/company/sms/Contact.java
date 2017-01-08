package com.company.sms;

/**
 * Created by Pgupta on 04-12-2016.
 */
        import java.io.Serializable;

public class Contact
        implements Serializable
{
    private static final long serialVersionUID = 8263744218104663887L;
    private Boolean selected = Boolean.valueOf(false);

    private String name = null;

    private String mobileNo = null;

    private String group = null;

    public Contact(Boolean selected, String name, String mobileNo, String group)
    {
        this.selected = selected;
        this.name = name;
        this.mobileNo = mobileNo;
        this.group = group;
    }

    public String getGroup()
    {
        return this.group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public Contact(boolean selected, String name, String mobileNo, String group)
    {
        this.selected = Boolean.valueOf(selected);
        this.name = name;
        this.mobileNo = mobileNo;
        this.group = group;
    }

    public boolean isSelected()
    {
        return this.selected.booleanValue();
    }

    public void setSelected(boolean selected)
    {
        this.selected = Boolean.valueOf(selected);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobileNo()
    {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo)
    {
        this.mobileNo = mobileNo;
    }
}