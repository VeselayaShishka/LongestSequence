package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String list = "942517\n" +
                "605676\n" +
                "498291\n" +
                "668826\n" +
                "357057\n" +
                "478151\n" +
                "315629\n" +
                "007148\n" +
                "252887\n" +
                "421662\n" +
                "284505\n" +
                "467650\n" +
                "115330\n" +
                "648206\n" +
                "207562\n" +
                "612298\n" +
                "576885\n" +
                "294200\n" +
                "847595\n" +
                "021597\n" +
                "074878\n" +
                "801997\n" +
                "585401\n" +
                "168510\n" +
                "385293\n" +
                "151863\n" +
                "022142\n" +
                "340350\n" +
                "976151\n" +
                "337989\n" +
                "863284\n" +
                "488310\n" +
                "303887\n" +
                "939173\n" +
                "331413\n" +
                "905657\n" +
                "833617\n" +
                "170794\n" +
                "094486\n" +
                "551394\n" +
                "943693\n" +
                "147970\n" +
                "400196\n" +
                "537505\n" +
                "367493\n" +
                "117178\n" +
                "675840\n" +
                "868721\n" +
                "519081\n" +
                "735564\n" +
                "401733\n" +
                "915348\n" +
                "169233\n" +
                "324651\n" +
                "958675\n" +
                "368753\n" +
                "861460\n" +
                "401341\n" +
                "343222\n" +
                "794373\n" +
                "816374\n" +
                "535119\n" +
                "188234\n" +
                "577779\n" +
                "097792\n" +
                "729303\n" +
                "782637\n" +
                "148159\n" +
                "830641\n" +
                "716890\n" +
                "397853\n" +
                "871196\n" +
                "277603\n" +
                "749226\n" +
                "839595\n" +
                "131852\n" +
                "409432\n" +
                "810698\n" +
                "456030\n" +
                "529185\n" +
                "758823\n" +
                "265024\n" +
                "051041\n" +
                "699031\n" +
                "737269\n" +
                "139340\n" +
                "730977\n" +
                "249786\n" +
                "039931\n" +
                "055669\n" +
                "100107\n" +
                "653178\n" +
                "279773\n" +
                "336550\n" +
                "332847\n" +
                "685485\n" +
                "423269\n" +
                "193536\n" +
                "890062\n" +
                "377637\n" +
                "595777\n" +
                "412134\n" +
                "322736\n" +
                "546929\n" +
                "616370\n" +
                "767332\n" +
                "781184\n" +
                "920944\n" +
                "851005\n" +
                "258850\n" +
                "064083\n" +
                "051202\n" +
                "427711\n" +
                "359855\n" +
                "540928\n" +
                "314284\n" +
                "085261\n" +
                "880969\n" +
                "649699\n" +
                "064881\n" +
                "705423\n" +
                "646927\n" +
                "252556\n" +
                "272007\n" +
                "217511\n" +
                "620286\n" +
                "229724\n" +
                "108865\n" +
                "124636\n" +
                "231417\n" +
                "961201\n" +
                "658432\n" +
                "775416\n" +
                "246027\n" +
                "854036\n" +
                "687762\n" +
                "389097\n" +
                "013153\n" +
                "417085\n" +
                "919198\n" +
                "988711\n" +
                "488665";


        List<Node> nodes = new ArrayList<>();

        for (String value : list.trim().split("\\s+")) {
            nodes.add(new Node(value));
        }
        for (Node node : nodes) {
            node.evaluate(nodes);
        }

        List<Node> bestPath = new ArrayList<>();

        for (Node start : nodes) {
            boolean[] visited = new boolean[nodes.size()];
            List<Node> path = new ArrayList<>();

            depthFirstSearch(start, visited, path, bestPath);
        }

        System.out.println("Кількість вузлів: " + bestPath.size());
        System.out.println("Ланцюжок вузлів:");

        for (Node node : bestPath) {
            System.out.println(node.value);
        }

        if (!bestPath.isEmpty()) {
            StringBuilder result =
                    new StringBuilder(bestPath.get(0).value);

            for (int i = 1; i < bestPath.size(); i++) {
                result.append(bestPath.get(i).value.substring(2));
            }

            System.out.println("Послідовність:");
            System.out.println(result);
            System.out.println("Довжина: " + result.length());
        }

    }

    static void depthFirstSearch(
            Node current,
            boolean[] visited,
            List<Node> path,
            List<Node> bestPath
    ) {
        visited[current.index] = true;
        path.add(current);

        if (path.size() > bestPath.size()) {
            bestPath.clear();
            bestPath.addAll(path);
        }

        for (Node next : current.next) {
            if (!visited[next.index]) {
                depthFirstSearch(next, visited, path, bestPath);
            }
        }

        path.remove(path.size() - 1);
        visited[current.index] = false;
    }
}

class Node {
    final int index;
    final String value;
    final String firstTwo;
    final String lastTwo;
    final List<Node> next = new ArrayList<>();

    private static int nextIndex = 0;

    Node(String value) {
        this.index = nextIndex++;
        this.value = value;
        this.firstTwo = value.substring(0, 2);
        this.lastTwo = value.substring(value.length() - 2);
    }

     public void evaluate(List<Node> nodes){
        for(Node n2 : nodes){
            if(this.lastTwo.equals(n2.firstTwo)){
                this.next.add(n2);
            }
        }
    }
}
