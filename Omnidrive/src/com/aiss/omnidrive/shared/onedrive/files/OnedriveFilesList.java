
package com.aiss.omnidrive.shared.onedrive.files;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "@odata.context",
    "value"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class OnedriveFilesList implements Serializable {

    @JsonProperty("@odata.context")
    private String OdataContext;
    @JsonProperty("value")
    private List<OnedriveFile> files = new ArrayList<OnedriveFile>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OdataContext
     */
    @JsonProperty("@odata.context")
    public String getOdataContext() {
        return OdataContext;
    }

    /**
     * 
     * @param OdataContext
     *     The @odata.context
     */
    @JsonProperty("@odata.context")
    public void setOdataContext(String OdataContext) {
        this.OdataContext = OdataContext;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public List<OnedriveFile> getFiles() {
        return files;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(List<OnedriveFile> files) {
        this.files = files;
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
