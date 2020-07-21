package edu.cnm.deepdive;

public class Sorter {

  public static void merge(int[] data) {
    //split the array into two piles
    //is invoked the second method here (3 params)
    merge(data, 0, data.length);
  }

  public static void merge(int[] data, int from, int to) {
    //sort from *0* up to *to*, but not including *to*
    if (to > from + 1) {

      int midpoint = (from + to) / 2;
      merge(data, from, midpoint);//now recurse.sort left pile.
      merge(data, midpoint, to);// sort right pile.

      int leftIndex = from;
      int rightIndex = midpoint;

      int[] merged = new int[to - from];//new array for elements sorted
      int mergedIndex = 0;

      while (leftIndex < midpoint
          && rightIndex < to) {            //didn't rich the position in both side
        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex]; //comparing the value at the index position.
        if (leftValue <= rightValue) {
          merged[mergedIndex] = leftValue;//if is true then left value should go into my merged pile
          leftIndex++;
        } else {
          merged[mergedIndex] = rightValue;
          rightIndex++;
        }
        mergedIndex++; //add value to the merged array to have where to put the leftValue && rightValue.
      }
      if (leftIndex
          < midpoint) {         //arraycopy copies the remained number value after another was added to the merged[]
        System.arraycopy(data, leftIndex, merged, mergedIndex,
            midpoint - leftIndex);//copy everything what is in the left pile
        //midpoint - leftIndex - is the number of elements needed to be copied.
      } else {
        System.arraycopy(data, rightIndex, merged, mergedIndex, to - rightIndex);
      }
      System.arraycopy(merged, 0, data, from,
          merged.length);// merged.length = to - from exact number.
    }
  }

  public static void quickSort(int[] data) {
    quickSort(data, 0, data.length); //start at position 0 go at but not including data.length
  }

  public static void quickSort(int[] data, int fromIndex, int toIndex) {
    if (toIndex > fromIndex + 1) {
      int pivot = data[fromIndex];
      int partitionIndex = fromIndex;
      for (int i = fromIndex + 1; i < toIndex; i++) {       //compare the current value to pivot value
        int current = data[i];
        if (current <= pivot) {                             //next need to check the dividing line
          partitionIndex++;
          if (i > partitionIndex) {                         //need to swap the value at position i
            data[i] = data[partitionIndex];
            data[partitionIndex] = current;                   // at this moment we are done with partition
          }
        }
      }
      data[fromIndex] = data[partitionIndex];
      data[partitionIndex] = pivot;
      quickSort(data, fromIndex, partitionIndex);
      quickSort(data, partitionIndex + 1, toIndex);    //end of sort //with recursion we want a stop point.
    }
  }                  //quickSort method is good for memory, is sensitive to Malformed data.Used to sort Arrays
}                    // Merge sort takes more memory. Sorting lists
