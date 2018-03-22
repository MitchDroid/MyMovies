
package com.mjbarrerab.mymovies.data.model.movies;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")
public class Result {

    @PrimaryKey(autoGenerate = true)
    private int autoId;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    private String filterType;


    public Result() {
    }

    @android.arch.persistence.room.Ignore
    public Result(int autoId, Integer voteCount, Integer id, Boolean video, Double voteAverage, String title, Double popularity, String posterPath, String originalLanguage, String originalTitle, String backdropPath, Boolean adult, String overview, String releaseDate, String filterType) {
        this.autoId = autoId;
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.filterType = filterType;
    }


    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getAutoId() {
        return autoId;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getFilterType() {
        return filterType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (autoId != result.autoId) return false;
        if (voteCount != null ? !voteCount.equals(result.voteCount) : result.voteCount != null)
            return false;
        if (id != null ? !id.equals(result.id) : result.id != null) return false;
        if (video != null ? !video.equals(result.video) : result.video != null) return false;
        if (voteAverage != null ? !voteAverage.equals(result.voteAverage) : result.voteAverage != null)
            return false;
        if (title != null ? !title.equals(result.title) : result.title != null) return false;
        if (popularity != null ? !popularity.equals(result.popularity) : result.popularity != null)
            return false;
        if (posterPath != null ? !posterPath.equals(result.posterPath) : result.posterPath != null)
            return false;
        if (originalLanguage != null ? !originalLanguage.equals(result.originalLanguage) : result.originalLanguage != null)
            return false;
        if (originalTitle != null ? !originalTitle.equals(result.originalTitle) : result.originalTitle != null)
            return false;
        if (backdropPath != null ? !backdropPath.equals(result.backdropPath) : result.backdropPath != null)
            return false;
        if (adult != null ? !adult.equals(result.adult) : result.adult != null) return false;
        if (overview != null ? !overview.equals(result.overview) : result.overview != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(result.releaseDate) : result.releaseDate != null)
            return false;
        return filterType != null ? filterType.equals(result.filterType) : result.filterType == null;

    }

    @Override
    public int hashCode() {
        int result = autoId;
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (voteAverage != null ? voteAverage.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (posterPath != null ? posterPath.hashCode() : 0);
        result = 31 * result + (originalLanguage != null ? originalLanguage.hashCode() : 0);
        result = 31 * result + (originalTitle != null ? originalTitle.hashCode() : 0);
        result = 31 * result + (backdropPath != null ? backdropPath.hashCode() : 0);
        result = 31 * result + (adult != null ? adult.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (filterType != null ? filterType.hashCode() : 0);
        return result;
    }
}
