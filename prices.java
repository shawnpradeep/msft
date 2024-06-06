class Prices {
    // K = cake -> (K = bakery -> double price)
`   HashMap<String, HashMap<String, Double>> map = new HashMap<>();
    // K: Cake -> V: Price
    HashMap<String, Double> cp = new HashMap<>();

    public void addPrice(String bakery, String cake, double price) {
        if (!map.contains(cake)) {
            map.put(cake, new HashMap<String, Double>());
            cp.put(cake, 0);
        } 

        double currentPrice = cp.get(cake);

        if (map.get(cake).containsKey(bakery)) {
            currentPrice -= map.get(cake).get(bakery);
        }

        currentPrice += price;
        cp.put(cake, currentPrice);
        map.get(cake).put(bakery, price);
    } //addPrice

    public double get_average_price(String cake) {
        if (!map.contains(cake)) return -1.0;

        HashMap<String, Double> cakePrices = map.get(cake);

        double avg = cp.get(cake);
        avg /= cakePrices.size();

        return avg;
    } //get_average_prices
} //Prices


/**
 *  map:
 *  chocalate -> [(b1, 11)];
 *  chocalate -> [(b1, 11), (b2, 12)]
 * 
 *  strawberry -> [(b2, 11.5)]
 *  chocalate -> [(b1, 11), (b2, 12)]
 * 
 *  strawberry -> [(b2, 11.5)]
 *  chocalate -> [(b1, 11), (b2, 13)]
 * 
 * 
 *  getavg:
 *  strawberry -> [(b2, 11.5)]
 *  
 *  avg = 0;
 *  avg = 11.5;
 *  avg /= 1;
 *  avg = 11.5;
 * 
 *  getavg:
 *  chocolate -> [(b1, 11), (b2, 13)]
 *  
 *  avg = 0;
 *  avg = 11;
 *  avg = 24;
 *  
 *  24 / 2 = 12.0;
 * 
 *  return 12.0;
 *  
 */