package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main4 {

    public static void main(String[] args) {
         printShortestEmails("KIKM",5);
    }

    public static void printShortestEmails(String department, int count)
    {

        String json = Api.getTeachersByDepartment(department);
        TeachersList ucitele = new Gson().fromJson(json, TeachersList.class);


        ucitele.items.stream()
                .filter(u->u.email!=null)
                .sorted(Comparator.comparing(a->a.email.length()))
                .limit(count)
                .forEach(p-> System.out.println(p.email));



        // TODO 4.1: Vypiš do konzole "count" nejkratších učitelských emailových adres
    }
}