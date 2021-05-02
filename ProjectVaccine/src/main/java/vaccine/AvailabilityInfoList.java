package vaccine;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityInfoList {
    static List<AvailabilityInfo> availabilityInfoList = new ArrayList<>();

    public static void setAvailabilityInfo(String centerName, String vaccineName, Integer availableCapacity)
    {
        AvailabilityInfo availabilityInfo = new AvailabilityInfo();
        availabilityInfo.setCenterName(centerName);
        availabilityInfo.setVaccineName(vaccineName);
        availabilityInfo.setAvailableCapacity(availableCapacity);
        availabilityInfoList.add(availabilityInfo);
    }

    public static void printList() {
        for (AvailabilityInfo availabilityInfo : availabilityInfoList) {
            System.out.println(
                    "Center Name: " + availabilityInfo.getCenterName() + " Vaccine Name: " + availabilityInfo.getVaccineName() + " Available Capacity: " + availabilityInfo
                            .getAvailableCapacity());
        }
    }

}
