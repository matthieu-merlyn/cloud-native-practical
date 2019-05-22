package com.ezgroceries.shoppinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingListControllerTests {

    @Autowired
    private MockMvc mockMvc;

    // MME - old tests

    @Test
    public void getAllShoppingLists() throws Exception {
        this.mockMvc.perform(get("/shopping-lists"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Stephanie's Birthday"))
                .andExpect(jsonPath("$[0].ingredients.length()").value(5))
                .andExpect(jsonPath("$[0].ingredients[0]").value("Tequila"))
                .andExpect(jsonPath("$[0].ingredients[1]").value("Triple Sec"))
                .andExpect(jsonPath("$[0].ingredients[2]").value("Lime Juice"))
                .andExpect(jsonPath("$[0].ingredients[3]").value("Salt"))
                .andExpect(jsonPath("$[0].ingredients[4]").value("Blue Curacao"))
                .andExpect(jsonPath("$[1].name").value("My Birthday"))
                .andExpect(jsonPath("$[1].ingredients.length()").value(5))
                .andExpect(jsonPath("$[1].ingredients[0]").value("Tequila"))
                .andExpect(jsonPath("$[1].ingredients[1]").value("Triple Sec"))
                .andExpect(jsonPath("$[1].ingredients[2]").value("Lime Juice"))
                .andExpect(jsonPath("$[1].ingredients[3]").value("Salt"))
                .andExpect(jsonPath("$[1].ingredients[4]").value("Blue Curacao"));
    }

    @Test
    public void getSpecificShoppingList() throws Exception {
        this.mockMvc.perform(get("/shopping-lists/e8578c70-9e27-4440-965f-06a0aa8de5cd"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name").value("Stephanie's Birthday"))
                .andExpect(jsonPath("$.ingredients.length()").value(5))
                .andExpect(jsonPath("$.ingredients[0]").value("Tequila"))
                .andExpect(jsonPath("$.ingredients[1]").value("Triple Sec"))
                .andExpect(jsonPath("$.ingredients[2]").value("Lime Juice"))
                .andExpect(jsonPath("$.ingredients[3]").value("Salt"))
                .andExpect(jsonPath("$.ingredients[4]").value("Blue Curacao"));
    }

    @Test
    public void createShoppingList() throws Exception {
        this.mockMvc.perform(post("/shopping-lists")
                .content("{\"name\": \"Stephanie's Birthday\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name").value("Stephanie's Birthday"));
    }

}
