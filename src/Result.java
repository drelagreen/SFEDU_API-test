import JacksonObjects.*;
import WeekObj.Week;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private API api = new API();
    private JacksonSrc<Search> jacksonSearch = new JacksonSrc<>(Search.class);
    private JacksonSrc<Schedule> jacksonSchedule = new JacksonSrc<>(Schedule.class);

    public API getApi() {
        return api;
    }

    public static void main(String[] args) {
            Week w = new Week();
            API api = new API();
            Schedule s = new JacksonSrc<Schedule>(Schedule.class).converter(api.query("КТсо1-4"));
            w.setDays(s.getTable().getTable());
        for (String object : w.getDay(1).objects) {
            System.out.println(object);
        }
        for (ArrayList<String> prepod : w.getDay(1).prepods) {
            System.out.println(prepod);
        }
        for (ArrayList<String> room : w.getDay(1).rooms) {
            System.out.println(room);
        }
            }
    Week week;
    Schedule schedule;
    Search search;

    Result(String string) {
       String query = api.query(string);
       System.out.println(query);
        if (query.contains("choices")) {
            search = jacksonSearch.converter(query);
        }
        if (query.contains("table")){
            schedule = jacksonSchedule.converter(query);
            week = new Week();
            week.setDays(schedule.getTable().getTable());
        }
   }

    /*
    type name
    week неделя
    Пнд,07 октября
    1)
    2)
    3)
    4)
    5)
    6)


     */


}



