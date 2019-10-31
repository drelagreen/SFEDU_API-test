package WeekObj;

import java.util.ArrayList;
import java.util.List;

public class Week {
    private Day[] days = new Day[6];

    public void setDays(List<List<String>> strings) {
        for (int i = 0; i < 6 ; i++) {
            days[i]=new Day();
        }
        for (int i = 2; i < 8; i++) {
            System.out.println(strings.get(i));
            days[i-2].setPares(strings.get(i));
        }
    }

    public Day getDay(int i) {
        return days[i-1];
    }
}
