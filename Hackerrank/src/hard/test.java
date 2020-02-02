 public ArrayList<String> popularNFeatures(int numFeatures,
	                                         int topFeatures,
                                             List<String> possibleFeatures,
											 int numFeatureRequests,
											 List<String> featureRequests)
    {
        HashMap map = new HashMap<String, Integer>();
       for(String feature : possibleFeatures){
           map.put(feature,0);
       }
       for (String request: featureRequests){
           words = request.split("");
           for (String word: words){
               if map.contains("word"){
                 map.get("word")
               }
           }
       }

    }