package edu.citytech.cst.webproject.finalmarginaltax;

import edu.citytech.cst.helper.utility.NumberUtility;

public class RealTaxBracketDescription {

    private String bracket;

    private String calculateDescription;

    private float taxPaid = 0;



    public RealTaxBracketDescription(RealTaxBracket taxBracket, float salary){
        float range1 = taxBracket.getRange1();
        float range2 = taxBracket.getRange2() > salary ? salary : taxBracket.getRange2();
        this.bracket = taxBracket.getFormattedRate() + " Bracket:";
        this.calculateDescription = "(" + range2 + " - " + range1 + ") x " + taxBracket.getFormattedRate() + "  " ;
        this.taxPaid = ( range2 - range1) * taxBracket.getRate() ;
        this.calculateDescription = taxPaid < 0 ? "Not Applicable" : this.calculateDescription + " = " + taxPaid;
    }

    public float getTaxPaid() {
        return taxPaid;
    }

    public String getBracket() {
        return bracket;
    }

    public String getCalculateDescription() {
        return calculateDescription;
    }

    @Override
    public String toString() {
        return "RealTaxBracketDescription{" +
                "bracket='" + bracket + '\'' +
                ", calculateDescription='" + calculateDescription + '\'' +
                '}';
    }
}
