-- encontrar el elemento mínimo en una lista

encontrarMinimo :: [Int] -> Int
encontrarMinimo [x] = x
encontrarMinimo (x:y:xs) = if x < y 
then encontrarMinimo(x:xs)
else encontrarMinimo(y:xs)
 
lst = [1,2,-100,4,-3]
 
main = print(encontrarMinimo lst)