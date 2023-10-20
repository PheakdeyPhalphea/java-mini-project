package co.option;

import co.stockmanagmnet.StockManagement;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;
public class Display {
    public static void displayFunction(int currentPage ) {
        int totalRecord = Write.stockManagementArrayList.size();
        double totalPage = (double) totalRecord / currentPage;
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE);
        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Unit Price");
        table.addCell("Qty");
        table.addCell("Imported Date");
        for (int i = 0; i < currentPage; i++) {
            StockManagement stockManagement = Write.stockManagementArrayList.get(i);
            table.addCell(String.valueOf(stockManagement.getId()));
            table.addCell(String.valueOf(stockManagement.getName()));
            table.addCell(String.valueOf(stockManagement.getUnitPrice()));
            table.addCell(String.valueOf(stockManagement.getQty()));
            table.addCell(String.valueOf(stockManagement.getDate()));
        }
        System.out.println(table.render());
        System.out.println("0" + "~".repeat(60) + "0");
        System.out.println(" ".repeat(5) + "Page : " + 1 + " of " + (int) Math.ceil(totalPage) + " ".repeat(25) + "Total record: " + totalRecord);
        System.out.println("0" + "~".repeat(60) + "0");
    }


}
