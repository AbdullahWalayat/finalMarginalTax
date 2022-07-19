package edu.citytech.cst.webproject.finalmarginaltax;

import com.taxservice.cst4713.Status;
import edu.citytech.cst.helper.utility.NumberUtility;
import edu.citytech.cst.webproject.marginaltaxrate.employee.Employee;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.function.Supplier;

@Controller
public class RealMarginalTaxController {

    @Autowired
    RealTaxRuleService service;

    @Autowired
    RealTaxBracketService serviceBracket;
    Map<Integer, Supplier<List<RealTaxRule>>> map = new HashMap<>();

    public void initialize(){
        System.out.println("Loading :" + new Date());

        map.put(2021, service::get2021);
        map.put(2020, service::get2020);
        map.put(2019, service::get2019);
    }


    @RequestMapping("/marginal-tax-rate")
    public String findTaxes(@ModelAttribute RealMarginalTaxInput formInput, Model model){


        if (map.size() == 0) initialize();
        var year = formInput.getYear();
        var status = formInput.getStatus();
        var sSalary = formInput.getSalary();

        float salary = (float) NumberUtility.getNumberValue(sSalary).value;

        var list = map.getOrDefault(year, () -> new ArrayList<>()).get();

        model.addAttribute("realTaxes", list);
        model.addAttribute("year", year);

        String statusDescription = "Single";

        if (formInput.getStatus().equals("S"))
        {
            statusDescription = "Single";

        } else if (formInput.getStatus().equals("MFJ")) {

            statusDescription = "Married Filing Jointly";

        } else if (formInput.getStatus().equals("HH")) {

            statusDescription = "Heads of Household";

        }

        model.addAttribute("status", statusDescription);
        model.addAttribute("salary", NumberUtility.commaStyle(salary));
        model.addAttribute("input", formInput);

        //partB
        var bracket = serviceBracket.getRealTaxBracketDescription(year, status,salary);
        float total = (float) serviceBracket.getRealTaxBracketDescription(year, status,salary).stream().mapToDouble(e -> e.getTaxPaid() < 0 ? 0 : e.getTaxPaid()).sum();
        float percent = calculateTotal(total,salary);

        model.addAttribute("taxesCalc", bracket);
        model.addAttribute("total", NumberUtility.commaStyle(total));
        model.addAttribute("percent", NumberUtility.percentStyle(percent));



        return "marginal-tax.jsp";
    }
    public float calculateTotal(float total,float salary){
        float percent = total/salary;

        return percent;
    }
}




