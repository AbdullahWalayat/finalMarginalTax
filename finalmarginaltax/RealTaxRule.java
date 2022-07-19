package edu.citytech.cst.webproject.finalmarginaltax;

import edu.citytech.cst.helper.utility.NumberUtility;
import org.apache.poi.ss.usermodel.Row;

public class RealTaxRule {

    private float taxRate;

    private float singleSalary;

    private float marriedFilingJointSalary;

    private float headOfHouseholdSalary;

    String formattedSalarySingleSalary, formattedMarriedFilingJointSalary, formattedHeadOfHouseholdSalary, formattedTaxRate;

    public RealTaxRule(Row row) {
        this.taxRate = (float) row.getCell(1).getNumericCellValue();
        this.singleSalary = (float) row.getCell(2).getNumericCellValue();
        this.marriedFilingJointSalary = (float) row.getCell(3).getNumericCellValue();
        this.headOfHouseholdSalary = (float) row.getCell(4).getNumericCellValue();
        this.formattedSalarySingleSalary = NumberUtility.commaStyle(singleSalary);
        this.formattedMarriedFilingJointSalary = NumberUtility.commaStyle(marriedFilingJointSalary);
        this.formattedHeadOfHouseholdSalary = NumberUtility.commaStyle(headOfHouseholdSalary);
        this.formattedTaxRate = NumberUtility.percentStyle(taxRate);
    }

    public float getTaxRate() {
        return taxRate;
    }

    public float getSingleSalary() {
        return singleSalary;
    }

    public float getMarriedFilingJointSalary() {
        return marriedFilingJointSalary;
    }

    public float getHeadOfHouseholdSalary() {
        return headOfHouseholdSalary;
    }

    public String getFormattedSalarySingleSalary() {
        return formattedSalarySingleSalary;
    }

    public String getFormattedMarriedFilingJointSalary() {
        return formattedMarriedFilingJointSalary;
    }

    public String getFormattedHeadOfHouseholdSalary() {
        return formattedHeadOfHouseholdSalary;
    }

    public String getFormattedTaxRate() {
        return formattedTaxRate;
    }

    @Override
    public String toString() {
        return "RealTaxRule{" +
                "taxRate=" + taxRate +
                ", singleSalary=" + singleSalary +
                ", marriedFilingJointSalary=" + marriedFilingJointSalary +
                ", headOfHouseholdSalary=" + headOfHouseholdSalary +
                '}';
    }
}
