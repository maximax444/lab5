package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.AskManager;
import Program.CollectionManager;
import Program.Console;
import Task.Address;
import Task.Organization;
import Task.OrganizationType;
import Task.Product;

import java.time.LocalDateTime;

public class AddCommand extends AbstractCommand {

    private CollectionManager collectionManager;
    private AskManager askManager;

    public AddCommand(CollectionManager collectionManager, AskManager askManager) {
        super("add", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.askManager = askManager;
    }
    /**
     * Execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        try {
            if (!arg.isEmpty()) throw new WrongNumberOfElementsException("У данной команды не должно быть аргумента!");
            collectionManager.addToCollection(new Product(
                    collectionManager.generateNextId(),
                    askManager.askName(),
                    askManager.askCoordinates(),
                    LocalDateTime.now(),
                    askManager.askPrice(),
                    askManager.askPartNumber(),
                    askManager.askManufactureCost(),
                    askManager.askUnitOfMeasure(),
                    new Organization(
                            (int) (long) collectionManager.generateNextId(),
                            askManager.askOrgName(),
                            askManager.askOrgFullName(),
                            askManager.askAnnualTurnover(),
                            askManager.askType(),
                            askManager.askPostalAddress()
                    )
            ));
            Console.println("Продукт успешно добавлен в коллекцию!");
            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
