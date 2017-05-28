package org.madanpuraskar.cataloguesearch;

public class Monograph {
  /*
  public String fishID;
  public String fishImage;
    public String fishName;
    public String catName;

*/
    public int ID;
    public String MPP_SN;
    public String Title;
    public String Author;
    public String Publisher;
    public String PublisherAddress;
    public String Subject;
    public String Pages;
    public String Size;
    public String Edition;
    public String Press;
    public String PressAddress;
    public String Price;
    public String Published_Date;
    public String ISBN;
    public String Remarks;


    //public String imageURL = "http://10.0.3.2/test/";
    public String imageURL = "http://madanpuraskar.org/android/";


    public String getDescription()
    {
        return "SN: " + MPP_SN + " \n Title: " + Title
                + " \n Author: " + Author + " \n Author: " + Author
                + " \n Date: " + Published_Date;
    }

    public String getImage_link(){

        return  ID + ".jpg";
    }


}
