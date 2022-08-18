package hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class first_second_hws {
        public static void main(String[] args) {

        }
        public static <T> void swap(T[] array,int a,int b){
            T temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
        public static <T> ArrayList<T> changetoArrayList(T[] array){
            return new ArrayList<>(Arrays.asList(array));
        }
    }
