package fahmifa.id;

import android.os.Parcel;
import android.os.Parcelable;

public class TvData implements Parcelable {
    private String judulTv, genreTv, sinopsisTv, directorTv, topTv, rateTv, dateTv;
    private int photoTv;

    public String getJudulTv() {
        return judulTv;
    }

    public void setJudulTv(String judulTv) {
        this.judulTv = judulTv;
    }

    public String getGenreTv() {
        return genreTv;
    }

    public void setGenreTv(String genreTv) {
        this.genreTv = genreTv;
    }

    public String getSinopsisTv() {
        return sinopsisTv;
    }

    public void setSinopsisTv(String sinopsisTv) {
        this.sinopsisTv = sinopsisTv;
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

    public String getDateTv() {
        return dateTv;
    }

    public void setDateTv(String dateTv) {
        this.dateTv = dateTv;
    }

    public int getPhotoTv() {
        return photoTv;
    }

    public void setPhotoTv(int photoTv) {
        this.photoTv = photoTv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulTv);
        dest.writeString(this.genreTv);
        dest.writeString(this.sinopsisTv);
        dest.writeString(this.directorTv);
        dest.writeString(this.topTv);
        dest.writeString(this.rateTv);
        dest.writeString(this.dateTv);
        dest.writeInt(this.photoTv);
    }

    public TvData() {
    }

    protected TvData(Parcel in) {
        this.judulTv = in.readString();
        this.genreTv = in.readString();
        this.sinopsisTv = in.readString();
        this.directorTv = in.readString();
        this.topTv = in.readString();
        this.rateTv = in.readString();
        this.dateTv = in.readString();
        this.photoTv = in.readInt();
    }

    public static final Parcelable.Creator<TvData> CREATOR = new Parcelable.Creator<TvData>() {
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
