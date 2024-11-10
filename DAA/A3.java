package DAA;
import java.util.*;
public class A3 {
    static Scanner sc = new Scanner(System.in);
    static class Item {
        int id;
        int weight;
        int profit;
        Item(int id, int w, int p) {
            this.id = id;
            this.weight = w;
            this.profit = p;
        }
    }
    public static void main(String []args) {
        System.out.println();
        System.out.println("Enter number of items and weight max capacity: ");
        int n=sc.nextInt();
        int w=sc.nextInt();
        ArrayList<Item> items = new ArrayList<>();
        System.out.println("Enter id,weight and value for product:");
        for(int i=0;i<n;i++)
        {
            items.add(new Item(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
       
       
        System.out.println("Items : ");
        System.out.println("id  weight  profit");
        for (Item i : items) {
            System.out.println(i.id+"     "+i.weight+"     "+i.profit);
        }
        Collections.sort(items, (a, b) -> (b.profit/b.weight)-(a.profit/a.weight));
        System.out.println("Sorted:");
        for (Item i : items) {
            System.out.println(i.id+"     "+i.weight+"     "+i.profit);
        }
        int profit = 0;
        System.out.println("Items bagged : ");
        System.out.println("id  weight  profit");
        for (int i = 0; i < items.size(); i++) {
            Item curr = items.get(i);
            if(curr.weight <= w) {
                w -= curr.weight;
                profit += curr.profit;
                System.out.println(curr.id+"     "+curr.weight+"     "+curr.profit);
            } else {
                if(w!=0)
                {
                int weight = curr.weight - w;
                System.out.println(curr.id+"     "+weight+"     "+((weight*curr.profit)/curr.weight));
                profit += ((weight*curr.profit)/curr.weight);
                }
                else{
                break;
                }
            }
        }
        System.out.println("Total Profit is : "+profit);
    }
}