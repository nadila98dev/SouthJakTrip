package com.example.southjaktrip;

public class ExampleItem {
    private String judul;
    private String desc;
    private String alamat;
    private String link;
    private String shortdesc;
    private String imagev;
    private String typeplace;
    private float ratingnum;

    public ExampleItem() {

    }

    public ExampleItem(String imagev, String judul, String desc, String alamat, String link, String shortdesc,String typeplace, Float ratingnum) {
        this.imagev = imagev;
        this.judul = judul;
        this.desc = desc;
        this.alamat = alamat;
        this.link = link;
        this.shortdesc = shortdesc;
        this.typeplace = typeplace;
        this.ratingnum = ratingnum;
    }

    public String getImagev() {
        return imagev;
    }
    public void setImagev(String imagev) {
        this.imagev = imagev;
    }

    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }


    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getAlamat() {

        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getShortdesc() {
        return shortdesc;
    }
    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }
    public String getTypeplace() {
        return typeplace;
    }
    public void getTypeplace(String typeplace) {
        this.typeplace = typeplace;
    }

    public float getRatingnum() {
        return ratingnum;
    }

    public void setRatingnum(float ratingnum) {
        this.ratingnum = ratingnum;
    }
}

