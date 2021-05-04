package Commands;

public class HistoryCommand extends AbstractCommand{
    public HistoryCommand(){
        super("history","вывести последние 8 введенных команд без аргументов");
    }
    /**
     * Executes the command
     * @return exit status of command
     * **/
    @Override
    public boolean startExecute(String arg) {
        return true;
    }
}