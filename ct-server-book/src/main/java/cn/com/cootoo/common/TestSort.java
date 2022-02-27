package cn.com.cootoo.common;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author system
 * @create 2018/10/24
 **/
public class TestSort {


    public static void main1(String[] args) {
        List list = new ArrayList<>();
        list.add(13);
        list.add(3);
        list.add(8);
        list.add(23);
        list.add(5);
        list.add(35);

        List<Integer> res = quickSort(list);
        for (Integer i : res) {
            System.out.println(i);
        }

    }

    public static List<Integer> quickSort(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        List sortList = new ArrayList<>();
        int seed = list.get(0);
        List<Integer> listMin = new ArrayList<>();
        List<Integer> listMax = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < seed) {
                listMin.add(list.get(i));
            } else {
                listMax.add(list.get(i));
            }
        }
        sortList.addAll(quickSort(listMin));
        sortList.add(seed);
        sortList.addAll(quickSort(listMax));
        return sortList;

    }


    public static void main(String[] args) {


        Integer[] arr1 = {1, 3, 5, 7, 9,2,4,6,8,10};




    }


    public void qsort(int[] arr,int low,int high){


        if(low>high){
            return;
        }



    }





}

