package com.odintao.model;

/**
 * Created by Odin on 4/17/2016.
 */
public class ObjectFav {

    private String ImageName;
    private String ImageUrl;
    private int id;

    public ObjectFav() {}

    public ObjectFav(String paramString)
    {
        this.ImageUrl = paramString;
    }

    public ObjectFav(String paramString1, String paramString2)
    {
        this.ImageName = paramString1;
        this.ImageUrl = paramString2;
    }

    public String getImageName()
    {
        return this.ImageName;
    }

    public int getId()
    {
        return this.id;
    }

    public String getImageurl()
    {
        return this.ImageUrl;
    }

    public void setImageName(String paramString)
    {
        this.ImageName = paramString;
    }

    public void setId(int paramInt)
    {
        this.id = paramInt;
    }

    public void setImageurl(String paramString)
    {
        this.ImageUrl = paramString;
    }

}
