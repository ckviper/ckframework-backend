package com.viper.ckframework.keymanager.api;

import com.viper.ckframework.keymanager.model.ApiTokenDto;
import com.viper.ckframework.keymanager.model.ErrorDto;
import com.viper.ckframework.keymanager.model.GetApiTokensResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-16T19:04:54.913224400+03:00[Europe/Moscow]", comments = "Generator version: 7.12.0")
@Validated
@Tag(name = "token", description = "the token API")
public interface ApiTokenApi {

    /**
     * GET /v1/token/generate : Generate api token
     * Generate api token for service
     *
     * @return Token successfully generated (status code 200)
     *         or Wrong password or email (status code 403)
     *         or Unexpected error (status code 200)
     */
    @Operation(
            operationId = "generateToken",
            summary = "Generate api token",
            description = "Generate api token for service",
            tags = { "token" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token successfully generated", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiTokenDto.class))
                    }),
                    @ApiResponse(responseCode = "403", description = "Wrong password or email", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Unexpected error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerHttpAuthentication")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/token/generate",
            produces = { "application/json" }
    )

    ResponseEntity<ApiTokenDto> generateToken(

    );


    /**
     * GET /v1/token/jwks
     * Get jwks to verify the token jwt signature
     *
     * @return jwks body (status code 200)
     *         or Unexpected error (status code 200)
     */
    @Operation(
            operationId = "getJwks",
            description = "Get jwks to verify the token jwt signature",
            tags = { "token" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "jwks body", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Unexpected error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/token/jwks",
            produces = { "application/json" }
    )

    ResponseEntity<String> getJwks(

    );


    /**
     * GET /v1/token : Get all user tokens
     * Get all user tokens
     *
     * @return The list of all generated tokens (status code 200)
     *         or Project not found (status code 403)
     *         or Unexpected error (status code 200)
     */
    @Operation(
            operationId = "getTokens",
            summary = "Get all user tokens",
            description = "Get all user tokens",
            tags = { "token" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "The list of all generated tokens", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GetApiTokensResponse.class))
                    }),
                    @ApiResponse(responseCode = "403", description = "Project not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Unexpected error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerHttpAuthentication")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/token",
            produces = { "application/json" }
    )

    ResponseEntity<GetApiTokensResponse> getTokens(

    );

}
