import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Queue
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // add()

        // Stack
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();

        cookingTable.values()
                .forEach(p -> productsCooked.put(p, 0));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();

            int sum = currentLiquid + currentIngredient;
            if (ableToCookProduct(sum)) {
                String product = cookingTable.get(sum);
                productsCooked.put(product, productsCooked.get(product) + 1);
            } else {
                ingredients.push(currentIngredient + 3);
            }
        }

        if (hasCookedEachMeal(productsCooked)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! " +
                    "You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquids));
        System.out.println("Ingredients left: " + getElementsInfo(ingredients));

        productsCooked.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static boolean hasCookedEachMeal(Map<String, Integer> productsCooked) {
        return
                productsCooked.values()
                        .stream()
                        .noneMatch(c -> c == 0);
    }

    private static boolean ableToCookProduct(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
