
package com.mjbarrerab.mymovies.data.model.details;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "details")
public class MovieDetails {

    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    @Expose
    @Ignore
    private Object belongsToCollection;
    @SerializedName("budget")
    @Expose
    private Integer budget;
    @SerializedName("genres")
    @Expose
    @Ignore
    private List<Genre> genres = null;
    @SerializedName("homepage")
    @Expose
    private String homepage;
    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("production_companies")
    @Expose
    @Ignore
    private List<ProductionCompany> productionCompanies = null;
    @SerializedName("production_countries")
    @Expose
    @Ignore
    private List<ProductionCountry> productionCountries = null;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("revenue")
    @Expose
    private Integer revenue;
    @SerializedName("runtime")
    @Expose
    private Integer runtime;
    @SerializedName("spoken_languages")
    @Expose
    @Ignore
    private List<SpokenLanguage> spokenLanguages = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    public MovieDetails() {
    }

    @Ignore
    public MovieDetails(Boolean adult, String backdropPath, Object belongsToCollection, Integer budget, List<Genre> genres, String homepage, Integer id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, String releaseDate, Integer revenue, Integer runtime, List<SpokenLanguage> spokenLanguages, String status, String tagline, String title, Boolean video, Double voteAverage, Integer voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetails that = (MovieDetails) o;

        if (adult != null ? !adult.equals(that.adult) : that.adult != null) return false;
        if (backdropPath != null ? !backdropPath.equals(that.backdropPath) : that.backdropPath != null)
            return false;
        if (belongsToCollection != null ? !belongsToCollection.equals(that.belongsToCollection) : that.belongsToCollection != null)
            return false;
        if (budget != null ? !budget.equals(that.budget) : that.budget != null) return false;
        if (genres != null ? !genres.equals(that.genres) : that.genres != null) return false;
        if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (imdbId != null ? !imdbId.equals(that.imdbId) : that.imdbId != null) return false;
        if (originalLanguage != null ? !originalLanguage.equals(that.originalLanguage) : that.originalLanguage != null)
            return false;
        if (originalTitle != null ? !originalTitle.equals(that.originalTitle) : that.originalTitle != null)
            return false;
        if (overview != null ? !overview.equals(that.overview) : that.overview != null)
            return false;
        if (popularity != null ? !popularity.equals(that.popularity) : that.popularity != null)
            return false;
        if (posterPath != null ? !posterPath.equals(that.posterPath) : that.posterPath != null)
            return false;
        if (productionCompanies != null ? !productionCompanies.equals(that.productionCompanies) : that.productionCompanies != null)
            return false;
        if (productionCountries != null ? !productionCountries.equals(that.productionCountries) : that.productionCountries != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null)
            return false;
        if (revenue != null ? !revenue.equals(that.revenue) : that.revenue != null) return false;
        if (runtime != null ? !runtime.equals(that.runtime) : that.runtime != null) return false;
        if (spokenLanguages != null ? !spokenLanguages.equals(that.spokenLanguages) : that.spokenLanguages != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (tagline != null ? !tagline.equals(that.tagline) : that.tagline != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (video != null ? !video.equals(that.video) : that.video != null) return false;
        if (voteAverage != null ? !voteAverage.equals(that.voteAverage) : that.voteAverage != null)
            return false;
        return voteCount != null ? voteCount.equals(that.voteCount) : that.voteCount == null;

    }

    @Override
    public int hashCode() {
        int result = adult != null ? adult.hashCode() : 0;
        result = 31 * result + (backdropPath != null ? backdropPath.hashCode() : 0);
        result = 31 * result + (belongsToCollection != null ? belongsToCollection.hashCode() : 0);
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (imdbId != null ? imdbId.hashCode() : 0);
        result = 31 * result + (originalLanguage != null ? originalLanguage.hashCode() : 0);
        result = 31 * result + (originalTitle != null ? originalTitle.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (posterPath != null ? posterPath.hashCode() : 0);
        result = 31 * result + (productionCompanies != null ? productionCompanies.hashCode() : 0);
        result = 31 * result + (productionCountries != null ? productionCountries.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (revenue != null ? revenue.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (spokenLanguages != null ? spokenLanguages.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (tagline != null ? tagline.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (voteAverage != null ? voteAverage.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        return result;
    }
}
