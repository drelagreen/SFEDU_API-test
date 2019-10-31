package WeekObj;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Day {
    public static String[] time = new String[]{"08:00-09:35", "09:50-11:25", "11:55-13:30", "13:45-15:20", "15:50-17:25", "17:40-19:15", "19:30-21:05"};
    String[] pares = new String[7];
    String date;
    public ArrayList<String> objects = new ArrayList<>(7);
    public ArrayList<ArrayList<String>> prepods = new ArrayList<>(7);
    public ArrayList<ArrayList<String>> rooms = new ArrayList<>(7);
    String[] getPare(int i){
        if (i>7|i<1){
            return null;
        }
        String[] s = new String[2];
        s[0]=pares[i-1];
        s[1]=time[i-1];
        return s;
    }
    String[][] getPares(){
        String[][] s = new String[7][2];
        for (int i = 0; i < 7; i++) {
            s[i][0]=pares[i];
            s[i][1]=time[i];
        }
        return s;
    }
    void setPares(List<String> arrayList){
        date = arrayList.get(0);
        prepods.clear();
        rooms.clear();
        for (int i = 0; i < 7; i++) {
            prepods.add(new ArrayList<String>());
            rooms.add(new ArrayList<String>());
        }
        for (int i = 1; i <arrayList.size(); i++) {
            StringBuilder obj = new StringBuilder();
            StringBuilder prepod = new StringBuilder();
            StringBuilder room = new StringBuilder();
            String s = arrayList.get(i);
            if (s.equals("")){
                objects.add(i-1,"-");
                prepods.get(i-1).add("");
                rooms.get(i-1).add("");
                continue;
            }
            char c[] = s.toCharArray();
            int upCount = 0;
            boolean isRoom = false;
            for (int j = 0; j < c.length; j++) {
                if (Character.isUpperCase(c[j])){
                    upCount++;
                    if (isRoom&&c[j-1]==' '){
                        rooms.get(i-1).add(room.toString());
                        //todo test
                        room = new StringBuilder();
                        isRoom = false;
                    }
                    if (c[j+1]=='-'){
                        prepods.get(i-1).add(prepod.toString());
                        //todo test
                        prepod = new StringBuilder();
                        isRoom = true;
                    }
                }
                if (isRoom){
                    room.append(c[j]);
                    continue;
                }
                if (upCount<=1){
                    obj.append(c[j]);
                }
                if (upCount>1){
                    prepod.append(c[j]);
                }
            }
            if (!room.toString().equals("")){
                rooms.get(i-1).add(room.toString());
            }
            if (!prepod.toString().equals("")){
                prepods.get(i-1).add(prepod.toString());
            }
            objects.add(i-1,obj.toString());
            //todo test
            pares[i-1]= arrayList.get(i);
        }
    }
    static String getTime(int pare){
        return time[pare-1];
    }
}
