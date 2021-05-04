package Commands;

public interface Command {
    String getName();
    String getDescr();
    boolean startExecute(String arg);
}

