
package vaccine;

import java.util.List;
import javax.annotation.processing.Generated;
import javax.annotation.processing.Generated;;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Response {

    @SerializedName("centers")
    @Expose
    private List<Center> centers = null;

    public List<Center> getCenters() {
        return centers;
    }

    public void setCenters(List<Center> centers) {
        this.centers = centers;
    }

}
