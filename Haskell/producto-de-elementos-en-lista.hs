-- producto de todos los elementos de una lista

productoLista :: [Int] -> Int
productoLista [] = 1
productoLista [x] = x
productoLista (x:xs) = x * (productoLista xs)

lst = [1,2,3]

main = print(productoLista lst)