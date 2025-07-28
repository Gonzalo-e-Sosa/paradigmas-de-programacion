-- eliminar duplicados de una lista 

elementoEnLista :: Int -> [Int] -> Bool
elementoEnLista x [] = False
elementoEnLista x xs = if x == head xs
then True
else elementoEnLista x (tail xs)

eliminarDuplicadosLista :: [Int] -> [Int]
eliminarDuplicadosLista [] = []
eliminarDuplicadosLista [x] = [x]
eliminarDuplicadosLista (x:xs) = if elementoEnLista x xs
then eliminarDuplicadosLista xs
else x:eliminarDuplicadosLista xs

lst = [1,2,3,4,23,4,2]

main = print(eliminarDuplicadosLista lst)