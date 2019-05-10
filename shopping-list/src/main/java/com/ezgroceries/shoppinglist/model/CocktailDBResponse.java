package com.ezgroceries.shoppinglist.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CocktailDBResponse {

    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public static class Drink {
        private String idDrink;
        private String strDrink;
        private String strGlass;
        private String strInstructions;
        private String strDrinkThumb;
        private String strIngredient1;
        private String strIngredient2;
        private String strIngredient3;
        private String strIngredient4;
        private String strIngredient5;
        private String strIngredient6;
        private String strIngredient7;
        private String strIngredient8;
        private String strIngredient9;
        private String strIngredient10;
        private String strIngredient11;
        private String strIngredient12;
        private String strIngredient13;
        private String strIngredient14;
        private String strIngredient15;

        public String getStrDrink() {
            return strDrink;
        }

        public String getStrGlass() {
            return strGlass;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public List<String> getStrIngredients() {

            List<String> ingredients = new ArrayList<>(Arrays.asList(
                    getStrIngredient1(),
                    getStrIngredient2(),
                    getStrIngredient3(),
                    getStrIngredient4(),
                    getStrIngredient5(),
                    getStrIngredient6(),
                    getStrIngredient7(),
                    getStrIngredient8(),
                    getStrIngredient9(),
                    getStrIngredient10(),
                    getStrIngredient11(),
                    getStrIngredient12(),
                    getStrIngredient13(),
                    getStrIngredient14(),
                    getStrIngredient15()
            ));

            ingredients.removeAll(Arrays.asList("", null));
            return ingredients;

        }

        public String getStrIngredient1() {
            return strIngredient1;
        }

        public String getStrIngredient2() {
            return strIngredient2;
        }

        public String getStrIngredient3() {
            return strIngredient3;
        }

        public String getStrIngredient4() {
            return strIngredient4;
        }

        public String getStrIngredient5() {
            return strIngredient5;
        }

        public String getStrIngredient6() {
            return strIngredient6;
        }

        public String getStrIngredient7() {
            return strIngredient7;
        }

        public String getStrIngredient8() {
            return strIngredient8;
        }

        public String getStrIngredient9() {
            return strIngredient9;
        }

        public String getStrIngredient10() {
            return strIngredient10;
        }

        public String getStrIngredient11() {
            return strIngredient11;
        }

        public String getStrIngredient12() {
            return strIngredient12;
        }

        public String getStrIngredient13() {
            return strIngredient13;
        }

        public String getStrIngredient14() {
            return strIngredient14;
        }

        public String getStrIngredient15() {
            return strIngredient15;
        }
    }

}
