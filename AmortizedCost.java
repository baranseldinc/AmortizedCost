
package amortizedcost;

import java.util.Random;

public class AmortizedCost {
    private int Array[];
    private int cursor;
    private int N_cost;
    public AmortizedCost() {
        Array = new int[1];
        cursor = 0;
    }
    public void add(int value) {
        if(cursor == Array.length) {
            resize();
            N_cost++;
            System.out.println("Dizi resize edildi ve maliyeti n olan eleman eklendi. Yeni Dizi Boyutu = "+Array.length);
        }
        this.Array[cursor] = value;
        cursor++;
    }
    public int getCursor() {
        return this.cursor;
    }
    public int getN_cost() {
        return this.N_cost;
    }
    public void resize() {
        int length = this.Array.length;
        int temp[] = new int[length];
        for(int i = 0;i<length;i++) temp[i] = this.Array[i];
        this.Array = new int[length*2];
        for(int i = 0;i<length;i++) this.Array[i] = temp[i];
    }
    
    public static void main(String[] args) {
        AmortizedCost ac = new AmortizedCost();
        Random rand = new Random();
        int eleman;
        for(int i = 0;i<1000;i++) {
            eleman = rand.nextInt(10);
            ac.add(eleman);
        }
        System.out.println("");
        System.out.println("Diziye 1000 eleman eklendi");
        System.out.println("Diziye O(1) Maliyette eklenen eleman sayisi: " + (ac.getCursor() - ac.getN_cost()));
        System.out.println("Diziye O(n) Maliyette eklenen eleman sayisi: " + ac.getN_cost());
        System.out.println("Dizi Resize sayisi: "+ac.getN_cost());
    }
    
}
