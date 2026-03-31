package com.example.Pos.util.mappers;

import com.example.Pos.dto.request.ItemSaveRequestDTO;
import com.example.Pos.dto.response.ItemGetResponseDTO;
import com.example.Pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
    ItemGetResponseDTO entityToDto(Item item);
    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

//    Page<Item> item -----> List<ItemGetResponseDTO>list

    List<ItemGetResponseDTO> LisTDTOToPage (Page<Item> items);
}
