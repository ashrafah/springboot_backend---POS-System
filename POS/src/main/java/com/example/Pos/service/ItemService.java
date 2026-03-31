package com.example.Pos.service;

import com.example.Pos.dto.request.ItemSaveRequestDTO;
import com.example.Pos.dto.paginated.PaginatedResponseDTO;
import com.example.Pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItmByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItmByNameAndStatusByMapStruct(String itemName);

    PaginatedResponseDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
