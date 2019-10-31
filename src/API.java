import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class API {
    API(String url){
        this.url = url;
    }
    API(){
        url = "http://165.22.28.187/schedule-api/";
    }
    private String url;

    private String get(String query) {
        HttpURLConnection con = null;
        System.out.println(url+query);
        try{
            con = (HttpURLConnection) new URL(url + query).openConnection();
            con.setRequestMethod("GET");
            con.setUseCaches(false);
//            con.setConnectTimeout(5000);
//            con.setReadTimeout(5000);

            con.connect();

            StringBuilder stringBuilder = new StringBuilder();
            if (con.getResponseCode()==HttpURLConnection.HTTP_OK){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line).append("\n");
                }
                System.out.println(stringBuilder.toString());
                return (stringBuilder.toString());
            }else {
                System.out.println("FAIL: "+con.getResponseCode() + "\n" + con.getResponseMessage());
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            if (con!=null){
                con.disconnect();
            }
        }
        return null;
    }
    String groupQuery(String group){
        return get("?group="+group);
    }
    String groupAndWeekQuery(String group,String week){
        return get("?group="+group+"&week="+week);
    }
    String query(String query){
        return get("?query="+query);
    }

    @Deprecated
    String[] scheduleSpliterator(String queryRaw){
        String s = queryRaw.split("\"19:30-21:05\"], ")[1];
        s = s.split("]}, \"weeks\":")[0];
        String[] days = s.split("], \\[");
        days[0] = days[0].replace("[","");
        days[days.length-1] = days[days.length-1].replace("]","");
        return days;
    }
}
