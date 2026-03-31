package com.example.Pos.controller;

import com.example.Pos.dto.request.ItemSaveRequestDTO;
import com.example.Pos.dto.paginated.PaginatedResponseDTO;
import com.example.Pos.dto.response.ItemGetResponseDTO;
import com.example.Pos.service.ItemService;
import com.example.Pos.util.StandarardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    ItemService itemService;

//    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
//        String message = itemService.saveItem(itemSaveRequestDTO);
//        return "saved";
//    }

    @PostMapping("/save")
    public ResponseEntity<StandarardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        return new  ResponseEntity<StandarardResponse>(
                new StandarardResponse(201,"Sucess", message),
                HttpStatus.CREATED
        );
    }



    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItmByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItmByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItmByNameAndStatusByMapStruct(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItmByNameAndStatusByMapStruct(itemName);
        return itemDTOS;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandarardResponse> getItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
            ) {
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByActiveStatus(activeStatus,page,size);
        PaginatedResponseDTO paginatedResponseDTO = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return new  ResponseEntity<StandarardResponse>(
                new StandarardResponse(200,"Sucess", paginatedResponseDTO),
                HttpStatus.OK
        );
    }


}
