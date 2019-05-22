package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.service.CocktailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CocktailControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CocktailService cocktailService;

    @Test
    public void getAllCocktails() throws Exception {

        given(cocktailService.searchCocktails("Russian")).willReturn(getMergedCocktails());
        mockMvc
                .perform(get("/cocktails")
                        .param("search", "Russian")
                        .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Margerita"))
                .andExpect(jsonPath("$[0].glass").value("Cocktail glass"))
                .andExpect(jsonPath("$[0].image").value("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg"))
                .andExpect(jsonPath("$[0].ingredients.length()").value(4))
                .andExpect(jsonPath("$[0].ingredients[0]").value("Salt"))
                .andExpect(jsonPath("$[0].ingredients[1]").value("Lime juice"))
                .andExpect(jsonPath("$[0].ingredients[2]").value("Tequila"))
                .andExpect(jsonPath("$[0].ingredients[3]").value("Triple sec"))
                .andExpect(jsonPath("$[1].name").value("Blue Margerita"))
                .andExpect(jsonPath("$[1].glass").value("Cocktail glass"))
                .andExpect(jsonPath("$[1].image").value("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg"))
                .andExpect(jsonPath("$[1].ingredients.length()").value(4))
                .andExpect(jsonPath("$[1].ingredients[0]").value("Blue Curacao"))
                .andExpect(jsonPath("$[1].ingredients[1]").value("Salt"))
                .andExpect(jsonPath("$[1].ingredients[2]").value("Lime juice"))
                .andExpect(jsonPath("$[1].ingredients[3]").value("Tequila"));
        // verify
        verify(cocktailService).searchCocktails("Russian");

    }

    private List<Cocktail> getMergedCocktails() {
        return Arrays.asList(
                new Cocktail(UUID.randomUUID(), "Margerita", "Cocktail glass", "",
                        "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                        new HashSet<>(Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt"))),
                new Cocktail(UUID.randomUUID(), "Blue Margerita", "Cocktail glass", "",
                        "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                        new HashSet<>(Arrays.asList("Tequila", "Blue Curacao", "Lime juice", "Salt"))));
    }
}
