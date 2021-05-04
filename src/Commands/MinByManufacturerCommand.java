package Commands;

import Exceptions.EmptyCollectionException;
import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.Console;
import Task.Organization;
import Task.Product;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MinByManufacturerCommand extends AbstractCommand{
    private CollectionManager collectionManager;

    public MinByManufacturerCommand(CollectionManager collectionManager) {
        super("min_by_manufacturer", "вывести любой объект из коллекции, значение поля manufacturer которого является минимальным");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        
        try{
            if(arg == null) throw new NullPointerException();
            if(collectionManager.collectionSize() == 0) throw new EmptyCollectionException("Коллекция пуста");
        } catch (EmptyCollectionException e){
            System.out.println(e.getMessage());
            return false;
        }
        Set<Product> coll = collectionManager.getCollection();
        Product prodMinMan = null;
        int i = 0;
        for (Product prod : coll) {
            if (i == 0) {
                prodMinMan = prod;
                i++;
            }
            if (prodMinMan.getMan() - prod.getMan() < 0) {
                prodMinMan = prod;
            }
        }
        Console.println(prodMinMan.toString());

        
        return true;
        
    }
}
