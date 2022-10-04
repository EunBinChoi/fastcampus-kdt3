package me.day12.api.lang.clone;

import me.day07.object.compare.Person;

import java.util.Arrays;
import java.util.Objects;

public class ObjectCopyExample implements Cloneable {
    private int intVariable;
    private String strVariable;
    private Person[] personArray;

    public ObjectCopyExample() {}

    public ObjectCopyExample(int intVariable, String strVariable, Person[] personArray) {
        this.intVariable = intVariable;
        this.strVariable = strVariable;
        this.personArray = personArray;
    }


    public int getIntVariable() {
        return intVariable;
    }

    public void setIntVariable(int intVariable) {
        this.intVariable = intVariable;
    }

    public String getStrVariable() {
        return strVariable;
    }

    public void setStrVariable(String strVariable) {
        this.strVariable = strVariable;
    }

    public Person[] getPersonArray() {
        return personArray;
    }

    public void setPersonArray(Person[] personArray) {
        this.personArray = personArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectCopyExample that = (ObjectCopyExample) o;
        return intVariable == that.intVariable && Objects.equals(strVariable, that.strVariable) && Arrays.equals(personArray, that.personArray);
    }

    @Override
    public String toString() {
        return "ObjectCopyExample{" +
                "intVariable=" + intVariable +
                ", strVariable='" + strVariable + '\'' +
                ", personArray=" + Arrays.toString(personArray) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(intVariable, strVariable);
        result = 31 * result + Arrays.hashCode(personArray);
        return result;
    }

    public static ObjectCopyExample getNewInstance(ObjectCopyExample origin) {
        ObjectCopyExample objectCopyExample = new ObjectCopyExample();
        objectCopyExample.setIntVariable(origin.intVariable);
        objectCopyExample.setStrVariable(origin.strVariable);

        objectCopyExample.personArray = new Person[origin.personArray.length];
        for (int i = 0; i < objectCopyExample.personArray.length; i++) {
            objectCopyExample.personArray[i] = new Person();
            objectCopyExample.personArray[i].setName(origin.personArray[i].getName());
            objectCopyExample.personArray[i].setGender(origin.personArray[i].getGender());
            objectCopyExample.personArray[i].setBirthdate(origin.personArray[i].getBirthdate());
            objectCopyExample.personArray[i].setRegistrationNumber(origin.personArray[i].getRegistrationNumber());
        }
        return objectCopyExample;
    }

    @Override
    public ObjectCopyExample clone() throws CloneNotSupportedException {
        ObjectCopyExample objectCopyExample = (ObjectCopyExample) super.clone(); // shallow copy
        objectCopyExample.personArray = new Person[personArray.length];
        for (int i = 0; i < objectCopyExample.personArray.length; i++) {
//            objectCopyExample.personArray[i] = new Person();
//            objectCopyExample.personArray[i].setName(personArray[i].getName());
//            objectCopyExample.personArray[i].setGender(personArray[i].getGender());
//            objectCopyExample.personArray[i].setBirthdate(personArray[i].getBirthdate());
//            objectCopyExample.personArray[i].setRegistrationNumber(personArray[i].getRegistrationNumber());

            objectCopyExample.personArray[i] = personArray[i];
            // 배열 이름은 주소 저정이 되어있으므로 주소 복사가 됨 (잘못된 복사)
        }
        return objectCopyExample;
    }
}
