package tewodros.com.example.trackcovid19;

import java.util.ArrayList;

public interface IMainPresenter {
    void downloadData();

    interface View{
        void showError(String error);
        void dataDownloadedSuccessfully(ArrayList<String> datesArrayList, ArrayList<Status> statusArrayList);


    }
}
