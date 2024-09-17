/*

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>,Integer>dp=new HashMap<>();
        return findMinPrice(price,special,needs,dp);
        
    }

    public int findMinPrice(List<Integer> price, List<List<Integer>> special, List<Integer> needs,HashMap<List<Integer>,Integer>dp){

        int sum=0;
        if(dp.containsKey(needs))
            return dp.get(needs);
        for(int k=0;k<needs.size();k++){

                    sum+=(needs.get(k)*price.get(k));

                }
        
        for(int i=0;i<special.size();i++){
            int tempPrice=0;
            List<Integer>newNeeds=new ArrayList<>();
            boolean check=true;
            
            for(int j=0;j<needs.size();j++){
                int temp=needs.get(j)-special.get(i).get(j);
                if(temp>=0){

                    newNeeds.add(temp);

                }else{
                    check=!check;
                    break;
                }
            }
            if(!check){
                continue;
            }
               tempPrice= special.get(i).get(needs.size())+findMinPrice(price,special,newNeeds,dp);
              sum=Math.min(sum,tempPrice);
            
        }
        dp.put(needs,sum);
        return sum;

    }
}
*/



class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>,Integer>dp=new HashMap<>();
        return findMinPrice(price,special,needs,dp);
        
    }

    public int findMinPrice(List<Integer> price, List<List<Integer>> special, List<Integer> needs,HashMap<List<Integer>,Integer>dp){

        int sum=0;
        if(dp.containsKey(needs))
            return dp.get(needs);
        for(int k=0;k<needs.size();k++){

                    sum+=(needs.get(k)*price.get(k));

                }
        
        for(int i=0;i<special.size();i++){
            int tempPrice=0;
            List<Integer>newNeeds=new ArrayList<>();
            boolean check=true;
            
            for(int j=0;j<needs.size();j++){
                int temp=needs.get(j)-special.get(i).get(j);
                if(temp>=0){

                    newNeeds.add(temp);

                }else{
                    check=!check;
                    break;
                }
            }
            if(!check){
                continue;
            }
               tempPrice= special.get(i).get(needs.size())+findMinPrice(price,special,newNeeds,dp);
              sum=Math.min(sum,tempPrice);
            
        }
        dp.put(needs,sum);
        return sum;

    }
}
