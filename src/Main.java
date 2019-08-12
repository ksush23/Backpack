import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double w = scanner.nextInt();

        ArrayList items = new ArrayList();
        for (int i = 0; i < n; i++){
            double c = scanner.nextDouble();
            double v = scanner.nextDouble();

            Item item = new Item(c, v);
            items.add(item);
        }

        System.out.printf("%.3f", MaxPrice(w, items));
    }
    
    public static double MaxPrice(double w, ArrayList items){
        double result = 0;
        Item item;
        int index = 0;
        double currWeight = 0;

        while(currWeight < w && items.size() > 0)
        {
            double max = -1;
            for (int i = 0; i < items.size(); i++){
                item = (Item)items.get(i);
                if (item.getCost() > max)
                {
                    max = item.getCost();
                    index = i;
                }
            }

            item = (Item)items.get(index);
            double weight = item.getWeight();
            double price = item.getPrice();
            double cost = item.getCost();
            if (weight + currWeight > w) {
                result += (w - currWeight) * cost;
                currWeight += w - currWeight;
            }
            else
            {
                result += price;
                currWeight += weight;
            }

            items.remove(index);
        }

        return result;
    }
}

class Item
{
    private double weight;
    private double price;
    private double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item(double c, double w)
    {
        price = c;
        weight = w;
        cost = c / w;
    }
}
