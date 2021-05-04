package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;

public class ShowCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
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
            Console.println(collectionManager.toString());
            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
