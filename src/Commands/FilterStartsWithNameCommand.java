package Commands;

import Exceptions.EmptyCollectionException;
import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;
import Task.Product;

import java.util.Set;

public class FilterStartsWithNameCommand extends AbstractCommand{
    private CollectionManager collectionManager;

    public FilterStartsWithNameCommand(CollectionManager collectionManager) {
        super("filter_starts_with_name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {

        try{
            if (arg.isEmpty()) throw new WrongNumberOfElementsException("Должен присутствовать аргумент!");
            if(collectionManager.collectionSize() == 0) throw new EmptyCollectionException("Коллекция пуста");
        } catch (EmptyCollectionException | WrongNumberOfElementsException e){
            System.out.println(e.getMessage());
            return false;
        }
        Set<Product> coll = collectionManager.getCollection();
        for (Product prod : coll) {
            if (prod.getName().startsWith(arg)) {
                Console.println(prod.toString());
            }
        }



        return true;

    }
}
