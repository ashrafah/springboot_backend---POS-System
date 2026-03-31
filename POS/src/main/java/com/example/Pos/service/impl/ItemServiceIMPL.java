package com.example.Pos.service.impl;

import com.example.Pos.dto.request.ItemSaveRequestDTO;
import com.example.Pos.dto.paginated.PaginatedResponseDTO;
import com.example.Pos.dto.response.ItemGetResponseDTO;
import com.example.Pos.entity.Item;
import com.example.Pos.repo.ItemRepo;
import com.example.Pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.Pos.util.mappers.ItemMapper;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService{

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
//        Item item = itemMapper.dtoToEntity(itemSaveRequestDTO);
        if (!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "Item saved successfully";
        }else {
            throw new DuplicateKeyException("Item already exists");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItmByNameAndStatus(String itemName) {

        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if (items.size()>0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {
            }.getType());
            return itemGetResponseDTOS;
        }else  {
            throw new RuntimeException("Item Not Found");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItmByNameAndStatusByMapStruct(String itemName) {

        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);

        if (items.size()>0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else  {
            throw new RuntimeException("Item Not Found");

        }
    }

    @Override
    public PaginatedResponseDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> item = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page,size));
        int count = itemRepo.countAllByActiveStateEquals(activeStatus);
        if (item.getSize()<1){
            throw new RuntimeException("No Data");
        }

        PaginatedResponseDTO paginatedResponseDTO = new PaginatedResponseDTO(
            itemMapper.LisTDTOToPage(item),count
        );
        return paginatedResponseDTO;
    }
}
