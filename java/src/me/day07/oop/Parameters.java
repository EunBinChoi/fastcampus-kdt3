package me.day07.oop;

public class Parameters {
    public static final int NUM_PARAMETER = Grade.values().length;
    public Parameter[] parameters = new Parameter[NUM_PARAMETER];

    public Parameters() {
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = new Parameter();
        }
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    // is it right code?
    public Grade classify(Customers customers) {
        // TODO: Write Code for Classifying the Customers with Parameters
        return null;
    }
}
