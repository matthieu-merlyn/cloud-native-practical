package com.ezgroceries.shoppinglistnew.client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        public String getIdDrink() {
            return idDrink;
        }

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

        public Set<String> getStrIngredients() {
            Set<String> ingredients = new HashSet<>();
            ingredients.add(getStrIngredient1());
            ingredients.add(getStrIngredient2());
            ingredients.add(getStrIngredient3());
            ingredients.add(getStrIngredient4());
            ingredients.add(getStrIngredient5());
            ingredients.add(getStrIngredient6());
            ingredients.add(getStrIngredient7());
            ingredients.add(getStrIngredient8());
            ingredients.add(getStrIngredient9());
            ingredients.add(getStrIngredient10());
            ingredients.add(getStrIngredient11());
            ingredients.add(getStrIngredient12());
            ingredients.add(getStrIngredient13());
            ingredients.add(getStrIngredient14());
            ingredients.add(getStrIngredient15());
            return ingredients.stream().filter(i -> i!= null && !i.isEmpty()).collect(Collectors.toSet());
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

        public void setIdDrink(String idDrink) {
            this.idDrink = idDrink;
        }

        public void setStrDrink(String strDrink) {
            this.strDrink = strDrink;
        }

    }

}
