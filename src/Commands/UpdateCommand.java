package Commands;

import Exceptions.IncorrectInputException;
import Exceptions.WrongNumberOfElementsException;
import Program.AskManager;
import Program.CollectionManager;
import Program.Console;
import Task.Organization;
import Task.Product;

import java.time.LocalDateTime;
import java.util.Set;

public class UpdateCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private AskManager askManager;
    public UpdateCommand(CollectionManager collectionManager, AskManager askManager) {
        super("update", " id {element} обновить значение элемента коллекции, id которого равен заданному");
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
            if (arg.isEmpty()) throw new WrongNumberOfElementsException("ДОлжен быть аргумент");
            Set<Product> coll = collectionManager.getCollection();
            Long argLong = Long.parseLong(arg);
            Product prod = collectionManager.getById(argLong);
            if(prod == null) throw new IncorrectInputException("Продукта с таким id нет!");

            collectionManager.removeFromCollection(prod);
            collectionManager.addToCollection(new Product(
                    argLong,
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
            Console.println("Продукт успешно обновлен!");
            return true;
        } catch (WrongNumberOfElementsException | IncorrectInputException exception) {
            Console.println(exception.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Аргумент должен быть числом!");
            return false;
        }
        return false;
    }
}
