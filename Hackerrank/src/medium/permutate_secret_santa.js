const registered = new Map();

function findUnmatchedCouples(people, couples) {
    const copy = [...people]
    if (copy.length == 0) {
        return;
    }
    const p = copy[0];
    copy.splice(0, 1);
    for (let i = 0; i < copy.length; i++) {
        const q = copy[i];
        if (matchedThisRound.has(p)) {
            continue;
        }
        if (!isCouple(p, q)) {
            copy.splice(i, 1);
            findUnmatchedCouples(copy, couples);
            couples.push([p, q]);
            matchedThisRound.add(p);
            registerCouple(p, q)
        }
    }
    return couples;
}

function isCouple(p, q) {
    if (!registered.has(p)) {
        return false;
    } else {
        const currentset = registered.get(p)
        if (currentset.has(q)) {
            //console.log(`${p} already matched with ${q}`)
            return true;
        }
        currentset.add(q)
        registered.set(p, currentset)
    }
    return false;
}

function registerCouple(p, q) {
    if (!registered.has(p)) {
        registered.set(p, new Set([q]))
    } else {
        const currentset = registered.get(p)
        currentset.add(q)
        registered.set(p, currentset)
    }
}

//Start Secret Santa
const people = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
for (let i = 0; i < 10; i++) {
    matchedThisRound = new Set([]);
    console.log(`round ${i}`)
    console.log(findUnmatchedCouples(people, []))
}

