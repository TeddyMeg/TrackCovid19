package tewodros.com.example.trackcovid19.ui;

public class GlobalCases {
    private float cases,deaths,recovered;

    public float getCases() {
        return cases;
    }

    public void setCases(float cases) {
        this.cases = cases;
    }

    public float getDeaths() {
        return deaths;
    }

    public void setDeaths(float deaths) {
        this.deaths = deaths;
    }

    public float getRecovered() {
        return recovered;
    }

    public void setRecovered(float recovered) {
        this.recovered = recovered;
    }

    public GlobalCases(float cases, float deaths, float recovered) {
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }
}
