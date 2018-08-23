package patterns.state;

/**
 * Context class contains all available states + current state object.
 * When operation defined in {@link State} is called, it is getting called by currentStates class
 */
class Context {

    private final State stateOne;
    private final State stateTwo;

    private State currentState;

    public Context() {
        stateOne = new ConcreteStateOne(this);
        stateTwo = new ConcreteStateTwo(this);
        currentState = stateOne;
    }

    public State getConcreteStateOne() {
        return stateOne;
    }

    public State getConcreteStateTwo() {
        return stateTwo;
    }

    public void setState(State st) {
        currentState = st;
    }

    public void callOperation() {
        currentState.operation();
    }


}
