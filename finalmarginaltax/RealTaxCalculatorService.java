package edu.citytech.cst.webproject.finalmarginaltax;

import com.taxservice.cst4713.ITaxCalculator;
import com.taxservice.cst4713.Status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealTaxCalculatorService implements ITaxCalculator {

    static Map<String, Status> map = new HashMap<>();
    static Map<Status, String> map2 = new HashMap<>();
    static{
        map.put("S", Status.S);
        map.put("HH", Status.HH);
        map.put("MFJ", Status.MFJ);

        map2.put(Status.S, "S");
        map2.put(Status.HH, "HH");
        map2.put(Status.MFJ, "MFJ");
    }

    public static Status getStatus(String sStatus){
        Status eStatus = map.get(sStatus);
        return eStatus;
    }

    public static String getStatus(Status eStatus){
        var sStatus = map2.get(eStatus);
        return sStatus;
    }

    static List<RealTaxBracket> taxBrackets = new RealTaxBracketRepository().findAll(e -> true);

    @Override
    public float getTaxPaid(int taxYear, Status status, float grossPay) {

        String sStatus = getStatus(status);

        var taxPaid =
                taxBrackets.stream().filter(e -> e.getCode().equals(sStatus) && e.getYear() == taxYear &&
                        e.getRange1() < grossPay && e.getRange2() >= grossPay)
                        .map(RealTaxBracket::getRate)
                        .findFirst().get() * grossPay;

        return taxPaid;

    }
    public float getTaxPaid(Status status, float grossPay) {

        float taxPaid = getTaxPaid(2021, status, grossPay);
        return taxPaid;
    }
}
