package com.rentalapp.application.api;

import com.rentalapp.application.model.BookCreateRequest;
import com.rentalapp.application.model.BookResponse;
import com.rentalapp.application.model.BookUpdateRequest;
import com.rentalapp.application.model.BooksResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("books")
public interface BookApi {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    int insertBook(@RequestBody BookCreateRequest request);

    @GetMapping(value = "{id}")
    BookResponse selectOne(@PathVariable Integer id);

    @GetMapping
    BooksResponse select(
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(name = "sort", required = false, defaultValue = "id asc") String sort);

    @PutMapping(value = "{id}")
    int update(@PathVariable("id") Integer id, @RequestBody BookUpdateRequest req);

    @DeleteMapping(value = "{id}")
    int deleteOne(@PathVariable("id") Integer id);
}
