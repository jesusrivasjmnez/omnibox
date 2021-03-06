
package com.aiss.omnidrive.shared.dropbox.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "shared",
    "quota",
    "normal"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class DropboxQuotaInfo implements Serializable {

    @JsonProperty("shared")
    private Long shared;
    @JsonProperty("quota")
    private Long quota;
    @JsonProperty("normal")
    private Long normal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    

    /**
     * 
     * @return
     *     The shared
     */
    @JsonProperty("shared")
    public Long getShared() {
        return shared;
    }
    

    /**
     * 
     * @param shared
     *     The shared
     */
    @JsonProperty("shared")
    public void setShared(Long shared) {
        this.shared = shared;
    }
    

    /**
     * 
     * @return
     *     The quota
     */
    @JsonProperty("quota")
    public Long getQuota() {
        return quota;
    }
    

    /**
     * 
     * @param quota
     *     The quota
     */
    @JsonProperty("quota")
    public void setQuota(Long quota) {
        this.quota = quota;
    }
    


    /**
     * 
     * @return
     *     The normal
     */
    @JsonProperty("normal")
    public Long getNormal() {
        return normal;
    }
    

    /**
     * 
     * @param normal
     *     The normal
     */
    @JsonProperty("normal")
    public void setNormal(Long normal) {
        this.normal = normal;
    }
    

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void clearAdditionalProperties(){
    	this.additionalProperties.clear();
    }
    
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public Double getQuotaInGB(){
    	Double quotaGB;
    	Double quota;
    	
    	quota = new Double(this.getQuota());
    	quotaGB = (quota / 1024 / 1024 / 1024 ) * 100;
    	
    	return Math.round(quotaGB) / 100.0;
    }
    
    public Double getUsageInGB(){
    	Double usageGB;
    	Double usage;
    	
    	usage = new Double(this.getNormal());
    	usageGB = (usage / 1024 / 1024 / 1024 ) * 100;
    	
    	return Math.round(usageGB) / 100.0;
    }
    
    public Double getPercentUsage(){
    	Double limit, usage, percent;
    	
    	limit = new Double(this.getQuotaInGB());
    	usage = new Double(this.getUsageInGB());
    	percent = (usage / limit) * 10000;
    	
    	return Math.round(percent) / 100.0;
    }

}
