package com.viper.ckframework.keymanager.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * List of api tokens
 */

@Schema(name = "GetApiTokensResponse", description = "List of api tokens")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-16T19:04:54.913224400+03:00[Europe/Moscow]", comments = "Generator version: 7.12.0")
public class GetApiTokensResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private List<@Valid ApiTokenDto> tokens = new ArrayList<>();

    public GetApiTokensResponse tokens(List<@Valid ApiTokenDto> tokens) {
        this.tokens = tokens;
        return this;
    }

    public GetApiTokensResponse addTokensItem(ApiTokenDto tokensItem) {
        if (this.tokens == null) {
            this.tokens = new ArrayList<>();
        }
        this.tokens.add(tokensItem);
        return this;
    }

    /**
     * Signed jwt token
     * @return tokens
     */
    @Valid
    @Schema(name = "tokens", description = "Signed jwt token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("tokens")
    public List<@Valid ApiTokenDto> getTokens() {
        return tokens;
    }

    public void setTokens(List<@Valid ApiTokenDto> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetApiTokensResponse getApiTokensResponse = (GetApiTokensResponse) o;
        return Objects.equals(this.tokens, getApiTokensResponse.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokens);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetApiTokensResponse {\n");
        sb.append("    tokens: ").append(toIndentedString(tokens)).append("\n");
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
