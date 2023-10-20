package co.option;

import co.stockmanagmnet.StockManagement;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class Search {
    static Scanner sc = new Scanner(System.in);

    public static void searchFunction() {
        System.out.print("Product's name : ");
        String inputProName = sc.next();
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE);
        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Unit Price");
        table.addCell("Qty");
        table.addCell("Imported Date");
        for (StockManagement stockManagement : Write.stockManagementArrayList) {
            if (stockManagement.getName().equals(inputProName) || stockManagement.getName().contains(inputProName)) {
                table.addCell(String.valueOf(stockManagement.getId()));
                table.addCell(String.valueOf(stockManagement.getName()));
                table.addCell(String.valueOf(stockManagement.getUnitPrice()));
                table.addCell(String.valueOf(stockManagement.getQty()));
                table.addCell(String.valueOf(stockManagement.getDate()));
            } else {
                System.err.println("No product was found!!");
            }
        }
        System.out.println(table.render());
    }


}
