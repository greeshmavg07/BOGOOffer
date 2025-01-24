import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOGOOffer {

    public static void main(String[] args) {
        List<Integer> productPricesList = Arrays.asList(70, 20, 30, 40, 50, 60,100);
        OfferResponseBody response = calculateOffer(productPricesList);
        System.out.println("Discounted Items (Free): " + response.discountedItems);
        System.out.println("Payable Items: " + response.payableItems);
    }

    public static OfferResponseBody calculateOffer(List<Integer> productPricesList) {
        List<Integer> sortedPricesList = new ArrayList<>(productPricesList);
        Collections.sort(sortedPricesList, Collections.reverseOrder());

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        for (int i = 0; i < sortedPricesList.size(); i++) {
            if (i % 2 == 0) {
                payableItems.add(sortedPricesList.get(i));
            } else {
                discountedItems.add(sortedPricesList.get(i));
            }
        }

        return new OfferResponseBody(discountedItems, payableItems);
    }
}

class OfferResponseBody {
    List<Integer> discountedItems;
    List<Integer> payableItems;

    public OfferResponseBody(List<Integer> discountedItems, List<Integer> payableItems) {
        this.discountedItems = discountedItems;
        this.payableItems = payableItems;
    }
}