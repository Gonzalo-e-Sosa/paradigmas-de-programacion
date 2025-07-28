-- invertir una lista

invertirLista :: [Int] -> [Int]

invertirLista [x] = [x]
invertirLista (x:xs) = (invertirLista xs)++[x] 

lst = [1,2,3]

main = print(invertirLista lst)