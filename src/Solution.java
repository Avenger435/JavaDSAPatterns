import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects; // Used for null checking

/**
 * A utility class to convert a String array to a List and perform
 * subsequent modifications like replacement and compaction.
 */
public class ArrayToList {

    private List<String> dataList;

    /**
     * Initializes the internal list to be empty.
     */
    public ArrayToList() {
        this.dataList = new ArrayList<>();
    }

    /**
     * Converts a String array to the internal list, filtering out 
     * null and empty strings, and throwing an exception if any are found.
     * * @param a The input String array.
     * @throws InvalidStringException if the array contains any null or empty string.
     */
    public void Convert(String[] a) throws InvalidStringException {
        if (a == null) {
            // Handle null array case gracefully, perhaps clearing the current list
            this.dataList.clear(); 
            return; 
        }

        // Check for invalid strings (null or empty)
        for (String s : a) {
            if (s == null || s.isEmpty()) {
                throw new InvalidStringException("Input array contains a null or empty string (\"\").");
            }
        }

        // If all strings are valid, convert and replace the internal list
        this.dataList = new ArrayList<>(Arrays.asList(a));
        // Alternatively: 
        // this.dataList.clear();
        // for (String s : a) {
        //     this.dataList.add(s);
        // }
    }

    /**
     * Replaces the string at a specific index in the internal list with a new string.
     * The new string is constructed by concatenating the original string with itself.
     * * @param idx The index of the string to replace.
     * @throws IndexOutOfBoundsException if the index is out of the list's range.
     */
    public void Replace(int idx) throws IndexOutOfBoundsException {
        // IndexOutOfBoundsException is automatically thrown by List.get(idx) 
        // or List.set(idx, element), so explicit checking is often not necessary 
        // unless you want a custom message.
        
        if (idx < 0 || idx >= this.dataList.size()) {
             throw new IndexOutOfBoundsException("Index " + idx + " is out of bounds for list of size " + this.dataList.size());
        }

        String originalString = this.dataList.get(idx);
        String newString = originalString + originalString; // Concatenate with itself
        
        this.dataList.set(idx, newString);
    }

    /**
     * Removes all elements from the list that contain the letter 'a' (case-insensitive).
     * This is a common interpretation of a 'Compact' or 'Filter' operation.
     */
    public void Compact() {
        // Using List.removeIf for efficient, safe removal during iteration (Java 8+)
        this.dataList.removeIf(s -> s.toLowerCase().contains("a"));

        /* // For older Java versions (< 8), use an Iterator:
        Iterator<String> iterator = this.dataList.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.toLowerCase().contains("a")) {
                iterator.remove();
            }
        }
        */
    }
    
    // Helper method for testing/debugging
    public List<String> getList() {
        return this.dataList;
    }
}
