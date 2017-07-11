package learn_to_code.patterns.command;

/**
 * A command invoker. Note Invoker has no idea what type of commands do we have.
 * All it knows is that it could call command.callCommand() method to exetute it.
 */
public class Invoker {
    private Command command;

    public void registerCommand(Command command) {
        this.command = command;
    }

    public void callCommand() {
        command.execute();
    }

    public void callReversedCommand() {
        command.undo();
    }
}