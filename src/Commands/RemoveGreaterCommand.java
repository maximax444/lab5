package Commands;

import Exceptions.EmptyCollectionException;
import Exceptions.WrongNumberOfElementsException;
import Program.AskManager;
import Program.CollectionManager;
import Program.Console;
import Task.Organization;
import Task.Product;

import java.time.LocalDateTime;

public class RemoveGreaterCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private AskManager askManager;
    public RemoveGreaterCommand(CollectionManager collectionManager, AskManager askManager){
        super("remove_greater","removes all elements that more than specified");
        this.collectionManager = collectionManager;
        this.askManager = askManager;
    }

    /**
     * Executes the command
     * @return exit status of command
     * **/
    @Override
    public boolean startExecute(String arg) {

        try{
            if (!arg.isEmpty()) throw new WrongNumberOfElementsException("У данной команды не должно быть аргумента!");
            if(collectionManager.collectionSize() == 0) throw new EmptyCollectionException("Коллекция пуста!");
            Product prod = new Product(
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
            );
            collectionManager.removeGreater(prod);
            Console.println("Продукты успешно удалены!");
            return true;
        } catch (EmptyCollectionException e){
            Console.println(e.getMessage());
            return false;
        } catch (WrongNumberOfElementsException e) {
            Console.println(e.getMessage());
            return false;
        }

    }

}
