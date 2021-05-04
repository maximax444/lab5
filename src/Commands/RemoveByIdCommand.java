package Commands;

import Exceptions.CollectionIsEmptyException;
import Exceptions.ProductNotFoundException;
import Exceptions.WrongNumberOfElementsException;
import Program.CollectionManager;
import Program.CommandManager;
import Program.Console;
import Task.Product;

public class RemoveByIdCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }
    /**
     * Start execute command.
     * @return Command status.
     */
    @Override
    public boolean startExecute(String arg) {
        try {
            if (arg.isEmpty()) throw new WrongNumberOfElementsException("Должен присутствовать аргумент");
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException("Коллекция уже пуста!");
            Long id = Long.parseLong(arg);
            Product productToRemove = collectionManager.getById(id);
            if (productToRemove == null) throw new ProductNotFoundException("Продукта с таким id нет в коллекции!");
            collectionManager.removeFromCollection(productToRemove);
            Console.println("Продукт успешно удален из коллекции!");
            return true;
        } catch (WrongNumberOfElementsException e) {
            Console.println(e.getMessage());
        } catch (CollectionIsEmptyException e) {
            Console.println(e.getMessage());
        } catch (ProductNotFoundException e) {
            Console.println(e.getMessage());
        }
        return false;
    }
}