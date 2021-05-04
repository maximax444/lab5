package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;

public class ClearCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Start execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        try {
            if (!arg.isEmpty()) throw new WrongNumberOfElementsException("У данной команды не должно быть аргумента!");
            collectionManager.clearCollection();
            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
