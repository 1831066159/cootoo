package cn.com.cootoo.graph.sort;

/**
 * @author zhaoxiang
 * @create 2019/6/17
 **/
public class SortSolutions {


    public static void main(String[] args) {
        int[] nums = {8, 2, 5, 9, 7};
        int[] nums2 = {7, 2, 5, 9, 8, 10, 1, 15, 12, 3};


        int[] res = sort_insert(nums);
        for (int i : res) {
            System.out.println(i);
        }

    }

    /**
     * 冒泡
     * 冒泡排序无疑是最为出名的排序算法之一,从序列的一端开始往另一端冒泡（你可以从左往右冒泡,
     * 也可以从右往左冒泡,看心情）,依次比较相邻的两个数的大小（到底是比大还是比小也看你心情）。
     * 冒泡的代码还是相当简单的,两层循环,外层冒泡轮数,里层依次比较,江湖中人人尽皆知。
     * 算法的时间复杂度为O(n2)。
     *
     * @param arr
     */
    public static void sort_bubble(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 选择排序的思路是这样的：
     * 首先,找到数组中最小的元素,拎出来,将它和数组的第一个元素交换位置,
     * 第二步,在剩下的元素中继续寻找最小的元素,拎出来,和数组的第二个元素交换位置,如此循环,直到整个数组排序完成。
     * <p>
     * 至于选大还是选小,这个都无所谓,你也可以每次选择最大的拎出来排,
     * 也可以每次选择最小的拎出来的排,只要你的排序的手段是这种方式,都叫选择排序。
     *
     * @param arr
     */
    public static void sort_chose(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;//最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;//找最小值
                }
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * 插入排序
     * 插入排序的思想和我们打扑克摸牌的时候一样,从牌堆里一张一张摸起来的牌都是乱序的,
     * 我们会把摸起来的牌插入到左手中合适的位置,让左手中的牌时刻保持一个有序的状态。
     * <p>
     * 那如果我们不是从牌堆里摸牌,而是左手里面初始化就是一堆乱牌呢？
     * 一样的道理,我们把牌往手的右边挪一挪,把手的左边空出一点位置来,然后在乱牌中抽一张出来,
     * 插入到左边,再抽一张出来,插入到左边,再抽一张,插入到左边,
     * 每次插入都插入到左边合适的位置,时刻保持左边的牌是有序的,直到右边的牌抽完,则排序完毕。
     *
     * @param arr
     * @return
     */
    public static int[] sort_insert(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j + 1] = value; //插入数据
        }
        return arr;
    }

    /**
     * 希尔排序这个名字,来源于它的发明者希尔,也称作“缩小增量排序”,是插入排序的一种更高效的改进版本。
     * <p>
     * 我们知道,插入排序对于大规模的乱序数组的时候效率是比较慢的,因为它每次只能将数据移动一位,
     * 希尔排序为了加快插入的速度,让数据移动的时候可以实现跳跃移动,节省了一部分的时间开支。
     * <p>
     * 为什么区间要以 gap = gap*3 + 1 去计算,其实最优的区间计算方法是没有答案的,这是一个长期未解决的问题,不过差不多都会取在二分之一到三分之一附近。
     */
    public static void sort_xier(int[] arr) {
        int length = arr.length;
        //区间
        int gap = 1;
        while (gap < length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                //跨区间排序
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = gap / 3;
        }
    }




    /**
     * 计数排序是一种非基于比较的排序算法，
     * 我们之前介绍的各种排序算法几乎都是基于元素之间的比较来进行排序的，
     * 计数排序的时间复杂度为 O(n + m )，m 指的是数据量，说的简单点，计数排序算法的时间复杂度约等于 O(n)，快于任何比较型的排序算法。
     */
    public static void sort_count(int[] arr) {
        //找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //初始化计数数组
        int[] countArr = new int[max + 1];

        //计数
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
            arr[i] = 0;
        }

        //排序
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                arr[index++] = i;
            }
        }
    }

}
