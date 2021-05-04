package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;

public class SaveCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public SaveCommand(CollectionManager collectionManager){
        super("save","save collection to file");
        this.collectionManager = collectionManager;
    }
    /**
     * Executes the command
     * @return exit status of command
     * **/
    public boolean startExecute(String arg){
        try {
            if (!arg.isEmpty()) throw new WrongNumberOfElementsException("У данной команды не должно быть аргумента!");
            collectionManager.saveCollection();
            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
