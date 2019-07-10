package fahmifa.id;

import android.os.Parcel;
import android.os.Parcelable;

public class TvData implements Parcelable {
    private String judulTv, sinopsisTv, dateTv, directorTv, topTv, rateTv, genreTv;

    public String getJudulTv() {
        return judulTv;
    }

    public String getGenreTv() {
        return genreTv;
    }

    public void setGenreTv(String genreTv) {
        this.genreTv = genreTv;
    }

    public void setJudulTv(String judulTv) {
        this.judulTv = judulTv;
    }

    public String getSinopsisTv() {
        return sinopsisTv;
    }

    public void setSinopsisTv(String sinopsisTv) {
        this.sinopsisTv = sinopsisTv;
    }

    public String getDateTv() {
        return dateTv;
    }

    public void setDateTv(String dateTv) {
        this.dateTv = dateTv;
    }

    public String getDirectorTv() {
        return directorTv;
    }

    public void setDirectorTv(String directorTv) {
        this.directorTv = directorTv;
    }

    public String getTopTv() {
        return topTv;
    }

    public void setTopTv(String topTv) {
        this.topTv = topTv;
    }

    public String getRateTv() {
        return rateTv;
    }

    public void setRateTv(String rateTv) {
        this.rateTv = rateTv;
    }

    public int getPhotoTv() {
        return photoTv;
    }

    public void setPhotoTv(int photoTv) {
        this.photoTv = photoTv;
    }

    private int photoTv;

    public TvData(){

    }


    public TvData(String judulTv, String sinopsisTv,String dateTv, String directorTv, String topTv, String rateTv, int photoTv) {
        this.judulTv = judulTv;
        this.sinopsisTv = sinopsisTv;
        this.dateTv = dateTv;
        this.directorTv = directorTv;
        this.topTv = topTv;
        this.rateTv = rateTv;
        this.photoTv = photoTv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulTv);
        dest.writeString(this.sinopsisTv);
        dest.writeString(this.dateTv);
        dest.writeString(this.directorTv);
        dest.writeString(this.topTv);
        dest.writeString(this.rateTv);
        dest.writeString(this.genreTv);
        dest.writeInt(this.photoTv);
    }

    protected TvData(Parcel in) {
        this.judulTv = in.readString();
        this.sinopsisTv = in.readString();
        this.dateTv = in.readString();
        this.directorTv = in.readString();
        this.topTv = in.readString();
        this.rateTv = in.readString();
        this.genreTv = in.readString();
        this.photoTv = in.readInt();
    }

    public static final Creator<TvData> CREATOR = new Parcelable.Creator<TvData>() {
        @Override
        public TvData createFromParcel(Parcel source) {
            return new TvData(source);
        }

        @Override
        public TvData[] newArray(int size) {
            return new TvData[size];
        }
    };
}
