package me.day13.generic.method;

import me.day13.generic.bound.gift.Note;
import me.day13.generic.bound.gift.Pen;
import me.day13.generic.method.decoration.Decoration;
import me.day13.generic.method.decoration.Decorations;
import me.day13.generic.method.decoration.DryFlower;
import me.day13.generic.method.decoration.Ribbon;

public class GenericMethodExample {
    public static void main(String[] args) {
        Pen pen = new Pen("1001", "모닝글로리", "빨강");

        Box<Pen> boxingPen = Utils.boxing(pen);
        System.out.println("boxingPen = " + boxingPen);

        Utils.decoration(boxingPen, new Decorations(new Decoration[]{new Ribbon()}));

        Pen unboxingPen = Utils.unboxing(boxingPen);
        System.out.println("unboxingPen = " + unboxingPen);
        System.out.println();

        //////////////////////////////////////////////////////////////////
        Note note = new Note("1001", "모닝글로리", true);

        Box<Note> boxingNote = Utils.boxing(note);
        System.out.println("boxingNote = " + boxingNote);

        Utils.decoration(boxingPen, new Decorations(new Decoration[]{new DryFlower()}));

        Note unboxingNote = Utils.unboxing(boxingNote);
        System.out.println("unboxingNote = " + unboxingNote);
    }
}
