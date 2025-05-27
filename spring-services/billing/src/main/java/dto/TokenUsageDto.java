package dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class TokenUsageDto {
    private Long id;
    private Long tokenId;
    private Long modelId;
    private Long usedTokens;
}
