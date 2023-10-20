package co;

import co.option.*;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class WelcomeMenu {
    static int rowPerPage = 2;
    static int currentPage = 2;

    public static void welcomeMsg() {
        System.out.println(
                """

                         ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗    \s
                        ██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗   \s
                        ██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║   \s
                        ██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║   \s
                        ╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║   \s
                         ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝   \s
                        STOCK MANAGEMENT SYSTEM"""
        );
    }

    public static void createTable() {
        Scanner sc = new Scanner(System.in);
        Table table = getTable();
        System.out.println(table.render());
        System.out.print("Command ———>");
        String options = sc.nextLine();
        switch (options) {
            case "*" -> Display.displayFunction(rowPerPage);
            case "w", "W" -> Write.writeFunction();
            case "r", "R" -> Read.readFunction();
            case "u", "U" -> Update.updateFunction();
            case "d", "D" -> Delete.deleteFunction();
            case "f", "F" -> First.firstPageFunction();
            case "p", "P" -> Previous.previousFunction();
            case "n", "N" -> Next.nextFunction(currentPage);
            case "l", "L" -> Last.lastFunction();
            case "s", "S" -> Search.searchFunction();
            case "g", "G" -> Goto.gotoFunction();
            case "se", "Se" -> rowPerPage = SetRow.setRowFunction();
            case "h", "H" -> Help.helpFunction();
            case "e", "E" -> {
                System.out.println("Have a Nice Day!! ");
                System.exit(0);
            }
            default -> System.out.println("Invalid Option");
        }
    }

    private static Table getTable() {
        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell("".repeat(4) + "| *)Display" + "".repeat(4));
        table.addCell("".repeat(4) + " | W)Write" + "".repeat(4));
        table.addCell("".repeat(4) + " | R)Read" + "".repeat(4));
        table.addCell("".repeat(4) + " | U)pdate" + "".repeat(4));
        table.addCell("".repeat(4) + " | D)elete" + "".repeat(4));
        table.addCell("".repeat(4) + " | F)irst" + "".repeat(4));
        table.addCell("".repeat(4) + " | P)revious" + "".repeat(4));
        table.addCell("".repeat(4) + " | N)ext" + "".repeat(4));
        table.addCell("".repeat(4) + " | L)ast" + "".repeat(4));
        table.addCell("".repeat(4) + "| S)earch" + "".repeat(4));
        table.addCell("".repeat(4) + " | G)oto" + "".repeat(4));
        table.addCell("".repeat(4) + " | Se)t row" + "".repeat(4));
        table.addCell("".repeat(4) + " | H)elp" + "".repeat(4));
        table.addCell("".repeat(4) + " | E)xit" + "".repeat(4));
        return table;
    }
}


