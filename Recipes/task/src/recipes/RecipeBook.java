package recipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeBook {
    ArrayList<Recipe> recipes = new ArrayList<>();

    public int addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipes.size();
    }

    public Recipe getRecipeById(int id) {
        return recipes.get(id - 1);
    }
}