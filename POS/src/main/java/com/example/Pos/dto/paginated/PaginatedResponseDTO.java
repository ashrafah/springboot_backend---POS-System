package com.example.Pos.dto.paginated;

import com.example.Pos.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseDTO {
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
