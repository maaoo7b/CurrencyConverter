package runner;

import api.ApiConnection;
import model.AppManagement;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException {

        AppManagement appManagement = new AppManagement();
        var gg = appManagement.currencyList(appManagement.getSupportedCodes());
        System.out.println(gg.get(7));
    }
}
