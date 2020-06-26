package edu.cnm.deepdive;

public class Sorter {

  public static void merge(int[] data) {
    //split the array into two piles
    //is invoked the second method here (3 params)
   merge(data, 0, data.length);
  }
  public static void merge(int[] data, int from, int to){
    //sort from *0* up to *to*, but not including *to*
    if (to > from + 1) {

      int midpoint = (from + to) / 2;
      merge(data, from, midpoint);//now recurse.sort left pile.
      merge(data, midpoint, to);// sort right pile.

      int leftIndex = from;
      int rightIndex = midpoint;

      int[] merged = new int[to-from];//new array for elements sorted
      int mergedIndex = 0;

      while (leftIndex < midpoint && rightIndex < to){            //didn't rich the position in both side
        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex]; //comparing the value at the index position.
        if (leftValue <= rightValue) {
          merged[mergedIndex] = leftValue;//if is true then left value should go into my merged pile
          leftIndex++;
        }else {
          merged[mergedIndex] = rightValue;
          rightIndex++;
        }
        mergedIndex++; //add value to the merged array to have where to put the leftValue && rightValue.
      }
      if (leftIndex < midpoint) {                   //arraycopy copies the remained number value after another was added to the merged[]
        System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint - leftIndex);//copy everything what is in the left pile
        //midpoint - leftIndex - is the number of elements needed to be copied.
      } else {
        System.arraycopy(data, rightIndex, merged, mergedIndex, to - rightIndex);
      }
      System.arraycopy(merged, 0, data, from, merged.length);// merged.length = to - from exact number.
    }
  }
}
