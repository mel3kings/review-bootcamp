def popularNFeatures(numFeatures, topFeatures, possibleFeatures,
                     numFeatureRequests, featureRequests):
    # WRITE YOUR CODE HERE
    feature_map = {}
    for possible in possibleFeatures:
        feature_map[possible] = 0
    for words in featureRequests:
        for words_in_request in words.split():
            processed = []
            if words_in_request in feature_map and words_in_request not in processed:
                processed.append(words_in_request)
                feature_map[words_in_request] += 1
    test = sorted(feature_map, key=feature_map.get, reverse=True)[:topFeatures]
    print(test)
    return test
    pass


popularNFeatures(2, 2, ['anacell'], 5, [''])
