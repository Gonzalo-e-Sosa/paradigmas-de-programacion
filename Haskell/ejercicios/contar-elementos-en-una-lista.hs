-- contar cantidad de elementos en una lista

contarElementos :: [Int] -> Int
contarElementos [] = 0
contarElementos [x] = 1
contarElementos (x:xs) = 1 + contarElementos xs 

lst = [1,2,3,4,5,6,7,6,4]

main = print(contarElementos lst)