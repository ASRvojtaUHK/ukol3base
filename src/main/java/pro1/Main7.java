package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.PrijmackyList;
import pro1.apiDataModel.PrijmackyModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main7
    {

        public static void Main(String[] args){
            System.out.println(getDeadlines(2025));
        }
        public static String getDeadlines(int year){

            String json = Api.getSpecializations(year);
            PrijmackyList p= new Gson().fromJson(json, PrijmackyList.class);


            Set<String> dates = new HashSet<>();

            p.items.stream().forEach(a->{dates.add(a.deadlinePrihlaska.value);});

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            List<String> sorted = new ArrayList<>(dates);
            sorted.sort(Comparator.comparing(dateStr -> LocalDate.parse(dateStr, formatter)));

            return String.join(",",sorted);
        }

    }
