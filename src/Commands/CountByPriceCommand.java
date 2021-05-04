package Commands;

import Exceptions.EmptyCollectionException;
import Exceptions.WrongNumberOfElementsException;
import Program.AskManager;
import Program.CollectionManager;
import Program.Console;
import Task.Organization;
import Task.Product;

import java.time.LocalDateTime;

public class CountByPriceCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public CountByPriceCommand(CollectionManager collectionManager) {
        super("count_by_price", "вывести количество элементов, значение поля price которых равно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        try {
            if (arg.isEmpty()) throw new WrongNumberOfElementsException("Должен присутствовать аргумент");
            int argInt = Integer.parseInt(arg);

            Console.println(collectionManager.countByPrice(argInt));


            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
