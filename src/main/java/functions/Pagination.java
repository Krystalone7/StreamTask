package functions;

import classes.Person;
import java.util.ArrayList;
import java.util.List;

public class Pagination {
    public static List<Person> paginate(List<Person> persons, int countOnPage, int page){
        List<Person> result = new ArrayList<>();
        int currentPos = countOnPage * (page - 1);
        for (int i = currentPos; i < currentPos + countOnPage; i++) {
            if(i == persons.size()){
                break;
            }
            result.add(persons.get(i));
        }
        return result;
    }
}
