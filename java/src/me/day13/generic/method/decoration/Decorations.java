package me.day13.generic.method.decoration;

import java.util.Arrays;

public class Decorations {
    private Decoration[] decorations;

    public Decorations(Decoration[] decorations) {
        this.decorations = decorations;
    }

    public Decoration[] getDecorations() {
        return decorations;
    }

    public void setDecorations(Decoration[] decorations) {
        this.decorations = decorations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decorations that = (Decorations) o;
        return Arrays.equals(decorations, that.decorations);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(decorations);
    }

    @Override
    public String toString() {
        return "Decorations{" + Arrays.toString(decorations) + '}';
    }
}
