// There are n cities connected by some number of flights. You are given an array flights where 
// flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with
//  cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at
//  most k stops. If there is no such route, return -1.

 

// Example 1:


// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.


class Solution {

    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    class Tuple{
        int stops;
        int nodee;
        int price;

        Tuple(int stops, int nodee, int price){
            this.stops = stops;
            this.nodee = nodee;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue <Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        dist[src] = 0;

        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stop = it.stops;
            int node = it.nodee;
            int cost = it.price;

            if(stop > k) continue;

            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int costt = iter.second;

                if(cost + costt < dist[adjNode] && stop <= k){
                    dist[adjNode] = cost + costt;
                    q.add(new Tuple(stop + 1, adjNode, cost + costt));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}