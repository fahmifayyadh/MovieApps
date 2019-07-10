package fahmifa.id;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable {
    private String Judul, Director, Top, Genre, Rate, Date, Sinopsis;
    private int Photo;

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getTop() {
        return Top;
    }

    public void setTop(String top) {
        Top = top;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Judul);
        dest.writeString(this.Director);
        dest.writeString(this.Top);
        dest.writeString(this.Genre);
        dest.writeString(this.Rate);
        dest.writeString(this.Date);
        dest.writeString(this.Sinopsis);
        dest.writeInt(this.Photo);
    }

    public MovieData() {
    }

    protected MovieData(Parcel in) {
        this.Judul = in.readString();
        this.Director = in.readString();
        this.Top = in.readString();
        this.Genre = in.readString();
        this.Rate = in.readString();
        this.Date = in.readString();
        this.Sinopsis = in.readString();
        this.Photo = in.readInt();
    }

    public MovieData(String Judul, String Director, String Top, String Genre, String Rate, String Date, String Sinopsis, int Photo) {
        this.Judul = Judul;
        this.Director = Director;
        this.Top = Top;
        this.Genre = Genre;
        this.Rate = Rate;
        this.Date = Date;
        this.Sinopsis = Sinopsis;
        this.Photo = Photo;
    }

    public static final Parcelable.Creator<MovieData> CREATOR = new Parcelable.Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel source) {
            return new MovieData(source);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };
}
