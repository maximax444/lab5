import Commands.*;
import Program.AskManager;
import Program.CollectionManager;
import Program.CommandManager;
import Program.Console;
import Program.FileManager;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Должен быть введён 1 аргумент командной строки!");
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);
        try {
            Scanner reader = new Scanner(new File(args[0]));
            System.out.println("Файл обнаружен!");
        } catch (FileNotFoundException e){
            File file = new File(args[0]);
            if (!file.canRead() && !file.canWrite()) {
                try {
                    file.createNewFile();
                    System.out.println("Файла не было, но мы его создали!");
                } catch (IOException e2) {
                    System.out.println("error");
                    System.exit(0);
                }
            } else {
                System.out.println("Ошибка доступа");
                System.exit(0);
            }
        }
        AskManager askManager = new AskManager(scanner);
        Console console = new Console(scanner, askManager);
        askManager.setConsole(console);
        System.out.println("gdf");
        FileManager fileManager = new FileManager(args[0]);
        System.out.println("gdf2");
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(
                new HelpCommand(),
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager),
                new AddCommand(collectionManager, askManager),
                new UpdateCommand(collectionManager, askManager),
                new RemoveByIdCommand(collectionManager),
                new ClearCommand(collectionManager),
                new SaveCommand(collectionManager),
                new ExecuteScriptCommand(console),
                new ExitCommand(console),
                new RemoveGreaterCommand(collectionManager, askManager),
                new RemoveLowerCommand(collectionManager, askManager),
                new HistoryCommand(),
                new MinByManufacturerCommand(collectionManager),
                new CountByPriceCommand(collectionManager),
                new FilterStartsWithNameCommand(collectionManager)
        );
        console.setCommandManager(commandManager);
        console.interactiveMode();
    }
}
