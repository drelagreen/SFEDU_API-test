package JacksonObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "table",
    "weeks"
})
public class Schedule {

    @JsonProperty("table")
    private Table table;
    @JsonProperty("weeks")
    private List<Integer> weeks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("table")
    public Table getTable() {
        return table;
    }

    @JsonProperty("table")
    public void setTable(Table table) {
        this.table = table;
    }

    @JsonProperty("weeks")
    public List<Integer> getWeeks() {
        return weeks;
    }

    @JsonProperty("weeks")
    public void setWeeks(List<Integer> weeks) {
        this.weeks = weeks;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
