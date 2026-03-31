package com.example.Pos.util.mappers;

import com.example.Pos.dto.request.ItemSaveRequestDTO;
import com.example.Pos.dto.response.ItemGetResponseDTO;
import com.example.Pos.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-30T10:52:40+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public List<ItemGetResponseDTO> entityListToDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>( items.size() );
        for ( Item item : items ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }

    @Override
    public ItemGetResponseDTO entityToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        itemGetResponseDTO.setItemId( item.getItemId() );
        itemGetResponseDTO.setItemName( item.getItemName() );
        itemGetResponseDTO.setBalanceQty( item.getBalanceQty() );
        itemGetResponseDTO.setSupplierPrice( item.getSupplierPrice() );
        itemGetResponseDTO.setSellingPrice( item.getSellingPrice() );

        return itemGetResponseDTO;
    }

    @Override
    public Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO) {
        if ( itemSaveRequestDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemName( itemSaveRequestDTO.getItemName() );
        item.setMeasuringUnitType( itemSaveRequestDTO.getMeasuringUnitType() );
        item.setBalanceQty( itemSaveRequestDTO.getBalanceQty() );
        item.setSupplierPrice( itemSaveRequestDTO.getSupplierPrice() );
        item.setSellingPrice( itemSaveRequestDTO.getSellingPrice() );

        return item;
    }

    @Override
    public List<ItemGetResponseDTO> LisTDTOToPage(Page<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>();
        for ( Item item : items ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }
}
