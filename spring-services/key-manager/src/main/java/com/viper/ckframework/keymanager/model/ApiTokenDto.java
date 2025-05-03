package com.viper.ckframework.keymanager.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Api token dto
 */

@Schema(name = "ApiTokenDto", description = "Api token dto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-16T19:04:54.913224400+03:00[Europe/Moscow]", comments = "Generator version: 7.12.0")
public class ApiTokenDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String apiToken;

    public ApiTokenDto() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ApiTokenDto(String apiToken) {
        this.apiToken = apiToken;
    }

    public ApiTokenDto apiToken(String apiToken) {
        this.apiToken = apiToken;
        return this;
    }

    /**
     * Signed jwt token
     * @return apiToken
     */
    @NotNull
    @Schema(name = "api_token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", description = "Signed jwt token", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("api_token")
    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiTokenDto apiTokenDto = (ApiTokenDto) o;
        return Objects.equals(this.apiToken, apiTokenDto.apiToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiTokenDto {\n");
        sb.append("    apiToken: ").append(toIndentedString(apiToken)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


