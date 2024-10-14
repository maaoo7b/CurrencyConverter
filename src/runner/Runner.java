package runner;

import model.AppManagement;
import model.Currency;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Runner {


    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        AppManagement appManagement = new AppManagement();
        Runner runner = new Runner();
        int optionMenu;
        do {
            String menu = """
                    ##########################
                      Type the option u want
                    ##########################
                    1)List all currencies.
                    2)Convert currencies.
                    3)Generate historical.
                    -1)To exit.
                    ##########################
                    ##########################""";
            System.out.println(menu);
            optionMenu = sc.nextInt();
            switch (optionMenu) {
                case 1:
                    System.out.println("LIST OF ALL CURRENCIES AVAILABLE");
                    runner.getCurrencies(appManagement.currencyList(appManagement.getSupportedCodes()));
                    break;
                case 2:
                    System.out.println("Type the base currency from the listed above: ");
                    var baseCurrency = sc.next();
                    System.out.println("Type the target currency from the listed above: ");
                    var targetCurrency = sc.next();
                    System.out.println("Type the amount of: " + baseCurrency + " to convert into " + targetCurrency);
                    Double amount = sc.nextDouble();
                    //System.out.println(appManagement.currencyConverter(baseCurrency,targetCurrency,amount));
                    System.out.println(appManagement.currencyHistorial(appManagement.currencyConverter(baseCurrency, targetCurrency, amount), amount).get((appManagement.getListSize() - 1)).getCurrencyConversion());
                    //System.out.println("List size: "+ appManagement.getListSize());
                    break;
                case 3:
                    System.out.println(appManagement.historial());
                    appManagement.generateHistorical();
                    break;
                default:
                    System.out.println("¡¡¡Type an option from the menu.!!!");
                    break;
            }
        } while (optionMenu != -1);
    }

    public void getCurrencies(List<Currency> gg) {
        for (Currency i : gg) {
            System.out.println(i.getCodeCurrency());
        }
    }
}
