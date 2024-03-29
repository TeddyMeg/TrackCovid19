package tewodros.com.example.trackcovid19;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Headlines {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("articles")
    @Expose
    private List<Articles> articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }
}
