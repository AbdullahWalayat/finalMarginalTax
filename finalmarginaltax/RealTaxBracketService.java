package edu.citytech.cst.webproject.finalmarginaltax;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealTaxBracketService {
    static private RealTaxBracketRepository repository = new RealTaxBracketRepository();

    public List<RealTaxBracketDescription> getRealTaxBracketDescription(int year, String status, float salary){

        var list = repository.findAll( e -> e.getYear() == year && e.getCode().equals(status) )
                .stream()
                .map(e -> new RealTaxBracketDescription(e, salary))
                .toList();
        return list;

    }

    public static void main(String[] args) {
        new RealTaxBracketService().getRealTaxBracketDescription(2021, "S", 150_000)
                .forEach(System.out::println);

        var total = new RealTaxBracketService().getRealTaxBracketDescription(2021, "S", 150_000)
                .stream()
                .mapToDouble(e -> e.getTaxPaid() < 0 ? 0 : e.getTaxPaid()).sum();
        System.out.println(total);
    }
}
