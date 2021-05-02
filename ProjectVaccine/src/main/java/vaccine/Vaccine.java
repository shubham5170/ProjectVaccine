package vaccine;

import com.google.gson.Gson;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Vaccine {

    public static void main(String[] args) throws Exception {
     while(true)
     {
         runMethod();
         Thread.sleep(1800000);
     }
    }

    public static void runMethod() throws Exception {
        System.out.println("checking availability for next 7 days");
        URL url = new URL(
                "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=392&date=02-05-2021");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        Response response = getFullResponse(con);
        checkForAvailability(response);
        con.disconnect();
    }

    public static Response getFullResponse(HttpURLConnection con) throws Exception {
        StringBuilder fullResponseBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            fullResponseBuilder.append(inputLine);
        }
        in.close();
        Gson gson = new Gson();
        Response response = gson.fromJson(fullResponseBuilder.toString(), Response.class);
        return response;
    }

    public static void checkForAvailability(Response response) throws Exception {
        for (Center center : response.getCenters()) {
            for (Session session : center.getSessions()) {
                if (session.getAvailableCapacity() != 0 && session.getMinAgeLimit() == 18) {
                    AvailabilityInfoList.setAvailabilityInfo(center.getName(), session.getVaccine(),
                            session.getAvailableCapacity());
                }
            }
        }
        if (!AvailabilityInfoList.availabilityInfoList.isEmpty()) {
            AvailabilityInfoList.printList();
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=mdtVg-75Zu8"));
        }
    }
}
