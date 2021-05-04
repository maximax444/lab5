package Commands;

import Exceptions.WrongNumberOfElementsException;
import Program.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExecuteScriptCommand extends AbstractCommand{
    private Console console;
    public ExecuteScriptCommand(Console console) {
        super("execute_script", "исполнить скрипт из указанного файла");
        this.console = console;
    }
    /**
     * Executes the command
     * @param arg
     * **/
    @Override
    public boolean startExecute(String arg) {

            try {
                if (arg.isEmpty()) throw new WrongNumberOfElementsException("Должен присутствовать аргумент!");

                Console.println("Выполнение скрипта '" + arg + "'...");
                console.scriptMode(arg);
                return true;
            } catch (WrongNumberOfElementsException exception) {
                Console.println(exception.getMessage());
            }
            return false;


    }
}
