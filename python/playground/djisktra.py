import math


def djikstra(current, to):
    if current == to:
        route_map[to] = current
        print(route_map)
        print(current_running_cost)
    if current in neighbors_map:
        smallest = min(neighbors_map[current], key=neighbors_map[current].get)
        smallest_values = neighbors_map[current][smallest]
        if current_running_cost[smallest] > smallest_values:
            current_running_cost[smallest] = smallest_values
            route_map[current] = smallest
        djikstra(smallest, to)
    print("finding")


neighbors_map = {"A": {"B": 10, "C": 1},
                 "B": {"D": 1},
                 "C": {"D": 1},
                 }
route_map = {"A": "A",
             "B": "A",
             "C": "A",
             "D": None}
current_running_cost = {
    "A": 0,
    "B": math.inf,
    "C": math.inf,
    "D": math.inf,
}
djikstra("A", "D")

#
#   10  1
# A - B - D
#  1\ C - E - 1
