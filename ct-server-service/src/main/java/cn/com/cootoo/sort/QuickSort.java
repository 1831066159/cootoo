package cn.com.cootoo.sort;

/**
 * 快速排序的时间复杂度是 O(nlogn),极端情况下会退化成 O(n2)
 * 空间复杂度为 O(1)。
 *
 * @author zhaoxiang
 * @create 2019/6/17
 **/
public class QuickSort {

    /**
     * 快速排序的核心思想也是分治法,分而治之。它的实现方式是每次从序列中选出一个基准值,
     * 其他数依次和基准值做比较,比基准值大的放右边,比基准值小的放左边,
     * 然后再对左边和右边的两组数分别选出一个基准值,进行同样的比较移动,
     * 重复步骤,直到最后都变成单个元素,整个数组就成了有序的序列。
     */
    public static void sort_quick(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //算法排序 切分 - 单边
        int pivotIndex = partition(arr, startIndex, endIndex);
        //算法排序 切分 - 双边
        // int pivotIndex = partition(arr, startIndex, endIndex);

        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 单边扫描
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//取基准值
        int mark = startIndex;//Mark初始化为起始下标

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                //小于基准值 则mark+1,并交换位置。
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //基准值与mark对应元素调换位置
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 双边扫描,切分后两边分别扫描
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];//取第一个元素为基准值

        while (true) {
            //从左往右扫描
            while (arr[left] <= pivot) {
                left++;
                if (left == right) {
                    break;
                }
            }

            //从右往左扫描
            while (pivot < arr[right]) {
                right--;
                if (left == right) {
                    break;
                }
            }

            //左右指针相遇
            if (left >= right) {
                break;
            }

            //交换左右数据
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        //将基准值插入序列
        int temp = arr[startIndex];
        arr[startIndex] = arr[right];
        arr[right] = temp;
        return right;
    }
}
