package edu.citytech.cst.webproject.finalmarginaltax;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.Location;
import edu.citytech.cst.helper.utility.ReadExcelUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RealTaxRuleRepository implements IQuery<RealTaxRule> {

    private List<RealTaxRule> list;

    RealTaxRuleRepository(){
        list = ReadExcelUtility.processRange(Location.RESOURCE,
                "static/SimpleTaxRate.xlsx", "rules2021",
                "B2:E8",4, RealTaxRule::new);
    }

    @Override
    public RealTaxRule findById(Predicate<RealTaxRule> predicate) {
        return null;
    }

    @Override
    public List<RealTaxRule> findAll(Predicate<RealTaxRule> predicate) {

        var currentList = this.list.stream()
                .filter(predicate).toList();

        return currentList;
    }
}
