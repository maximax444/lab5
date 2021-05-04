package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;

public class ExitCommand extends AbstractCommand {
    private Console console;
    public ExitCommand(Console console) {
        super("exit", "завершить программу (без сохранения в файл)");
        this.console = console;
    }
    /**
     * Start execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        try {
            if (!arg.isEmpty()) throw new WrongNumberOfElementsException("У данной команды не должно быть аргумента!");
            console.exit();
            return true;
        } catch (WrongNumberOfElementsException exception) {
            Console.println(exception.getMessage());
        }
        return false;
    }
}
