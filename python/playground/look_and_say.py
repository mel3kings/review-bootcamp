def ls(r, n):
    print('current iteration', n)
    letters = list(r)
    before = ""
    count = 0
    output = ""
    for current in letters:
        if before == "":
            before = current
        if current != before:
            output += str(count) + before
            count = 1
        else:
            count += 1
        before = current
    output += str(count) + before
    r = output
    if n > 1:
        ls(r, n - 1)
    else:
        print(r)
        return r



ls('11', 2)
# 211
