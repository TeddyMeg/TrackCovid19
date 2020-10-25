package tewodros.com.example.trackcovid19;

public class Status {
    private int confirmed;
    private int deaths;
    private int recovered;

    public Status(int confirmed, int deaths, int recovered) {
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }
}
