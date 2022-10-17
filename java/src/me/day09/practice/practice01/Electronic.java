package me.day09.practice.practice01;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Electronic {
    public enum Company { SAMSUNG, LG, APPLE }
    public enum AuthMethod { FINGER, PATTERN, PIN, FACE }

    protected String productNo; /* auto-generated */
    protected String modelName;
    protected Company companyName;
    protected Date dateOfMade;
    protected AuthMethod[] authMethod;
    private static int count = 0;

    public Electronic() {
        generateKey();
    }

    public Electronic(String modelName, Company companyName, Date dateOfMade, AuthMethod[] authMethod) {
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    private void generateKey() {
        count++; // 0 <=  < 10000
        productNo = String.format("%05d", count); // 0 <   <= 10000
    }

    public String getProductNo() {
        return productNo;
    }

    private void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    public Date getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(Date dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return productNo.equals(that.productNo) && modelName.equals(that.modelName) && companyName == that.companyName && dateOfMade.equals(that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
