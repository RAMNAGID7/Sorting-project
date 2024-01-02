 // Assignment: 5
// Author: Ram Nagid, ID: 318692779
    public class hw5 {
     //possible main//
     public static void main(String[] args) {
         //Q1
         System.out.println(linearSearch(new String[]{"every moment", "of", "searching", "is a", "moment", "of encounter"}, "is a"));
         System.out.println();
         //Q2
         System.out.println(jumpSearch(new int[]{-15, -5, -2, 1, 3, 7, 15, 48, 97}, 15));
         System.out.println();
         //Q3
         System.out.println(ternarySearch(new int[]{-15, -5, -2, 1, 3, 7, 15, 48, 97}, 15));
         System.out.println();
         //Q4
         char[] arr = {'w', 't', 'p', 'm', 'l', 'k', 'e', 'e', 'a'};
         char x = 'e';
         int index = interpolationSearch(arr, x);
         if (index != -1) {
             System.out.println();
             System.out.println(index);
         } else {
             System.out.println(index);
         }
         System.out.println();
         //Q5
         int[] a = {21, 4, 19, 7, 13, 25, 15, 10, 24};
         //to see the array- //System.out.println(("a = " + Arrays.toString (a)));
         insertionSort(a);
         //to see the array after sort- //System.out.println(("a = " + Arrays.toString (a)));
         System.out.println();
         //Q6
         bubbleSort(new int[]{24, 10, 15, 25, 13, 7, 19, 4, 21});
     }

     public static int linearSearch(String[] s, String word) {
         for (int i = 0; i < s.length; i++) {
             if (word.equals(s[i])) {
                 System.out.println("The amount of unsuccessful comparisons I've made is " + i);
                 return i;
             }
         }
         return -1;
     }

     private static int linearSearch2(int[] s, int n, int step, int i, int count2) {
     int jumpscount = step / (int) Math.floor(Math.sqrt(s.length));
         if (i < step)
         {
             if (s[i] == n) {
                 count2++;
                 System.out.println("The amount of unsuccessful comparisons I've made is " + (count2 + jumpscount));
                 return i;
             }
            return linearSearch2(s, n, step, i + 1, count2 + 1);
         }
        return -1;
        }
        public static int jumpSearch(int[] numbers, int n) {
            int length = numbers.length;
            int step = (int) Math.floor(Math.sqrt(length));
            int count = 1;
            return jumpSearch(numbers, n, length, step, count);
        }
        private static int jumpSearch(int[] numbers, int n, int length, int step, int count) {
            if (step >= length-1) {
                return -1;
            }
            if (numbers [step]>n)
            {
                int i =step-((int) Math.floor(Math.sqrt(length)));
                int count2=0;
                return linearSearch2(numbers,n,step,i,count2);
            }
            if (numbers[0] == n) {
                System.out.print("The amount of unsuccessful comparisons I've made is 0");
                return 0;
            }
            if (numbers[step] == n) {
                System.out.println("The amount of unsuccessful comparisons I've made is " + count);
                return step;
            }
            return jumpSearch(numbers, n, length, step+ (int) Math.floor(Math.sqrt(length)), count + 1);
        }
        static int ternarySearch(int [] ar, int key) {
            int l = 0;
            int r = ar.length-1;
            while (r >= l) {
                int mid1 = l + (r - l) / 3;
                int mid2 = r - (r - l) / 3;
                if (ar[mid1] == key) {
                    return mid1;
                }
                if (ar[mid2] == key) {
                    return mid2;
                }
                if (key < ar[mid1]) {
                    r = mid1 - 1;
                } else if (key > ar[mid2]) {
                    l = mid2 + 1;
                } else {
                    l = mid1 + 1;
                    r = mid2 - 1;
                }
            }
            return -1;
        }
        public static int interpolationSearch (char [] arr,char key) {
            int low = arr.length - 1;
            int high = 0;
            int mid;
            int count = 0;
            while ((arr[high] != arr[low]) && (key >= arr[low]) && (key <= arr[high])) {
                mid = high + ((key - arr[high]) * (low - high) / (arr[low] - arr[high]));
                if (arr[mid] > key) {
                    count++;
                    low = mid - 1;
                }
                else if (key > arr[mid]) {
                    count++;
                    high = mid + 1;
                }
                if (arr[mid]==key){
                    System.out.print("The amount of unsuccessful equalization's I've made is " + count);
                    return mid;
                }
            }
            if (key == arr[low])
            {
                System.out.print("The amount of unsuccessful equalization's I've made is " + count);
                return low;
            }
            else {
                return -1;
            }
        }
        public static void insertionSort (int []numbers)
        {
            int count=0;
            for (int i = 1 ; i < numbers.length ; i++)
            {
                int value=numbers [i];
                while (i>0&&numbers[ i-1 ] < value ) {
                    numbers[i] = numbers[i-1];
                    count++;
                    i--;
                }
                numbers[i] = value;
            }
            System.out.println("The amount of exchanges I made between organs in the array is "+count);
        }
        public static void bubbleSort (int []numbers)
        {
            int numOfBbl = 0;
            int length=numbers.length-1;
            int i=(numbers.length*numbers.length);
            numOfBbl+=bubbleSort(0,length,numbers,i);
            System.out.println("The amount of exchanges I made between organs in the array is "+numOfBbl);
        }
        private static int bubbleSort (int numOfBbl,int length,int [] numbers,int i)
        {
            if (i==0)
            {
                return 0;
            }
            if (numOfBbl>=length)
            {
                return bubbleSort(0,length,numbers,i-(numbers.length));
            }
            if ( numbers[numOfBbl] > numbers[numOfBbl + 1])
            {
                int temp=numbers[numOfBbl];
                numbers[numOfBbl]=numbers[numOfBbl+1];
                numbers[numOfBbl+1]=temp;
                return bubbleSort(numOfBbl+1,length,numbers,i)+1;
            }
            return bubbleSort(numOfBbl+1,length,numbers,i);
        }
    }