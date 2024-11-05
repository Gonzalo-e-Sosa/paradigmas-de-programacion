-- division por restas sucesivas

division :: Int -> Int -> Int
division a b = if a < b
then 0
else (division (a-b) b) + 1 

main = print(division 99 3)