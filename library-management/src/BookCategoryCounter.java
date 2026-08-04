import java.util.HashMap;

public class BookCategoryCounter {
    public static HashMap<String, Integer> countByCategory (String[] categories){
        HashMap<String, Integer> count = new HashMap<>();
        for(String category : categories){
            count.put(category,count.getOrDefault(category,0) + 1);
        }
        return count;
    }
}
