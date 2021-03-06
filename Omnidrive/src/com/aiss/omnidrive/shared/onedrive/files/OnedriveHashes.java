
package com.aiss.omnidrive.shared.onedrive.files;

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
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "crc32Hash",
    "sha1Hash"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class OnedriveHashes implements Serializable {

    @JsonProperty("crc32Hash")
    private String crc32Hash;
    @JsonProperty("sha1Hash")
    private String sha1Hash;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The crc32Hash
     */
    @JsonProperty("crc32Hash")
    public String getCrc32Hash() {
        return crc32Hash;
    }

    /**
     * 
     * @param crc32Hash
     *     The crc32Hash
     */
    @JsonProperty("crc32Hash")
    public void setCrc32Hash(String crc32Hash) {
        this.crc32Hash = crc32Hash;
    }

    /**
     * 
     * @return
     *     The sha1Hash
     */
    @JsonProperty("sha1Hash")
    public String getSha1Hash() {
        return sha1Hash;
    }

    /**
     * 
     * @param sha1Hash
     *     The sha1Hash
     */
    @JsonProperty("sha1Hash")
    public void setSha1Hash(String sha1Hash) {
        this.sha1Hash = sha1Hash;
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
