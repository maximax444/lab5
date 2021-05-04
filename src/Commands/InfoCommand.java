package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;

import java.time.LocalDateTime;

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    /**
     * Start execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        try {
            if (!arg.isEmpty()) throw new WrongNumberOfElementsException("Команда: '" + getName() + "' должна использоваться без аргументов");
            LocalDateTime lastInitTime = collectionManager.getLastInitTime();
            String lastInitTimeAns = "";
            if (lastInitTime == null) {
                lastInitTimeAns = "no init";
            } else {
                lastInitTimeAns = lastInitTime.toLocalDate().toString() + " " + lastInitTime.toLocalTime().toString();
            }


            LocalDateTime lastSaveTime = collectionManager.getLastSaveTime();
            String lastSaveTimeAns = "";
            if (lastSaveTime == null) {
                lastSaveTimeAns = "Сохранения не было";
            } else {
                lastSaveTimeAns = lastSaveTime.toLocalDate().toString() + " " + lastSaveTime.toLocalTime().toString();
            }

            Console.println("Сведения о коллекции:");
            Console.println(" - Тип: " + collectionManager.collectionType());
            Console.println(" - Количество элементов: " + collectionManager.collectionSize());
            Console.println(" - Дата последней инициализации: " + lastInitTimeAns);
            Console.println(" - Дата последнего сохранения: " + lastSaveTimeAns);
            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
