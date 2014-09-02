
package com.pratama.examplelistgooglemaps.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * POJO Class
 * <p>
 * implement parcelable
 * </p>
 * 
 * @author pratama
 */
public class Lokasi implements Parcelable {
    private String name;
    private Double lat;
    private Double lng;

    public Lokasi() {
        // TODO Auto-generated constructor stub
    }

    public Lokasi(Parcel in) {
        readFromParcel(in);
    }

    public Lokasi(String name, Double lat, Double lng) {
        super();
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
    }

    /**
     * read from parcel
     * 
     * @param in
     */
    private void readFromParcel(Parcel in) {
        name = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
    }

    public static final Parcelable.Creator<Lokasi> CREATOR = new Parcelable.Creator<Lokasi>() {

        @Override
        public Lokasi createFromParcel(Parcel source) {
            return new Lokasi(source);
        }

        @Override
        public Lokasi[] newArray(int size) {
            return new Lokasi[size];
        }
    };

}
