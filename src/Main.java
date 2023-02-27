import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> mas = new ArrayList<>();
        mas.add(1);
        mas.add(2);
        mas.add(3);
        mas.add(4);
        mas.add(5);
        mas.add(6);
        mas.add(7);
        mas.add(8);
        mas.add(9);

        BinSearch(0,7,mas,7);
        System.out.println(BinSearch(0,10,mas,7));
    }
    public static <T extends Comparable> int BinSearch(int left, int right, ArrayList<T> mas, T data){
        while(right-left>1){
            int mid = (left+right)/2;
            if(mas.get(mid).compareTo(data)>0){
                right=mid;
            }
            else if(mas.get(mid).compareTo(data)<0){
                left=mid;
            }
            else{
                return mid;
            }
        }
        if(mas.get(left)!=data) return -1;
        return left;
    }
}