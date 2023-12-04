parse_these = ["1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"]
numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
global sum = 0
for i in parse_these
    m = findall(r"[^a-zA-Z]", i)
    if length(m) > 1
        global sum += Int(first(m))
    else
        global sum += Int(first(m) + last(m))
    end
    # latter = findlast(r"[^a-zA-Z]", i)
    
    # latter = last(match(r"[^a-zA-Z]", i))
    println(m)
    # sum += Int(former + latter)
end
println(sum)
